package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.MaintenancescheduleviewImpl;
import org.junit.jupiter.api.Test;

public class MaintenancescheduleviewImplTest {

    MaintenancescheduleviewImpl maintenancescheduleview;

    @Test
    void checkContainer() {
        maintenancescheduleview = new MaintenancescheduleviewImpl();
        maintenancescheduleview.getTitle();
    }
}
