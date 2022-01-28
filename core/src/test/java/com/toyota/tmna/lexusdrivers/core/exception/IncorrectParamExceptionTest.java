package com.toyota.tmna.lexusdrivers.core.exception;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class IncorrectParamExceptionTest {

    IncorrectParamException incorrectParamException;

    @Test
    void VehDataException() {
        incorrectParamException = new IncorrectParamException("Error Message");
        Assert.assertNotNull(incorrectParamException);
    }
}
