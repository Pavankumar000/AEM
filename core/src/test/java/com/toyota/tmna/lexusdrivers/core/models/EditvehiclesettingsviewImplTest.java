package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.EditvehiclesettingsviewImpl;
import com.toyota.tmna.lexusdrivers.core.models.impl.EmailinputImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EditvehiclesettingsviewImplTest {

    EditvehiclesettingsviewImpl editvehiclesettingsview;

    @Test
    void containerTest() {
        editvehiclesettingsview = new EditvehiclesettingsviewImpl();
        assertNull(editvehiclesettingsview.getTitle());
    }
}
