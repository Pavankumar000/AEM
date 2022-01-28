package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.VehiclespecDetailsImpl;
import org.junit.jupiter.api.Test;

public class VehiclespecDetailsImplTest {

    VehiclespecDetailsImpl vehiclespecDetails;

    @Test
    void checkContainer(){
        vehiclespecDetails = new VehiclespecDetailsImpl();
        vehiclespecDetails.getTitle();
    }
}
