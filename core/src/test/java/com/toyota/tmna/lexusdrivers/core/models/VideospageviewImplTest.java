package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.ExperiencepageviewImpl;
import com.toyota.tmna.lexusdrivers.core.models.impl.VideospageviewImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VideospageviewImplTest {

    VideospageviewImpl videospageview;

    @Test
    void containerTest() {
        videospageview = new VideospageviewImpl();
        assertNull(videospageview.getTitle());
        assertNotNull(videospageview.getExportedItemsOrder());
        assertNotNull(videospageview.getExportedItems());
        try
        {
            videospageview.getExportedType();
        } catch (NullPointerException e){

        }
    }
}
