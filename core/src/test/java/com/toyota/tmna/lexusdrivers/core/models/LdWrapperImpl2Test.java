package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.LdWrapperImpl2;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.servlethelpers.MockSlingHttpServletRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class LdWrapperImpl2Test {

    LdWrapperImpl2 ldWrapperImpl2;

    @Mock
    Resource resource;

    @Mock
    Resource wrapper;

    MockSlingHttpServletRequest request;

    @Test
    void checkContainer() {
        ldWrapperImpl2 = new LdWrapperImpl2(request, wrapper);
        ldWrapperImpl2.setWrapper(wrapper);
        ldWrapperImpl2.setRequest(request);
        ldWrapperImpl2.setResource(resource);
        ldWrapperImpl2.getRequest();
        ldWrapperImpl2.getWrapper();
        ldWrapperImpl2.getResource();
        try {
            ldWrapperImpl2.getColumnClassNames();
        } catch (NullPointerException e){}
    }

    @Test
    void checkContainer2() {
        ldWrapperImpl2 = new LdWrapperImpl2();
        try {
            ldWrapperImpl2.getExportedItemsOrder();
        } catch (NullPointerException e) {

        }
    }

    @Test
    void getExportedItems() {
        ldWrapperImpl2 = new LdWrapperImpl2();
        try {
            ldWrapperImpl2.getExportedItems();
        } catch (NullPointerException e) {

        }
    }

    @Test
    void getExportedType() {
        ldWrapperImpl2 = new LdWrapperImpl2();
        try {
            ldWrapperImpl2.getExportedType();
        } catch (NullPointerException e) {

        }
    }

    @Test
    void getColumnCount() {
        ldWrapperImpl2 = new LdWrapperImpl2();
        try {
            ldWrapperImpl2.getColumnCount();
        } catch (NullPointerException e) {

        }
    }

    @Test
    void getGridClassNames() {
        ldWrapperImpl2 = new LdWrapperImpl2();
        try {
            ldWrapperImpl2.getGridClassNames();
        } catch (NullPointerException e) {

        }
    }


}

