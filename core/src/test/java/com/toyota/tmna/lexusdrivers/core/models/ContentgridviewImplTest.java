package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.ContentgridviewImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ContentgridviewImplTest {

    ContentgridviewImpl contentgridview;

    @Test
    void checkContainer(){
        contentgridview = new ContentgridviewImpl();
        contentgridview.setTitle("title");
        contentgridview.setColCountLarge("10");
        contentgridview.setColCountMedium("5");
        contentgridview.setColCountSmall("2");
        contentgridview.setGridClassName("className");
        contentgridview.setHasBorder(true);
        contentgridview.setHasFeature(true);
        assertEquals("title", contentgridview.getTitle());
        assertEquals("10", contentgridview.getColCountLarge());
        assertEquals("5", contentgridview.getColCountMedium());
        assertEquals("2",contentgridview.getColCountSmall());
        assertEquals("className", contentgridview.getGridClassName());
        assertEquals(true, contentgridview.getHasBorder());
        assertEquals(true, contentgridview.getHasFeature());
        try{
            contentgridview.getExportedType();
        } catch (NullPointerException e) {}

    }
}
