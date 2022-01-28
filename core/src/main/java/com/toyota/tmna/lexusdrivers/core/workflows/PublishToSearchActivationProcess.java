package com.toyota.tmna.lexusdrivers.core.workflows;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.toyota.tmna.lexusdrivers.core.search.domain.Rewards;
import com.toyota.tmna.lexusdrivers.core.search.domain.Stories;
import com.toyota.tmna.lexusdrivers.core.search.domain.Videos;
import com.toyota.tmna.lexusdrivers.core.search.services.*;

import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.toyota.tmna.lexusdrivers.core.search.domain.Disclaimer;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

@Component(service = WorkflowProcess.class, property = {
        "process.label=" + "Publish To Search Activation Process"}, immediate = true)
public class PublishToSearchActivationProcess implements WorkflowProcess {

    private final Logger log = LoggerFactory.getLogger(PublishToSearchActivationProcess.class);

    @Reference
    private DisclaimerService disclaimerService;
    @Reference
    private RewardsService rewardsService;
    @Reference
    private StoriesService storiesService;
    @Reference
    private VideosService videosService;

    @Reference
    private WaldoService waldoService;

    @Override
    public void execute(@NotNull WorkItem workItem, @NotNull WorkflowSession workflowSession, MetaDataMap metaDataMap)
            throws WorkflowException {
        log.info("PublishToSearchActivationProcess process Started");
        try {
            String path = workItem.getWorkflowData().getPayload().toString();
            ResourceResolver resourceResolver = workflowSession.adaptTo(ResourceResolver.class);
            if (path.contains("lexusdrivers/benefits/experiences/experiences-details") || path.contains("lexusdrivers/benefits/rewards-and-events") || path.contains("lexusdrivers/resources/videos/video-details") || path.contains("/content-fragments/disclaimers")) {
                Resource experiencesResource = Objects.requireNonNull(resourceResolver).getResource(path);
                assert experiencesResource != null;
                if (experiencesResource.getPath().equalsIgnoreCase("/content/dam/lexusdrivers/content-fragments/disclaimers")) {
                    executeMultiDisclaimerUpload(experiencesResource, resourceResolver);
                } else if (experiencesResource.getPath().contains("lexusdrivers/content-fragments/disclaimers/")) {
                    executeSingleDisclaimerUpload(experiencesResource, resourceResolver);
                }
                if (experiencesResource.listChildren().hasNext() && Objects.requireNonNull(experiencesResource.listChildren().next().getParent()).getPath().endsWith("details")) {
                    executeMultiUpload(experiencesResource, resourceResolver, path);
                } else {
                    executeSingleUpload(resourceResolver, path);
                }
            }
        } catch (RepositoryException e) {
            log.info("PublishToSearchActivationProcess has thrown repository exception" + e.getMessage());
        }
    }

    private void executeSingleDisclaimerUpload(@NotNull Resource experiencesResource, ResourceResolver resourceResolver) throws RepositoryException {
        Node disclaimerNode = experiencesResource.adaptTo(Node.class);
        if (disclaimerNode != null && disclaimerNode.getPrimaryNodeType().getName().equalsIgnoreCase("dam:Asset"))
            disclaimerService.uploadDisclaimer(populateDisclaimer(Objects.requireNonNull(resourceResolver), disclaimerNode.getPath()));
    }

    private void executeMultiDisclaimerUpload(@NotNull Resource experiencesResource, ResourceResolver resourceResolver) throws RepositoryException {
        Node disclaimerNode = experiencesResource.adaptTo(Node.class);
        NodeIterator nIt = disclaimerNode != null ? disclaimerNode.getNodes() : null;
        while (nIt != null && nIt.hasNext()) {
            Node childNode = (Node) nIt.next();
            if (childNode.getPrimaryNodeType().getName().equalsIgnoreCase("dam:Asset"))
                disclaimerService.uploadDisclaimer(populateDisclaimer(Objects.requireNonNull(resourceResolver), childNode.getPath()));
        }
    }

