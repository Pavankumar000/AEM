package com.toyota.tmna.lexusdrivers.core.models;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.spy;


public class ComponentTest {

    Component component = spy(Component.class);

    @Test
    void getId() {
        component.getId();
    }

    @Test
    void getExportedType() {
        try {
            component.getExportedType();
        } catch (UnsupportedOperationException e){}
    }
}
