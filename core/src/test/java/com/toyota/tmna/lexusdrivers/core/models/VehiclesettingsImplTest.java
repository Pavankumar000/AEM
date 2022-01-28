package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.VehiclesettingsImpl;
import org.junit.jupiter.api.Test;

public class VehiclesettingsImplTest {

    VehiclesettingsImpl vehiclesettings;

    @Test
    void checkContainer() {
        vehiclesettings = new VehiclesettingsImpl();
        vehiclesettings.getAddVehicleLabel();
        vehiclesettings.getSection();
        vehiclesettings.getSubSection();
        vehiclesettings.getTitle();
    }
}
