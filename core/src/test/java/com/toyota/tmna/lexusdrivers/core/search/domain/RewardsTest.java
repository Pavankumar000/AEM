package com.toyota.tmna.lexusdrivers.core.search.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardsTest {

    private Rewards rewards;

    @Test
    void testToString() {
        rewards = new Rewards();
        List<String> idlist=new ArrayList<String>();
        idlist.add("id");
        rewards.setTitle(idlist);
        rewards.setHeading(idlist);
        rewards.setAlt_text(idlist);
        rewards.setCategory_list(idlist);
        rewards.setCategory_type(idlist);
        rewards.setDesktop_hero_img(idlist);
        rewards.setDesktop_thumb_img(idlist);
        rewards.setDetail_description(idlist);
        rewards.setDisplay_start_date(idlist);
        rewards.setEffective_end_date(idlist);
        rewards.setDisplay_start_date(idlist);
        rewards.setEmail(idlist);
        rewards.setGlobal_featured(idlist);
        rewards.setIs_featured(idlist);
        rewards.setMeta_tags(idlist);
        rewards.setMobile_hero_img(idlist);
        rewards.setMobile_thumb_img(idlist);
        rewards.setPartner_logo(idlist);
        rewards.setPartner_name(idlist);
        rewards.setPhone(idlist);
        rewards.setPublish_date(idlist);
        rewards.setRewards_redemption(idlist);
        rewards.setRotational_banner_section(idlist);
        rewards.setSecondary_description(idlist);
        rewards.setSeo_key(idlist);
        rewards.setSeo_description(idlist);
        rewards.setSeo_title(idlist);
        rewards.setShort_description(idlist);
        rewards.setTab_hero_img(idlist);
        rewards.setTab_thumb_img(idlist);
        rewards.setThumbnail_video(idlist);
        rewards.setAddress_line_one(idlist);
        rewards.setAddress_line_two(idlist);
        rewards.setCity(idlist);
        rewards.setZip_code(idlist);
        rewards.setState(idlist);
        rewards.setPhone(idlist);
        rewards.setWebsite(idlist);
        rewards.setRewards_redemption(idlist);
        rewards.setLat_lan(idlist);
        rewards.setEffective_start_date(idlist);
        rewards.setTotal_records(1L);
        rewards.setBenefit_type(idlist);
        rewards.setDistance(1D);
        rewards.setClaim_title(idlist);
        rewards.setClaims_icon(idlist);
        rewards.setClaim_link(idlist);
        rewards.setClass_name(idlist);
        rewards.setClaim_msg(idlist);
        rewards.setClaim_cta(idlist);
        rewards.setRelated_section_title(idlist);
    }
}