    private void executeMultiUpload(@NotNull Resource resourcePage, ResourceResolver resourceResolver, String path) {
        Iterator<Resource> it = resourcePage.listChildren();
        while (it.hasNext()) {
            try {
                String resourcePath = it.next().getPath();
                if (validateRewardsPath(path)) {
                    log.info("Rewards upload started");
                    rewardsService.uploadRewards(populateRewards(Objects.requireNonNull(resourceResolver), resourcePath));
                }

                if (path.contains("/experiences-details")) {
                    log.info("Stories upload started");
                    storiesService.uploadStories(populateStories(Objects.requireNonNull(resourceResolver), resourcePath));
                }
                if (path.contains("/video-details")) {
                    log.info("videos upload started");
                    videosService.uploadVideos(populateVideos(Objects.requireNonNull(resourceResolver), resourcePath));
                }
            } catch (ParseException | RepositoryException | IOException e) {
                log.info("Fail to upload the data on cloud search" +e.getMessage());
            }
            log.info("PublishToSearchActivationProcess process completed");
        }

    }

    private void executeSingleUpload(ResourceResolver resourceResolver, String path) {
        try {
            if (validateRewardsPath(path)) {
                log.info("Rewards upload started");
                rewardsService.uploadRewards(populateRewards(Objects.requireNonNull(resourceResolver), path));
            }

            if (path.contains("/experiences-details")) {
                log.info("Stories upload started");
                storiesService.uploadStories(populateStories(Objects.requireNonNull(resourceResolver), path));
            }
            if (path.contains("/video-details")) {
                log.info("videos upload started");
                videosService.uploadVideos(populateVideos(Objects.requireNonNull(resourceResolver), path));
            }
        } catch (ParseException | RepositoryException | IOException e) {
            log.info("Fail to upload the data on cloud search" +e.getMessage());
        }
    }

    private @NotNull List<String> setListValue(String value) {
        List<String> list = new ArrayList<String>();
        list.add(value);
        return list;
    }

    private @NotNull List<Integer> setListIntValue(Integer value) {
        List<Integer> list = new ArrayList<Integer>();
        if (value != null) {
            list.add(value);
        }
        return list;
    }

    private @NotNull Disclaimer populateDisclaimer(ResourceResolver resourceResolver, String path) {
        ValueMap vm = getValueMap(resourceResolver, path, ConstantsUtil.DISCLAIMERS_MASTER_NODE);
        assert vm != null;
        Disclaimer disclaimerUpload = new Disclaimer();
        disclaimerUpload.setId(setListValue(extractValue(vm, "Name")));
        disclaimerUpload.setDescription(setListValue(extractValue(vm, "Description")));
        return disclaimerUpload;
    }

    private @NotNull Stories populateStories(ResourceResolver resourceResolver, String path) throws ParseException, RepositoryException, JsonProcessingException {
        ValueMap vm = getValueMap(resourceResolver, path, ConstantsUtil.STORIES_WRAPPER);
        Stories storiesUpload = new Stories();
        assert vm != null;
        storiesUpload.setId(setListValue(extractValue(vm, "id")));
        storiesUpload.setTitle(setListValue(extractValue(vm, "title")));
        storiesUpload.setSection_type(setListValue(extractValue(vm, "category_type")));
        storiesUpload.setCategory(setListValue(extractValue(vm, "category_list")));
        storiesUpload.setPartner_name(setListValue(extractValue(vm, "partner_name")));
        storiesUpload.setShort_description(setListValue(extractValue(vm, "short_description")));
        storiesUpload.setLong_description(setListValue(extractValue(vm, "long_description")));
        storiesUpload.setDesktop_hero_image(setListValue(extractValue(vm, "desktop_hero_image")));
        storiesUpload.setMobile_hero_image(setListValue(extractValue(vm, "mobile_hero_image")));
        storiesUpload.setTablet_hero_image(setListValue(extractValue(vm, "tablet_hero_Image")));
        storiesUpload.setDesktop_thumbnail_image(setListValue(extractValue(vm, "desktop_thumbnail_image")));
        storiesUpload.setMobile_thumbnail_image(setListValue(extractValue(vm, "mobile_thumbnail_image")));
        storiesUpload.setTablet_thumbnail_image(setListValue(extractValue(vm, "tablet_thumbnail_image")));
        storiesUpload.setVideo_url(setListValue(extractValue(vm, "video_url")));
        storiesUpload.setRotational_banner_section(setListValue(getStoriesRotationalBannerImageValues(resourceResolver, path)));
        storiesUpload.setSecondary_description(setListValue(getSecondaryDesc(resourceResolver, path)));
        storiesUpload.setPublish_date(setListValue(toUTCDate(extractValue(vm, "published_date"))));
        storiesUpload.setDisplay_start_date(setListValue(toUTCDate(extractValue(vm, "display_startdate"))));
        storiesUpload.setEffective_start_date(setListValue(toUTCDate(extractValue(vm, "effective_startdate"))));
        storiesUpload.setIs_featured(setListValue(extractValue(vm, "is_featured")));
        storiesUpload.setGlobal_featured(setListValue(extractValue(vm, "global_featured")));
        storiesUpload.setSeo_description(setListValue(extractValue(vm, "seo_description")));
        storiesUpload.setSeo_title(setListValue(extractValue(vm, "seo_title")));
        storiesUpload.setSeo_key(setListValue(extractValue(vm, "seo_key")));
        storiesUpload.setMeta_tags(setListValue(extractValue(vm, "meta_tags")));
        storiesUpload.setEffective_end_date(setListValue(toUTCDate(extractValue(vm, "effective_enddate"))));
        storiesUpload.setRelated_section_title(setListValue(extractValue(vm, "Related_section_title")));

        return storiesUpload;
    }

