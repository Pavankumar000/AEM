package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.toyota.tmna.lexusdrivers.core.models.impl.TileComponentImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class TileComponentImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private TileComponentImpl tileComponentImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(TileComponentImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/TileComponentImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		tileComponentImpl = context.request().adaptTo(TileComponentImpl.class);
	}
	
	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = tileComponentImpl.getExportedType();
		assertEquals(expected, actual);
	}

	@Test
	void getTiletitle() {
		String expected = "Tile Title";
		String actual = tileComponentImpl.getTiletitle();
		assertEquals(expected, actual);
	}

	@Test
	void getTitleicon() {
		String expected = "/content/dam/lexusdrivers/media/icons/waning-lights_for_delete/Master Warning.png";
		String actual = tileComponentImpl.getTitleicon();
		assertEquals(expected, actual);
	}

	@Test
	void getIconerrormsg() {
		String expected = "asIcon for Error Message";
		String actual = tileComponentImpl.getIconerrormsg();
		assertEquals(expected, actual);
	}

	@Test
	void getErromsg() {
		String expected = "Errorr mEssage";
		String actual = tileComponentImpl.getErromsg();
		assertEquals(expected, actual);
	}

	@Test
	void getErrorctalabel() {
		String expected = "CTA Label for Error Message";
		String actual = tileComponentImpl.getErrorctalabel();
		assertEquals(expected, actual);
	}

	@Test
	void getErrorctalink() {
		String expected = "Error CTA Link";
		String actual = tileComponentImpl.getErrorctalink();
		assertEquals(expected, actual);
	}

	@Test
	void getType() {
		String expected = "type";
		String actual = tileComponentImpl.getType();
		assertEquals(expected, actual);
	}

	@Test
	void getSmallTileMessage() {
		String expected = "smallTileMessage";
		String actual = tileComponentImpl.getSmallTileMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getMediumTileMessage() {
		String expected = "mediumTileMessage";
		String actual = tileComponentImpl.getMediumTileMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	void getTilesList() {
		Resource expected = context.resourceResolver().getResource("/content/tilesList");
		tileComponentImpl = context.request().adaptTo(TileComponentImpl.class);
        assert tileComponentImpl != null;
        Resource actual = tileComponentImpl.getTilesList();
        assertNotNull(actual);
        assert expected != null;
        assertEquals(expected.getPath(), actual.getPath());
        assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}
}
