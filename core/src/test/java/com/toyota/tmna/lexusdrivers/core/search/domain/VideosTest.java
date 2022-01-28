package com.toyota.tmna.lexusdrivers.core.search.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VideosTest {

    private Videos videos;

    @Test
    void testToString() {
        videos = new Videos();
        List<String> idlist=new ArrayList<String>();
        idlist.add("id");
        List<Integer> idlist2=new ArrayList<Integer>();
        idlist2.add(1);
        videos.setTitle(idlist);
        videos.setId(idlist);
        videos.setDescription(idlist);
        videos.setSection_type(idlist);
        videos.setModel_year(idlist);
        videos.setRank(idlist2);
        videos.setTopic_tag(idlist);
        videos.setType_tag(idlist);
        videos.setResource_type(idlist);
        videos.setStart_time(idlist2);
        videos.setVideo_title(idlist);
        videos.setTotal_records(1L);
        videos.setClass_name(idlist);
        videos.setSub_title_link(idlist);
        videos.setRelated_section_title(idlist);
    }
}
