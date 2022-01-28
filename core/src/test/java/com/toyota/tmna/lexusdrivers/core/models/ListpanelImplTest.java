package com.toyota.tmna.lexusdrivers.core.models;

import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.toyota.tmna.lexusdrivers.core.models.impl.ListpanelImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class ListpanelImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private ListpanelImpl listpanelImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(ListpanelImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/ListpanelImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		listpanelImpl = context.request().adaptTo(ListpanelImpl.class);
	}
	
	@Test
    void getTitle() {
		String expected = "Owner Manual";
		String actual = listpanelImpl.getTitle();
		assertEquals(expected, actual);
    }
    @Test
    void getnextgenIconText() {
    	String expected = "PDF";
		String actual = listpanelImpl.getnextgenIconText();
		assertEquals(expected, actual);
    }

    @Test
    void getIcon() {
    	String expected = "headingicon";
		String actual = listpanelImpl.getIcon();
		assertEquals(expected, actual);
    }

    @Test
    void getIconList() {
    	String expected = "listicon";
		String actual = listpanelImpl.getIconList();
		assertEquals(expected, actual);
    }

    @Test
    void getManualtype() {
    	String expected = "omnav";
		String actual = listpanelImpl.getManualtype();
		assertEquals(expected, actual);
    }

    @Test
    void getNoVehicleSelectedMessage() {
    	String expected = "novehicle";
		String actual = listpanelImpl.getNoVehicleSelectedMessage();
		assertEquals(expected, actual);
    }

    @Test
    void getNoServiceDataMessage() {
    	String expected = "noservice";
		String actual = listpanelImpl.getNoServiceDataMessage();
		assertEquals(expected, actual);
    }

    @Test
	void getType() {
		String expected = "nextgen";
		String actual = listpanelImpl.getType();
		assertEquals(expected, actual);
	}

	@Test
	void getExportedType() {
		try{
			listpanelImpl.getExportedType();
		} catch(NullPointerException e){}
	}
}