    private String extractValue(@NotNull ValueMap vm, String key) {
        return vm.containsKey(key) ? vm.get(key).toString() : StringUtils.EMPTY;
    }

    private static @NotNull String toUTCDate(String date) throws ParseException {
        return (!StringUtils.isEmpty(date)) ? new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                .format(new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").parse(date)) : "2000-01-18T00:00:00Z";
    }

    private @NotNull Rewards populateRewards(ResourceResolver resourceResolver, String path) throws ParseException, RepositoryException, IOException {
        ValueMap vm = getValueMap(resourceResolver, path, ConstantsUtil.REWARDS_WRAPPER);
        Rewards rewardsUpload = new Rewards();
        assert vm != null;
        rewardsUpload.setId(setListValue(extractValue(vm, "id")));
        rewardsUpload.setTitle(setListValue(extractValue(vm, "title")));
        rewardsUpload.setHeading(setListValue(extractValue(vm, "heading")));
        String categoryType = extractValue(vm, "category_type");
        rewardsUpload.setCategory_type(setListValue(categoryType));
        if ("Events".equalsIgnoreCase(categoryType)) {
            rewardsUpload.setCategory_list(setListValue(categoryType));
        } else {
            rewardsUpload.setCategory_list(setListValue(extractValue(vm, "category_list")));
        }
        rewardsUpload.setPartner_name(setListValue(extractValue(vm, "partner_name")));
        rewardsUpload.setPartner_logo(setListValue(extractValue(vm, "partner_logo")));
        rewardsUpload.setShort_description(setListValue(extractValue(vm, "short_description")));
        rewardsUpload.setDetail_description(setListValue(extractValue(vm, "detail_description")));
        rewardsUpload.setAddress_line_one(setListValue(extractValue(vm, "address_line_one")));
        rewardsUpload.setAddress_line_two(setListValue(extractValue(vm, "address_line_two")));
        rewardsUpload.setEmail(setListValue(extractValue(vm, "rewardsemail")));
        rewardsUpload.setRotational_banner_section(setListValue(getRewardsRotationalBannerImageValues(resourceResolver, path)));
        rewardsUpload.setCity(setListValue(extractValue(vm, "city")));
        rewardsUpload.setState(setListValue(extractValue(vm, "state")));
        rewardsUpload.setZip_code(setListValue(extractValue(vm, "zip_code")));
        rewardsUpload.setPhone(setListValue(extractValue(vm, "phone")));
        rewardsUpload.setWebsite(setListValue(extractValue(vm, "website")));
        rewardsUpload.setDesktop_hero_img(setListValue(extractValue(vm, "desktop_hero_img")));
        rewardsUpload.setMobile_hero_img(setListValue(extractValue(vm, "mobile_hero_img")));
        rewardsUpload.setTab_hero_img(setListValue(extractValue(vm, "tab_hero_img")));
        rewardsUpload.setDesktop_thumb_img(setListValue(extractValue(vm, "desktop_thumb_img")));
        rewardsUpload.setMobile_thumb_img(setListValue(extractValue(vm, "mobile_thumb_img")));
        rewardsUpload.setTab_thumb_img(setListValue(extractValue(vm, "tab_thumb_img")));

        rewardsUpload.setPublish_date(setListValue(toUTCDate(extractValue(vm, "publish_date"))));
        rewardsUpload.setDisplay_start_date(setListValue(toUTCDate(extractValue(vm, "display_start_date"))));
        rewardsUpload.setEffective_end_date(setListValue(toUTCDate(extractValue(vm, "effective_end_date"))));
        rewardsUpload.setEffective_start_date(setListValue(toUTCDate(extractValue(vm, "effective_start_date"))));
        rewardsUpload.setIs_featured(setListValue(extractValue(vm, "is_featured")));
        rewardsUpload.setGlobal_featured(setListValue(extractValue(vm, "global_featured")));
        rewardsUpload.setSeo_description(setListValue(extractValue(vm, "seoDescription")));
        rewardsUpload.setSeo_title(setListValue(extractValue(vm, "seoTitle")));
        String zipCode = extractValue(vm, "zip_code");
        String latitude;
        String longitude;
        log.info("before waldo");

        if (StringUtils.isNotBlank(zipCode) && !zipCode.equals("00000")) {
            String latLan = waldoService.getLatlang(zipCode);
            log.info("inside waldo");
            JsonElement jsonElement = new JsonParser().parse(latLan);
            latitude = jsonElement.getAsJsonObject().get("latitude").getAsString();
            longitude = jsonElement.getAsJsonObject().get("longitude").getAsString();
            rewardsUpload.setLat_lan(setListValue(latitude + "," + longitude));
        }
        log.info("after waldo");
        rewardsUpload.setThumbnail_video(setListValue(extractValue(vm, "thumbnail_video")));
        rewardsUpload.setAlt_text(setListValue(extractValue(vm, "alt_text")));
        rewardsUpload.setRewards_redemption(setListValue(getRewardsRedemptionData(resourceResolver, path)));
        rewardsUpload.setBenefit_type(setListValue(getBenefitTypeData(resourceResolver, path)));
        rewardsUpload.setMeta_tags(setListValue(extractValue(vm, "metaTags")));
        rewardsUpload.setSeo_key(setListValue(extractValue(vm, "seo_key")));
        rewardsUpload.setClaim_cta(setListValue(extractValue(vm, "claim_CTA")));
        rewardsUpload.setClaim_link(setListValue(extractValue(vm, "claim_link")));
        rewardsUpload.setClaim_msg(setListValue(extractValue(vm, "claim_msg")));
        rewardsUpload.setClaim_title(setListValue(extractValue(vm, "claim_title")));
        rewardsUpload.setClaims_icon(setListValue(extractValue(vm, "claims_icon")));
        rewardsUpload.setRelated_section_title(setListValue(extractValue(vm, "Related_section_title")));
        rewardsUpload.setClass_name(setListValue(extractValue(vm, "class_name")));
        log.info("rewards has been uploaded "+rewardsUpload);
        return rewardsUpload;
    }

    private @NotNull Videos populateVideos(ResourceResolver resourceResolver, String path) throws ParseException {
        ValueMap vm = getValueMap(resourceResolver, path, ConstantsUtil.VIDEOS_WRAPPER);
        Videos videosUpload = new Videos();
        assert vm != null;
        videosUpload.setDescription(setListValue(extractValue(vm, "description")));
        videosUpload.setId(setListValue(extractValue(vm, "id")));
        videosUpload.setModel_year(setListValue(extractValue(vm, "model_year")));
        videosUpload.setSection_type(setListValue("videos"));
        videosUpload.setTitle(setListValue(extractValue(vm, "title")));
        videosUpload.setTopic_tag(setListValue(extractValue(vm, "topic_tag")));
        videosUpload.setType_tag(setListValue(extractValue(vm, "type_tag")));
        videosUpload.setResource_type(setListValue(extractValue(vm, "resource_type")));
        videosUpload.setVideo_title(setListValue(extractValue(vm, "video_title")));
        videosUpload.setClass_name(setListValue(extractValue(vm, "class_name")));
        videosUpload.setSub_title_link(setListValue(extractValue(vm, "sub_title_link")));

        String rank = vm.containsKey("rank") ? vm.get("rank", String.class) : "1";
        assert rank != null;
        if (!rank.equals(StringUtils.EMPTY)) {
            videosUpload.setRank(setListIntValue(Integer.valueOf(rank)));
        }
        String startTime = vm.containsKey("start_time") ? vm.get("start_time", String.class) : "0";
        assert startTime != null;
        if (!startTime.equals(StringUtils.EMPTY)) {
            videosUpload.setStart_time(setListIntValue(Integer.valueOf(startTime)));
        }
        return videosUpload;
    }

	/*
	 * private String deleteDisclaimers(ResourceResolver resourceResolver, String
	 * path) { ValueMap vm = getValueMap(resourceResolver, path,
	 * ConstantsUtil.DISCLAIMERS_MASTER_NODE); assert vm != null; return
	 * extractValue(vm, "Name"); }
	 * 
	 * private boolean getDeleteFromDisclaimer(ResourceResolver resourceResolver,
	 * String path) { ValueMap vm = getValueMap(resourceResolver, path,
	 * ConstantsUtil.DISCLAIMERS_MASTER_NODE); assert vm != null; boolean delete =
	 * false; if (vm.containsKey("delete")) { delete = vm.get("delete", false); }
	 * log.info("delete Filed Value " + delete);
	 return delete;
    }*/

    private List<Resource> getMultiFiledResource(@NotNull ResourceResolver resourceResolver, String path, String resourcePath) throws RepositoryException {
        String actualRes = path + resourcePath;
        Resource resource = resourceResolver.getResource(actualRes);
        List<Resource> resourceList = new ArrayList<>();
        Iterator<Resource> resIterator = resource != null ? resource.listChildren() : new ArrayList<Resource>().iterator();
        while (resIterator.hasNext()) {
            Resource item = resIterator.next();
            resourceList.add(item);
        }
        return resourceList;
    }

    private String getSecondaryDesc(@NotNull ResourceResolver resourceResolver, String path) throws RepositoryException, JsonProcessingException {
        String secondaryDescPath = path + ConstantsUtil.STORIES_SECONDARY_DESCRIPTION;
        Resource secondaryDescRes = resourceResolver.getResource(secondaryDescPath);
        Map<String, String> SecondaryDescData = new HashMap<>();
        if (secondaryDescRes != null) {
            ValueMap vm = secondaryDescRes.adaptTo(ValueMap.class);
            assert vm != null;
            SecondaryDescData.put("description", extractValue(vm, "description"));
        }
        return new ObjectMapper().writeValueAsString(SecondaryDescData);
    }


    private String getStoriesRotationalBannerImageValues(ResourceResolver resourceResolver, String path) throws RepositoryException {
        List<Resource> resList;
        List<Map<String, String>> multiFiledDataList = new ArrayList<>();
        resList = getMultiFiledResource(resourceResolver, path, ConstantsUtil.STORIES_ROTATIONAL_BANNER_IMAGE);
        for (Resource res : resList) {
            ValueMap vm = res != null ? res.adaptTo(ValueMap.class) : null;

            Map<String, String> multiFiledData = new HashMap<>();
            assert vm != null;
            multiFiledData.put("alt_text", extractValue(vm, "alt_text"));
            multiFiledData.put("desktop_banner_image", extractValue(vm, "desktop_banner_image"));
            multiFiledData.put("mobile_banner_image", extractValue(vm, "mobile_banner_image"));
            multiFiledData.put("tablet_banner_image", extractValue(vm, "tablet_banner_image"));
            multiFiledData.put("video_url", extractValue(vm, "video_url"));
            multiFiledDataList.add(multiFiledData);
        }
        Gson gson = new Gson();
        return gson.toJson(multiFiledDataList);
    }

    private String getRewardsRotationalBannerImageValues(ResourceResolver resourceResolver, String path) throws RepositoryException, PersistenceException {
        List<Resource> resList;
        List<Map<String, String>> multiFiledDataList = new ArrayList<>();
        resList = getMultiFiledResource(resourceResolver, path, ConstantsUtil.REWARDS_ROTATIONAL_BANNER_IMAGE);
        for (Resource res : resList) {
            ValueMap vm = res != null ? res.adaptTo(ValueMap.class) : null;
            Map<String, String> multiFiledData = new HashMap<>();
            assert vm != null;
            ModifiableValueMap properties = res.adaptTo(ModifiableValueMap.class);
            assert properties != null;
            replaceRotationalBannerImageKey(properties,resourceResolver);
            multiFiledData.put("alt_text", extractValue(vm, "alt_text"));
                multiFiledData.put("desktop_banner_image", extractValue(vm, "desktop_banner_image"));
                multiFiledData.put("mobile_banner_image", extractValue(vm, "mobile_banner_image"));
                multiFiledData.put("tablet_banner_image", extractValue(vm, "tablet_banner_image"));
                multiFiledData.put("video_url", extractValue(vm, "video_url"));
                multiFiledDataList.add(multiFiledData);
            }
        Gson gson = new Gson();
        return gson.toJson(multiFiledDataList);
    }

    private void replaceRotationalBannerImageKey(ValueMap vm,ResourceResolver resourceResolver) throws PersistenceException {
        if(vm.containsKey("desktop_banner_img")) {
            String desktopImgValue = vm.get("desktop_banner_img").toString();
            vm.remove("desktop_banner_img");
            vm.put("desktop_banner_image", desktopImgValue);
            resourceResolver.commit();
        }
        if(vm.containsKey("mobile_banner_img")) {
            String mobileImgValue = vm.get("mobile_banner_img").toString();
            vm.remove("mobile_banner_img");
            vm.put("mobile_banner_image", mobileImgValue);
            resourceResolver.commit();
        }

        if(vm.containsKey("tab_banner_img")) {
            String tabletImgValue = vm.get("tab_banner_img").toString();
            vm.remove("tab_banner_img");
            vm.put("tablet_banner_image", tabletImgValue);
            resourceResolver.commit();
        }


        if(vm.containsKey("banner_video")) {
            String bannerVideoValue = vm.get("banner_video").toString();
            vm.remove("banner_video");
            vm.put("video_url", bannerVideoValue);
            resourceResolver.commit();
        }
    }

    private @Nullable ValueMap getValueMap(@NotNull ResourceResolver resourceResolver, String path, String resourcePath) {
        String disclaimerResPath = path + resourcePath;
        Resource rewardsResource = resourceResolver.getResource(disclaimerResPath);
        return rewardsResource != null ? rewardsResource.adaptTo(ValueMap.class) : null;
    }

    private @NotNull String getBenefitTypeData(ResourceResolver resourceResolver, String path) throws RepositoryException {
        List<Resource> resList;
        List<String> multiFiledDataList = new ArrayList<>();
        resList = getMultiFiledResource(resourceResolver, path, "/jcr:content/root/responsivegrid/rewardspageview/wrapper/benefit_type");
        for (Resource res : resList) {
            Resource wrapperChild = res.getChild("wrapper");
            ValueMap vm = wrapperChild != null ? wrapperChild.adaptTo(ValueMap.class) : null;
            String multiFiledData;
            assert vm != null;
            multiFiledData = extractValue(vm, "benefit_type");
            multiFiledDataList.add(multiFiledData);
        }
        return String.join(",", multiFiledDataList);
    }

    private String getRewardsRedemptionData(ResourceResolver resourceResolver, String path) throws ParseException {
        ValueMap vm = getValueMap(resourceResolver, path, ConstantsUtil.REWARDS_WRAPPER);
        List<Map<String, String>> rewardsRedemption = new ArrayList<>();
        assert vm != null;
        Map<String, String> multiFiledData = new HashMap<>();
        multiFiledData.put("redeem_description", extractValue(vm, "redeem_description"));
        multiFiledData.put("show_up", extractValue(vm, "show_up"));
        multiFiledData.put("url", extractValue(vm, "externalLink"));
        multiFiledData.put("prom_code", extractValue(vm, "prom_code"));
        multiFiledData.put("banner_video", extractValue(vm, "banner_video"));
        multiFiledData.put("lexus_fob", extractValue(vm, "lexus_fob"));
        multiFiledData.put("other", extractValue(vm, "other"));
        multiFiledData.put("with_promo_code", extractValue(vm, "with_promo_code"));
        multiFiledData.put("redeem_email", extractValue(vm, "email"));
        multiFiledData.put("comment_box", extractValue(vm, "comment_box"));
        multiFiledData.put("call_winery", extractValue(vm, "call_winery"));
        multiFiledData.put("parking_pass", extractValue(vm, "parking_pass"));
        multiFiledData.put("access_card", extractValue(vm, "access_card"));
        multiFiledData.put("event_start_date", toUTCDate(extractValue(vm, "event_start_date")));
        multiFiledData.put("event_end_date", toUTCDate(extractValue(vm, "event_end_date")));
        multiFiledData.put("no_promo_code", extractValue(vm, "no_promo_code"));
        multiFiledData.put("reservation", extractValue(vm, "reservation"));
        multiFiledData.put("chosen", extractValue(vm, "chosen"));
        multiFiledData.put("lexus_fob", extractValue(vm, "culinaryLexusFob"));
        rewardsRedemption.add(multiFiledData);
        Gson gson = new Gson();
        return gson.toJson(rewardsRedemption);
    }

    private boolean validateRewardsPath(@NotNull String path) {
        return path.contains("/rewards-details") || path.contains("/event-details");
    }

}
