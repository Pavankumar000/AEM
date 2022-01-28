package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.EnformpageviewImpl;
import com.toyota.tmna.lexusdrivers.core.models.impl.ExperiencepageviewImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ExperiencepageviewImplTest {

    ExperiencepageviewImpl experiencepageview;
    @Test
    void containerTest() {
        experiencepageview = new ExperiencepageviewImpl();
        assertNull(experiencepageview.getTitle());
        assertNotNull(experiencepageview.getExportedItemsOrder());
        assertNotNull(experiencepageview.getExportedItems());
        try
        {
            experiencepageview.getExportedType();
        } catch (NullPointerException e){

        }
    }

}
