package com.toyota.tmna.lexusdrivers.core;

import com.toyota.tmna.lexusdrivers.core.models.impl.ServiceLandingContainerImpl;
import org.junit.jupiter.api.Test;

public class ServiceLandingContainerImplTest {

    ServiceLandingContainerImpl serviceLandingContainer;

    @Test
    void checkContainer(){
        serviceLandingContainer = new ServiceLandingContainerImpl();
        serviceLandingContainer.getExportedItems();
        serviceLandingContainer.getExportedItemsOrder();
        try {
            serviceLandingContainer.getExportedType();
        } catch(NullPointerException e){}
    }
}
