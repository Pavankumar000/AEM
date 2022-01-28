package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.EnformpageviewImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EnformpageviewImplTest {

    EnformpageviewImpl enformpageview;

    @Test
    void containerTest() {
        enformpageview = new EnformpageviewImpl();
        assertNull(enformpageview.getModelYearList());
        assertNotNull(enformpageview.getExportedItemsOrder());
        assertNotNull(enformpageview.getExportedItems());
        try
            {
                enformpageview.getExportedType();
            } catch (NullPointerException e){

        }
    }
}
