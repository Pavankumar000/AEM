package com.toyota.tmna.lexusdrivers.core.models;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.spy;

public class ContentgridviewTest {

    Contentgridview contentgridview = spy(Contentgridview.class);


    @Test
    void getExportedType() {
        try {
            contentgridview.getExportedItems();
        } catch (UnsupportedOperationException e){}
    }

    @Test
    void getExportedItemsOrder() {
        try {
            contentgridview.getExportedItemsOrder();
        } catch (UnsupportedOperationException e){}
    }

}
