package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.ExperiencepageviewImpl;
import com.toyota.tmna.lexusdrivers.core.models.impl.LandingpageviewImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LandingpageviewImplTest {

    LandingpageviewImpl landingpageview;

    @Test
    void containerTest() {
        landingpageview = new LandingpageviewImpl();
        assertNull(landingpageview.getTitle());
        assertNotNull(landingpageview.getExportedItemsOrder());
        assertNotNull(landingpageview.getExportedItems());
        try
        {
            landingpageview.getExportedType();
        } catch (NullPointerException e){

        }
    }

}
