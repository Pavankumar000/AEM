package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.models.impl.EditvehiclesettingsImpl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class EditvehiclesettingsImplTest {
	private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private EditvehiclesettingsImpl editvehiclesettingsImpl;
    
    @BeforeEach
    void setUp() {
        context.addModelsForClasses(EditvehiclesettingsImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/EditvehiclesettingsImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        editvehiclesettingsImpl = context.request().adaptTo(EditvehiclesettingsImpl.class);
        
    }
    
    @Test
    void getExportedType() {
        String expected = editvehiclesettingsImpl.getExportedType();
        assertNotNull(expected);
    }
    
    @Test
    void getErrMessageDesc() {
        String expected = "errMessageDesc";
        String actual = editvehiclesettingsImpl.getErrMessageDesc();
        assertEquals(expected, actual);
    }
    
    @Test
    void getSaveLabel() {
        String expected = "saveLabel";
        String actual = editvehiclesettingsImpl.getSaveLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getEditIcon() {
        String expected = "editIcon";
        String actual = editvehiclesettingsImpl.getEditIcon();
        assertEquals(expected, actual);
    }
    
    @Test
    void getRemoveIcon() {
        String expected = "removeIcon";
        String actual = editvehiclesettingsImpl.getRemoveIcon();
        assertEquals(expected, actual);
    }
    
    @Test
    void getRemoveLabel() {
        String expected = "removeLabel";
        String actual = editvehiclesettingsImpl.getRemoveLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getCancelLabel() {
        String expected = "cancelLabel";
        String actual = editvehiclesettingsImpl.getCancelLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getManageLink() {
        String expected = "manageLink";
        String actual = editvehiclesettingsImpl.getManageLink();
        assertEquals(expected, actual);
    }
    
    @Test
    void getManageLinkLabel() {
        String expected = "manageLinkLabel";
        String actual = editvehiclesettingsImpl.getManageLinkLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getNonEnrolledUserMsg() {
        String expected = "nonEnrolledUserMsg";
        String actual = editvehiclesettingsImpl.getNonEnrolledUserMsg();
        assertEquals(expected, actual);
    }
    
    @Test
    void getEnrolledUserMsg() {
        String expected = "enrolledUserMsg";
        String actual = editvehiclesettingsImpl.getEnrolledUserMsg();
        assertEquals(expected, actual);
    }
    
    @Test
    void getEnformLabel() {
        String expected = "enformLabel";
        String actual = editvehiclesettingsImpl.getEnformLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getDealerDescription() {
        String expected = "dealerDescription";
        String actual = editvehiclesettingsImpl.getDealerDescription();
        assertEquals(expected, actual);
    }
    
    @Test
    void getSelectDealerLink() {
        String expected = "selectDealerLink";
        String actual = editvehiclesettingsImpl.getSelectDealerLink();
        assertEquals(expected, actual);
    }
    
    @Test
    void getSelectDealerLabel() {
        String expected = "selectDealerLabel";
        String actual = editvehiclesettingsImpl.getSelectDealerLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getPreferredDealerLabel() {
        String expected = "preferredDealerLabel";
        String actual = editvehiclesettingsImpl.getPreferredDealerLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getSellerDealerLabel() {
        String expected = "sellerDealerLabel";
        String actual = editvehiclesettingsImpl.getSellerDealerLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getEditLabel() {
        String expected = "editLabel";
        String actual = editvehiclesettingsImpl.getEditLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getVehicleCTALink() {
        String expected = "vehicleCTALink";
        String actual = editvehiclesettingsImpl.getVehicleCTALink();
        assertEquals(expected, actual);
    }
    
    @Test
    void getVehicleCTALabel() {
        String expected = "vehicleCTALabel";
        String actual = editvehiclesettingsImpl.getVehicleCTALabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getNicknameLabel() {
        String expected = "nicknameLabel";
        String actual = editvehiclesettingsImpl.getNicknameLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getVinLabel() {
        String expected = "vinLabel";
        String actual = editvehiclesettingsImpl.getVinLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getConfirmLabel() {
        String expected = "confirmLabel";
        String actual = editvehiclesettingsImpl.getConfirmLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getDeleteVehicleMessage() {
        String expected = "deleteVehicleMessage";
        String actual = editvehiclesettingsImpl.getDeleteVehicleMessage();
        assertEquals(expected, actual);
    }
    
    @Test
    void getInActiveSubscription() {
        String expected = "inActiveSubscription";
        String actual = editvehiclesettingsImpl.getInActiveSubscription();
        assertEquals(expected, actual);
    }
    
    @Test
    void getActiveSubscription() {
        String expected = "activeSubscription";
        String actual = editvehiclesettingsImpl.getActiveSubscription();
        assertEquals(expected, actual);
    }
    
    @Test
    void getSubscriptionMsg() {
        String expected = "subscriptionMsg";
        String actual = editvehiclesettingsImpl.getSubscriptionMsg();
        assertEquals(expected, actual);
    }

    @Test
    void getSelectPreferredDealerLabel() {
        String expected = "selectPreferredDealerLabel";
        String actual = editvehiclesettingsImpl.getSelectPreferredDealerLabel();
        assertEquals(expected, actual);
    }
    @Test
    void getRedirectionLink() {
        String expected = "#";
        String actual = editvehiclesettingsImpl.getRedirectionLink();
        assertEquals(expected, actual);
    }
    @Test
    void getTrashIcon() {
        String expected = "trashIcon";
        String actual = editvehiclesettingsImpl.getTrashIcon();
        assertEquals(expected, actual);
    }
    
}
