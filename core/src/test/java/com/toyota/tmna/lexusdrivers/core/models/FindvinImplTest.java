package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.toyota.tmna.lexusdrivers.core.models.impl.FindvinImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class FindvinImplTest {
	
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private FindvinImpl findvinImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(FindvinImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/FindvinImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		findvinImpl = context.request().adaptTo(FindvinImpl.class);
	}
	
    @Test
    void getComponentType() {
    	String expected = "Modal";
		String actual = findvinImpl.getComponentType();
		assertEquals(expected, actual);
    }
    @Test
    void getImagePosition() {
    	String expected = "Below Desc";
		String actual = findvinImpl.getImagePosition();
		assertEquals(expected, actual);
    }

    @Test
    void getTitle() {
    	String expected = "Title";
		String actual = findvinImpl.getTitle();
		assertEquals(expected, actual);
    }

    @Test
    void getDescription() {
    	String expected = "des";
		String actual = findvinImpl.getDescription();
		assertEquals(expected, actual);
    }

    @Test
    void getShowSeperator() {
    	String expected = "true";
		String actual = findvinImpl.getShowSeperator();
		assertEquals(expected, actual);
    }

    @Test
    void getImage() {
    	String expected = "fimage";
		String actual = findvinImpl.getImage();
		assertEquals(expected, actual);
    }

    @Test
    void getAltText() {
    	String expected = "findvin";
		String actual = findvinImpl.getAltText();
		assertEquals(expected, actual);
    }

    @Test
    void getButtonLabel() {
    	String expected = "OK";
		String actual = findvinImpl.getButtonLabel();
		assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
    	String expected = "nt:unstructured";
		String actual = findvinImpl.getExportedType();
		assertEquals(expected, actual);
    }

}
