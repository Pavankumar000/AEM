package com.toyota.tmna.lexusdrivers.core.search.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StoriesTest {

    private Stories stories;

    @BeforeEach
    public void setUp() throws Exception {
        stories = new Stories();
    }
    @Test
    void TString() {
        List<String> idlist=new ArrayList<String>();
        idlist.add("id");
        stories.setId(idlist);
        stories.setDescription(idlist);
        stories.setCategory(idlist);
        stories.setTitle(idlist);
        stories.setSection_type(idlist);
        stories.setPartner_name(idlist);
        stories.setShort_description(idlist);
        stories.setLong_description(idlist);
        stories.setDesktop_hero_image(idlist);
        stories.setMobile_hero_image(idlist);
        stories.setTablet_hero_image(idlist);
        stories.setDesktop_thumbnail_image(idlist);
        stories.setMobile_thumbnail_image(idlist);
        stories.setTablet_thumbnail_image(idlist);
        stories.setVideo_url(idlist);
        stories.setRotational_banner_section(idlist);
        stories.setSecondary_description(idlist);
        stories.setDisplay_start_date(idlist);
        stories.setEffective_end_date(idlist);
        stories.setEffective_start_date(idlist);
        stories.setGlobal_featured(idlist);
        stories.setIs_featured(idlist);
        stories.setMeta_tags(idlist);
        stories.setPublish_date(idlist);
        stories.setSeo_key(idlist);
        stories.setSeo_description(idlist);
        stories.setSeo_title(idlist);
        stories.setCategory_count(1L);
        stories.setRelated_section_title(idlist);
        stories.setTotal_records(1L);
    }
}
