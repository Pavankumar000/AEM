package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.SubscriptionImpl;
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
public class SubscriptionImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private SubscriptionImpl subscription;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(SubscriptionImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/SubscriptionImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        subscription = context.request().adaptTo(SubscriptionImpl.class);
    }

    @Test
    void getButtonText() {
        String expected = "manageSubscriptionButtonText";
        String actual = subscription.getManageSubscriptionButtonText();
        assertEquals(expected, actual);
    }

    @Test
    void getButtonLink() {
        String expected = "manageSubscriptionButtonLink";
        String actual = subscription.getManageSubscriptionButtonLink();
        assertEquals(expected, actual);
    }

    @Test
    void getExpiredIcon() {
        String expected = "expiredIcon";
        String actual = subscription.getExpiredIcon();
        assertEquals(expected, actual);
    }

    @Test
    void getActiveIcon() {
        String expected = "activeIcon";
        String actual = subscription.getActiveIcon();
        assertEquals(expected, actual);
    }

    @Test
    void getCallOutButtonText() {
        String expected = "callOutButtonText";
        String actual = subscription.getCallOutButtonText();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected = subscription.getExportedType();
        assertNotNull(expected);
    }
}
