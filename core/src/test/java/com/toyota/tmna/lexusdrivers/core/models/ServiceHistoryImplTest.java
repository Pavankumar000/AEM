package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.ServiceHistoryImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class ServiceHistoryImplTest {



        private final AemContext context = new AemContext();
        @Mock
        private ModelFactory modelFactory;
        private ServiceHistoryImpl serviceHistory;

        @BeforeEach
        void setUp() {
        context.addModelsForClasses(ServiceHistoryImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/ServiceHistoryImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        serviceHistory = context.request().adaptTo(ServiceHistoryImpl.class);
    }

    @Test
    void getMilage() {
        String expected = "milage";
        String actual = serviceHistory.getMilage();
        assertEquals(expected, actual);
    }

    @Test
    void getServicingDealer() {
        String expected = "servicingDealer";
        String actual = serviceHistory.getServicingDealer();
        assertEquals(expected, actual);
    }

    @Test
    void getService() {
        String expected = "service";
        String actual = serviceHistory.getService();
        assertEquals(expected, actual);
    }

    @Test
    void getDescription() {
        String expected = "description";
        String actual = serviceHistory.getDescription();
        assertEquals(expected, actual);
    }

     @Test
      void getExportedType() {
        String expected = serviceHistory.getExportedType();
        assertNotNull(expected);
    }

}
