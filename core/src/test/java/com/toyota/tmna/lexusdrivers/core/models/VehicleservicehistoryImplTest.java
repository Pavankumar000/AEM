package com.toyota.tmna.lexusdrivers.core.models;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.models.impl.VehicleservicehistoryImpl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class VehicleservicehistoryImplTest {
	
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private VehicleservicehistoryImpl vehicleservicehistoryImpl;
	
	@BeforeEach
	void setUp() {
		context.addModelsForClasses(VehicleservicehistoryImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/VehicleservicehistoryImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		vehicleservicehistoryImpl = context.request().adaptTo(VehicleservicehistoryImpl.class);
	}
	
	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = vehicleservicehistoryImpl.getExportedType();
		assertEquals(expected, actual);
	}
	

    @Test
    void getPrintIcon() {
        String expected = "printIcon";
        String actual = vehicleservicehistoryImpl.getPrintIcon();
        assertEquals(expected, actual);
    }
    
    @Test
    void getPrintLabel() {
        String expected = "printLabel";
        String actual = vehicleservicehistoryImpl.getPrintLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getAddServiceLink() {
        String expected = "addServiceLink";
        String actual = vehicleservicehistoryImpl.getAddServiceLink();
        assertEquals(expected, actual);
    }

    @Test
    void getAddServiceLabel() {
        String expected = "addServiceLabel";
        String actual = vehicleservicehistoryImpl.getAddServiceLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getShowLessLabel() {
        String expected = "showLessLabel";
        String actual = vehicleservicehistoryImpl.getShowLessLabel();
        assertEquals(expected, actual);
    }

    
    @Test
    void getReadMoreLabel() {
        String expected = "readMoreLabel";
        String actual = vehicleservicehistoryImpl.getReadMoreLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getDescriptionLabel() {
        String expected = "descriptionLabel";
        String actual = vehicleservicehistoryImpl.getDescriptionLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getServiceLabel() {
        String expected = "serviceLabel";
        String actual = vehicleservicehistoryImpl.getServiceLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getEditLink() {
        String expected = "editLink";
        String actual = vehicleservicehistoryImpl.getEditLink();
        assertEquals(expected, actual);
    }

    @Test
    void getEditLabel() {
        String expected = "editLabel";
        String actual = vehicleservicehistoryImpl.getEditLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getReportedByLabel() {
        String expected = "reportedByLabel";
        String actual = vehicleservicehistoryImpl.getReportedByLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getRepairLabel() {
        String expected = "repairLabel";
        String actual = vehicleservicehistoryImpl.getRepairLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getDateLabel() {
        String expected = "dateLabel";
        String actual = vehicleservicehistoryImpl.getDateLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getMilesLabel() {
        String expected = "milesLabel";
        String actual = vehicleservicehistoryImpl.getMiles();
        assertEquals(expected, actual);
    }

    @Test
    void getFilterHistoryByYear() {
        String expected = "filterHistoryByYear";
        String actual = vehicleservicehistoryImpl.getFilterHistoryByYear();
        assertEquals(expected, actual);
    }

    @Test
    void getVinLabel() {
        String expected = "vinLabel";
        String actual = vehicleservicehistoryImpl.getVinLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getServiceHistoryForLabel() {
        String expected = "serviceHistoryForLabel";
        String actual = vehicleservicehistoryImpl.getServiceHistoryForLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getDisplaytitle() {
        String expected = "displaytitle";
        String actual = vehicleservicehistoryImpl.getDisplaytitle();
        assertEquals(expected, actual);
    }

    @Test
    void getErrorTitleLabel() {
        String expected = "errorTitleLabel";
        String actual = vehicleservicehistoryImpl.getErrorTitleLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getErrorDescLabel() {
        String expected = "errorDescLabel";
        String actual = vehicleservicehistoryImpl.getErrorDescLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getPrintLink() {
        String expected = "printLink";
        String actual = vehicleservicehistoryImpl.getPrintLink();
        assertEquals(expected, actual);
    }

     @Test
    void getTermsDescription() {
        String expected = "termsDescription";
        String actual = vehicleservicehistoryImpl.getTermsDescription();
        assertEquals(expected, actual);
    }

     @Test
    void getTermsTitle() {
        String expected = "termsTitle";
        String actual = vehicleservicehistoryImpl.getTermsTitle();
        assertEquals(expected, actual);
    }

}
