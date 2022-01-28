package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.VehicleservicehistoryviewImpl;
import org.junit.jupiter.api.Test;

public class VehicleservicehistoryviewImplTest {

    VehicleservicehistoryviewImpl vehicleservicehistoryview;

    @Test
    void checkContainer(){
        vehicleservicehistoryview = new VehicleservicehistoryviewImpl();
        vehicleservicehistoryview.getTitle();
    }
}
