package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.SafetyRecallsImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class SafetyRecallsImplTest {

    SafetyRecallsImpl safetyRecalls;

    @Test
    void checkContainer() {
        safetyRecalls = new SafetyRecallsImpl();
        assertNull(safetyRecalls.getTitle());
        assertNull(safetyRecalls.getSafetyLinks());
    }
}
