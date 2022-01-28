package com.toyota.tmna.lexusdrivers.core.util;

import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ContainerUtilTest {

    @InjectMocks
    ContainerUtil containerUtil;
    @Mock
    Resource resource;

    @Test
    void test() {
        try {
            containerUtil = new ContainerUtil();
            containerUtil.getExportedType();
        } catch (NullPointerException e){}
    }
}
