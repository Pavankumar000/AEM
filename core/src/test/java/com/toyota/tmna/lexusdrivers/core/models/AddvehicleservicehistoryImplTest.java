package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.toyota.tmna.lexusdrivers.core.models.impl.LsscarouselImpl;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.models.impl.AddvehicleservicehistoryImpl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class AddvehicleservicehistoryImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private AddvehicleservicehistoryImpl addvehicleservicehistoryImpl;
	
	@BeforeEach
	void setUp() {
		context.addModelsForClasses(AddvehicleservicehistoryImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/AddvehicleservicehistoryImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,	Integer.MAX_VALUE);
		context.currentResource("/content");
		addvehicleservicehistoryImpl = context.request().adaptTo(AddvehicleservicehistoryImpl.class);
	}
	
	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = addvehicleservicehistoryImpl.getExportedType();
		assertEquals(expected, actual);
	}
	
	@Test
    void getRepairOrderLabel() {
        String expected = "repairOrderLabel";
        String actual = addvehicleservicehistoryImpl.getRepairOrderLabel();
        assertEquals(expected, actual);
    }
	
	@Test
    void getMileageLabel() {
        String expected = "mileageLabel";
        String actual = addvehicleservicehistoryImpl.getMileageLabel();
        assertEquals(expected, actual);
    }
	
	@Test
    void getMileageError() {
        String expected = "mileageError";
        String actual = addvehicleservicehistoryImpl.getMileageError();
        assertEquals(expected, actual);
    }
	
	@Test
    void getServiceDate() {
        String expected = "serviceDate";
        String actual = addvehicleservicehistoryImpl.getServiceDate();
        assertEquals(expected, actual);
    }
	
	@Test
    void getServiceDesc() {
        String expected = "serviceDesc";
        String actual = addvehicleservicehistoryImpl.getServiceDesc();
        assertEquals(expected, actual);
    }
	
	@Test
    void getServiceCategory() {
        String expected = "serviceCategory";
        String actual = addvehicleservicehistoryImpl.getServiceCategory();
        assertEquals(expected, actual);
    }
	
	@Test
    void getServiceCategoryError() {
        String expected = "serviceCategoryError";
        String actual = addvehicleservicehistoryImpl.getServiceCategoryError();
        assertEquals(expected, actual);
    }
	
	@Test
    void getAddAnotherServiceLabel() {
        String expected = "addAnotherServiceLabel";
        String actual = addvehicleservicehistoryImpl.getAddAnotherServiceLabel();
        assertEquals(expected, actual);
    }
	
	@Test
    void getServiceIncLabel() {
        String expected = "serviceIncLabel";
        String actual = addvehicleservicehistoryImpl.getServiceIncLabel();
        assertEquals(expected, actual);
    }
	
	@Test
    void getServiceLink() {
        String expected = "serviceLink";
        String actual = addvehicleservicehistoryImpl.getServiceLink();
        assertEquals(expected, actual);
    }	
	
	@Test
    void getServiceProviderLabel() {
        String expected = "serviceProviderLabel";
        String actual = addvehicleservicehistoryImpl.getServiceProviderLabel();
        assertEquals(expected, actual);
    }
	
	@Test
    void getEventLabel() {
        String expected = "eventLabel";
        String actual = addvehicleservicehistoryImpl.getEventLabel();
        assertEquals(expected, actual);
    }	
	
	@Test
    void getCommentsLabel() {
        String expected = "commentsLabel";
        String actual = addvehicleservicehistoryImpl.getCommentsLabel();
        assertEquals(expected, actual);
    }
	
	@Test
    void getCancelLabel() {
        String expected = "cancelLabel";
        String actual = addvehicleservicehistoryImpl.getCancelLabel();
        assertEquals(expected, actual);
    }	
	
	@Test
    void getdeleteEventLabel() {
        String expected = "deleteEventLabel";
        String actual = addvehicleservicehistoryImpl.getDeleteEventLabel();
        assertEquals(expected, actual);
    }
	
	// @Test
    // void getModalTitle() {
    //     String expected = "modalTitle";
    //     String actual = addvehicleservicehistoryImpl.getCloseModalTitle();
    //     assertEquals(expected, actual);
    // }	
	
	@Test
    void getModalSecondaryLabel() {
        String expected = "modalSecondaryLabel";
        String actual = addvehicleservicehistoryImpl.getModalSecondaryButton();
        assertEquals(expected, actual);
    }
	
	@Test
    void getModalPrimaryLabel() {
        String expected = "modalPrimaryLabel";
        String actual = addvehicleservicehistoryImpl.getModalPrimaryButton();
        assertEquals(expected, actual);
    }
	
	@Test
    void getModalDescription() {
        String expected = "modalDescription";
        String actual = addvehicleservicehistoryImpl.getCloseModalDescription();
        assertEquals(expected, actual);
    }	
	
	@Test
    void getDeleteRecordError() {
        String expected = "deleteRecordError";
        String actual = addvehicleservicehistoryImpl.getDeleteRecordError();
        assertEquals(expected, actual);
    }
	
	@Test
    void getSaveLabel() {
        String expected = "saveLabel";
        String actual = addvehicleservicehistoryImpl.getSaveLabel();
        assertEquals(expected, actual);
    }
	
	@Test
    void getUpdateRecordError() {
        String expected = "updateRecordError";
        String actual = addvehicleservicehistoryImpl.getUpdateRecordError();
        assertEquals(expected, actual);
    }
	
	@Test
    void getAddRecordError() {
        String expected = "addRecordError";
        String actual = addvehicleservicehistoryImpl.getAddRecordError();
        assertEquals(expected, actual);
    }
	
	@Test
    void getServiceFailError() {
        String expected = "serviceFailError";
        String actual = addvehicleservicehistoryImpl.getServiceFailError();
        assertEquals(expected, actual);
    }
	
	@Test
    void getProviderError() {
        String expected = "providerError";
        String actual = addvehicleservicehistoryImpl.getProviderError();
        assertEquals(expected, actual);
    }
	
	@Test
    void getProviderNameError() {
        String expected = "providerNameError";
        String actual = addvehicleservicehistoryImpl.getProviderNameError();
        assertEquals(expected, actual);
    }
	
	@Test
    void getServiceDescError() {
        String expected = "serviceDescError";
        String actual = addvehicleservicehistoryImpl.getServiceDescError();
        assertEquals(expected, actual);
    }
	
	@Test
    void getDateError() {
        String expected = "dateError";
        String actual = addvehicleservicehistoryImpl.getDateError();
        assertEquals(expected, actual);
    }
	
	@Test
    void getDescIcon() {
        String expected = "descIcon";
        String actual = addvehicleservicehistoryImpl.getDescIcon();
        assertEquals(expected, actual);
    }

    @Test
    void getModalCancelDescription() {
        String expected = "cancelDesc";
        String actual = addvehicleservicehistoryImpl.getModalCancelDescription();
        assertEquals(expected, actual);
    }

    @Test
    void getErrorsList() {
        addvehicleservicehistoryImpl = context.request().adaptTo(AddvehicleservicehistoryImpl.class);
        assert addvehicleservicehistoryImpl != null;
        Resource actual = addvehicleservicehistoryImpl.getErrorsList();
        assertNotNull(actual);
    }

    @Test
    void getModalIcon() {
        String expected = "modalIcon";
        String actual = addvehicleservicehistoryImpl.getModalIcon();
        assertEquals(expected, actual);
    }

    @Test
    void checkHistoryTest() {
        assertEquals("editHistoryCancelModalTitle", addvehicleservicehistoryImpl.getEditHistoryCancelModalTitle());
        assertEquals("editHistoryDeleteModalTitle", addvehicleservicehistoryImpl.getEditHistoryDeleteModalTitle());
        assertEquals("addHistoryDeleteModalTitle", addvehicleservicehistoryImpl.getAddHistoryDeleteModalTitle());
        assertEquals("addHistoryCancelModalTitle", addvehicleservicehistoryImpl.getAddHistoryCancelModalTitle());
    }

}
