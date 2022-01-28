package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.CommunicationpreferencesImpl;
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
public class CommunicationpreferencesImplTest {
    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    CommunicationpreferencesImpl communicationpreferences;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(CommunicationpreferencesImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/CommunicationpreferencesImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        communicationpreferences = context.request().adaptTo(CommunicationpreferencesImpl.class);
    }

    @Test
    void getdescription() {
        String expected = "description";
        String actual = communicationpreferences.getDescription();
        assertEquals(expected, actual);
    }

    @Test
    void getsecondaryCTA() {
        String expected = "secondaryCTA";
        String actual = communicationpreferences.getSecondaryCTA();
        assertEquals(expected, actual);
    }

    @Test
    void getprimaryCTA() {
        String expected = "primaryCTA";
        String actual = communicationpreferences.getPrimaryCTA();
        assertEquals(expected, actual);
    }

    @Test
    void getcancelIcon() {
        String expected = "cancelIcon";
        String actual = communicationpreferences.getCancelIcon();
        assertEquals(expected, actual);
    }

    @Test
    void geteditIcon() {
        String expected = "editIcon";
        String actual = communicationpreferences.getEditIcon();
        assertEquals(expected, actual);
    }

    @Test
    void getemailLabel() {
        String expected = "emailLabel";
        String actual = communicationpreferences.getEmailLabel();
        assertEquals(expected, actual);
    }

    @Test
    void geteditEmailLabel() {
        String expected = "editEmailLabel";
        String actual = communicationpreferences.getEditEmailLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getEmailInfo() {
        String expected = "emailInfo";
        String actual = communicationpreferences.getEmailInfo();
        assertEquals(expected, actual);
    }
    
    @Test
    void getUnsubscribeTitle() {
        String expected = "unsubscribeTitle";
        String actual = communicationpreferences.getUnsubscribeTitle();
        assertEquals(expected, actual);
    }
    
    @Test
    void getUnsubscribeDescription() {
        String expected = "unsubscribeDescription";
        String actual = communicationpreferences.getUnsubscribeDescription();
        assertEquals(expected, actual);
    }
    
    @Test
    void getPrivacyCtaLink() {
        String expected = "privacyCtaLink";
        String actual = communicationpreferences.getPrivacyCtaLink();
        assertEquals(expected, actual);
    }
    
    @Test
    void getServiceConnectTitle() {
        String expected = "serviceConnectTitle";
        String actual = communicationpreferences.getServiceConnectTitle();
        assertEquals(expected, actual);
    }
    
    @Test
    void getServiceConnectDescription() {
        String expected = "serviceConnectDescription";
        String actual = communicationpreferences.getServiceConnectDescription();
        assertEquals(expected, actual);
    }
    
    @Test
    void getPrivacyCta() {
        String expected = "privacyCta";
        String actual = communicationpreferences.getPrivacyCta();
        assertEquals(expected, actual);
    }
    
    @Test
    void getVehicleTitle() {
        String expected = "vehicleTitle";
        String actual = communicationpreferences.getVehicleTitle();
        assertEquals(expected, actual);
    }
    
    @Test
    void getServiceEmailTitle() {
        String expected = "serviceEmailTitle";
        String actual = communicationpreferences.getServiceEmailTitle();
        assertEquals(expected, actual);
    }
    
    @Test
    void getServiceDealerTitle() {
        String expected = "serviceDealerTitle";
        String actual = communicationpreferences.getServiceDealerTitle();
        assertEquals(expected, actual);
    }
    
    @Test
    void getServiceNotificationTitle() {
        String expected = "serviceNotificationTitle";
        String actual = communicationpreferences.getServiceNotificationTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getEditEmailCtaLink() {
        String expected = "editEmailCtaLink";
        String actual = communicationpreferences.getEditEmailCtaLink();
        assertEquals(expected, actual);
    }
    
    @Test
    void getConfirmationMessage() {
        String expected = "confirmationMessage";
        String actual = communicationpreferences.getConfirmationMessage();
        assertEquals(expected, actual);
    }
    
    @Test
    void getExportedType() {
        String expected = communicationpreferences.getExportedType();
        assertNotNull(expected);
    }

    @Test
    void getNavLinks() {
        Resource expected = communicationpreferences.getLinks();
        assertNull(expected);
    }
    @Test
    void getServiceConnectSubTitle() {
        String expected = "serviceConnectSubTitle";
        String actual = communicationpreferences.getServiceConnectSubTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getSuccessMessage() {
        String expected = "successMessage";
        String actual = communicationpreferences.getSuccessMessage();
        assertEquals(expected, actual);
    }

    @Test
    void getModalText() {
        String expected = "modalText";
        String actual = communicationpreferences.getModalText();
        assertEquals(expected, actual);
    }

    @Test
    void getModalDescription() {
        String expected = "modalDescription";
        String actual = communicationpreferences.getModalDescription();
        assertEquals(expected, actual);
    }

    @Test
    void getSubscriptionError() {
        String expected = "subscriptionError";
        String actual = communicationpreferences.getSubscriptionError();
        assertEquals(expected, actual);
    }

    @Test
    void getSaveError() {
        String expected = "saveError";
        String actual = communicationpreferences.getSaveError();
        assertEquals(expected, actual);
    }

    @Test
    void getPreferenceCta() {
        String expected = "preferenceCta";
        String actual = communicationpreferences.getPreferenceCta();
        assertEquals(expected, actual);
    }

    @Test
    void getBreadCrumbHeading() {
        String expected = "breadCrumbHeading";
        String actual = communicationpreferences.getBreadCrumbHeading();
        assertEquals(expected, actual);
    }
    
    @Test
    void getUnsubscribeOk() {
        String expected = "unsubscribeOK";
        String actual = communicationpreferences.getUnsubscribeOk();
        assertEquals(expected, actual);
    }
}
