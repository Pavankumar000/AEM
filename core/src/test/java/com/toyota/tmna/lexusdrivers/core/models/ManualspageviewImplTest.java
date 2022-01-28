package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.ManualspageviewImpl;
import org.junit.jupiter.api.Test;

public class ManualspageviewImplTest {

    ManualspageviewImpl manualspageview;

    @Test
    void checkContainer() {
        manualspageview = new ManualspageviewImpl();
        manualspageview.getTitle();
        manualspageview.getExportedItems();
        manualspageview.getExportedItemsOrder();
        try{
            manualspageview.getExportedType();
        } catch (NullPointerException e) {

        }
    }
}
