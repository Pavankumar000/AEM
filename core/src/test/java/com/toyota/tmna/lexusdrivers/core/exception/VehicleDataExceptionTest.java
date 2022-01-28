package com.toyota.tmna.lexusdrivers.core.exception;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class VehicleDataExceptionTest {

    VehicleDataException vehicleDataException;

    @Test
    void VehDataException() {
        vehicleDataException = new VehicleDataException("Error Message");
        Assert.assertNotNull(vehicleDataException);
    }
}
