package com.toyota.tmna.lexusdrivers.core.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component(service = Servlet.class,
        property = {
                "sling.servlet.resourceTypes =" + ConstantsUtil.SERVLET_RESOURCE_TYPE,
                "sling.servlet.selectors=" + "banner",
                "sling.servlet.extensions=" + ConstantsUtil.SERVLET_EXTENSIONS})
public class HeroBannerHandler extends SlingAllMethodsServlet {

    private static final long serialVersionUID = 1L;
    private static final String TYPE_VIN = "VIN";
    private static final String TYPE_MY = "MY";

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String type = request.getParameter("type");
        String model = request.getParameter("model");
        String year = request.getParameter("year");

        JsonObject cfData;

        Resource CFresource = request.getResourceResolver().getResource(ConstantsUtil.HERO_BANNER_CF);
        assert CFresource != null;
        JsonArray jsonArray = new JsonArray();
        for (Resource childRes : request.getResourceResolver().getChildren(CFresource)) {
            String resourcePath = childRes.getPath() + ConstantsUtil.CP_MASTER_NODE;
            Resource resource = request.getResourceResolver().getResource(resourcePath);
            if (resource != null) {
                ValueMap vm = resource.adaptTo(ValueMap.class);
                assert vm != null;
                switch (type) {
                    case TYPE_VIN:
                            cfData = getVINResponse(vm,model,year);
                            if(cfData!=null)
                            jsonArray.add(cfData);
                            break;
                    case TYPE_MY:
                            cfData = getMYResponse(vm,model,year);
                            if(cfData!=null)
                            jsonArray.add(cfData);
                            break;
                    default:
                            cfData = getDefaultResponse(vm);
                            if(cfData!=null)
                            jsonArray.add(cfData);
                            break;
                }
            }
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonArray);
        out.flush();
        out.close();

    }

    private String extractValue(ValueMap vm, String key) {
        return vm.containsKey(key) ? vm.get(key, String.class) : StringUtils.EMPTY;
    }

    private String getModelYear(ValueMap vm){
        return extractValue(vm,"myList");
    }

    private boolean matchModel(ValueMap vm,String paramModel,String paramYear) {
        String modelYear =  getModelYear(vm);
        String paramModelYear = paramYear + "-" + paramModel;
        boolean matchModel = false;
        if(!Objects.requireNonNull(modelYear).contains("*_*")) {
            if(parseModel(modelYear).contains(paramModelYear)){
                matchModel = true;
            }
        }
        return matchModel;
    }


    private boolean getBooleanData(ValueMap vm, String key) {
        return vm.containsKey(key) ? vm.get(key, true) : false;
    }

    private JsonObject createResponseString(ValueMap vm) {

        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("primaryCTA", extractValue(vm, "primaryCTA"));
        jsonObject.addProperty("makePrimaryCTA", extractValue(vm, "makePrimaryCTA"));
        jsonObject.addProperty("videoType", extractValue(vm, "videoType"));
        jsonObject.addProperty("primaryCtaLabel", extractValue(vm, "primaryCtaLabel"));
        jsonObject.addProperty("primaryCTALink", extractValue(vm, "primaryCTALink"));
        jsonObject.addProperty("secondaryCtaLabel", extractValue(vm, "secondaryCtaLabel"));
        jsonObject.addProperty("SecondaryCtaLink", extractValue(vm, "secondaryCtaLink"));
        jsonObject.addProperty("primarysuccessmessage", extractValue(vm, "primarysuccessmessage"));
        jsonObject.addProperty("disclaimer", extractValue(vm, "disclaimer"));
        jsonObject.addProperty("legalCopy", extractValue(vm, "legalCopy"));
        jsonObject.addProperty("myList", getModelYear(vm));
        jsonObject.addProperty("bannerforVIN", getBooleanData(vm, "bannerforVIN"));
        jsonObject.addProperty("showInEditor", getBooleanData(vm, "showInEditor"));
        jsonObject.addProperty("altTextforImage", extractValue(vm, "altTextforImage"));
        jsonObject.addProperty("altTextforMobileImage", extractValue(vm, "altTextforMobileImage"));
        jsonObject.addProperty("altTextForTabletImage", extractValue(vm, "altTextForTabletImage"));
        jsonObject.addProperty("primaryButtonURL", extractValue(vm, "primaryButtonURL"));
        jsonObject.addProperty("primaryButtonLabel", extractValue(vm, "primaryButtonLabel"));
        jsonObject.addProperty("desktopImage", extractValue(vm, "desktopImage"));
        jsonObject.addProperty("tabletImage", extractValue(vm, "tabletImage"));
        jsonObject.addProperty("mobileImage", extractValue(vm, "mobileImage"));
        jsonObject.addProperty("notApplicableMYList", extractValue(vm, "notApplicableMYList"));
        jsonObject.addProperty("joinDescription", extractValue(vm, "joinDescription"));
        jsonObject.addProperty("videourl", extractValue(vm, "videourl"));
        jsonObject.addProperty("videoTitle", extractValue(vm, "videoTitle"));
        jsonObject.addProperty("videoSource", extractValue(vm, "videoSource"));
        jsonObject.addProperty("label", extractValue(vm, "label"));
        jsonObject.addProperty("title", extractValue(vm, "title"));
        jsonObject.addProperty("showTitleasLink", getBooleanData(vm, "showTitleasLink"));
        jsonObject.addProperty("header", extractValue(vm, "header"));
        jsonObject.addProperty("showHeaderasLink", getBooleanData(vm, "showHeaderasLink"));
        jsonObject.addProperty("richTextTitle", extractValue(vm, "richTextTitle"));
        jsonObject.addProperty("description", extractValue(vm, "description"));
        jsonObject.addProperty("icon", extractValue(vm, "icon"));
        jsonObject.addProperty("extrapadding", getBooleanData(vm, "extrapadding"));
        jsonObject.addProperty("hasDividerLine", getBooleanData(vm, "hasDividerLine"));
        jsonObject.addProperty("ctatype", extractValue(vm, "ctatype"));
        jsonObject.addProperty("ctatype", extractValue(vm, "ctatype"));
        jsonObject.addProperty("alignment", extractValue(vm, "alignment"));
        jsonObject.addProperty("alignment", extractValue(vm, "alignment"));
        jsonObject.addProperty("type", extractValue(vm, "type"));
        jsonObject.addProperty("video", extractValue(vm, "video"));
        return gson.fromJson(jsonObject, JsonObject.class);
    }

    private JsonObject getVINResponse(ValueMap vm,String model,String year) {
        JsonObject cfData = null;
        if (getBooleanData(vm, "bannerforVIN") && matchModel(vm,model,year)) {
            cfData =  createResponseString(vm);
        }
        return cfData;
    }

    private JsonObject getMYResponse(ValueMap vm,String model,String year) {
        JsonObject cfData = null;
        if (!getBooleanData(vm, "bannerforVIN") && matchModel(vm,model,year)) {
            cfData =  createResponseString(vm);
        }
        return cfData;
    }

    private JsonObject getDefaultResponse(ValueMap vm) {
        JsonObject cfData = null;
        if (getModelYear(vm).contains("*_*")) {
            cfData = createResponseString(vm);
        }
        return cfData;
    }


    private List<String> parseModel(String modelYear){
        String[] arrOfStr = modelYear.split("\\|");
        return Arrays.asList(arrOfStr);
}

}


