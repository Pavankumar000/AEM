package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.EndcapImpl;
import com.toyota.tmna.lexusdrivers.core.models.impl.ServicecardImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class ServicecardImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private ServicecardImpl servicecard;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(ServicecardImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/ServicecardImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        servicecard = context.request().adaptTo(ServicecardImpl.class);
    }

    @Test
    void getTitle() {
        String expected = "serviceCardTitle";
        String actual = servicecard.getServiceCardTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getserviceCardDateLabel() {
        String expected = "serviceCardDateLabel";
        String actual = servicecard.getServiceCardDateLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getserviceCardType() {
        String expected = "serviceCardType";
        String actual = servicecard.getServiceCardType();
        assertEquals(expected, actual);
    }

    @Test
    void getlinkType() {
        String expected = "linkType";
        String actual = servicecard.getLinkType();
        assertEquals(expected, actual);
    }
    
    @Test
    void getserviceCardIcon() {
        String expected = "serviceCardIcon";
        String actual = servicecard.getServiceCardIcon();
        assertEquals(expected, actual);
    }

    @Test
    void getserviceCardAltText() {
        String expected = "serviceCardAltText";
        String actual = servicecard.getServiceCardAltText();
        assertEquals(expected, actual);
    }

    @Test
    void getserviceCardMessage() {
        String expected = "serviceCardMessage";
        String actual = servicecard.getServiceCardMessage();
        assertEquals(expected, actual);
    }

    @Test
    void getserviceCardDescription() {
        String expected = "serviceCardDescription";
        String actual = servicecard.getServiceCardDescription();
        assertEquals(expected, actual);
    }

    @Test
    void getserviceCardCTALabel() {
        String expected = "serviceCardCTALabel";
        String actual = servicecard.getServiceCardCTALabel();
        assertEquals(expected, actual);
    }

    @Test
    void getvhrLabel() {
        String expected = "vhrLabel";
        String actual = servicecard.getVhrLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getalertsLabel() {
        String expected = "alertsLabel";
        String actual = servicecard.getAlertsLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void geBorder() {
        String expected = "border";
        String actual = servicecard.getBorder();
        assertEquals(expected, actual);
    }
    
    @Test
    void getserviceCardURL() {
        String expected = "serviceCardURL";
        String actual = servicecard.getServiceCardURL();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected = servicecard.getExportedType();
        assertNotNull(expected);
    }

    @Test
    void getNavLinks() {
        Resource expected = servicecard.getLinks();
        assertNull(expected);
    }

    @Test
    void getNoRecords() {
        String expected = "noRecords";
        String actual = servicecard.getNoRecords();
        assertEquals(expected, actual);
    }

    @Test
    void getNoVin() {
        String expected = "noVin";
        String actual = servicecard.getNoVin();
        assertEquals(expected, actual);
    }

    @Test
    void getNoMileage() {
        String expected = "noMileage";
        String actual = servicecard.getNoMileage();
        assertEquals(expected, actual);
    }

    @Test
    void getServiceCardImg() {
        String expected = "serviceCardImg";
        String actual = servicecard.getServiceCardImg();
        assertEquals(expected, actual);
        assertEquals("serviceCardClassName", servicecard.getServiceCardClassName());
    }

}
