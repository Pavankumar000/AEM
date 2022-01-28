package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.VHRContainerImpl;
import org.junit.jupiter.api.Test;

public class VHRContainerImplTest {

    VHRContainerImpl vhrContainer;

    @Test
    void checkContainer(){
        vhrContainer = new VHRContainerImpl();
        vhrContainer.getTitle();
    }
}
