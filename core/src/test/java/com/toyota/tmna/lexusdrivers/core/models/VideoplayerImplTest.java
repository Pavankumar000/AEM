package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.toyota.tmna.lexusdrivers.core.models.impl.VideoplayerImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class VideoplayerImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private VideoplayerImpl videoplayerImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(VideoplayerImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/VideoplayerImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		videoplayerImpl = context.request().adaptTo(VideoplayerImpl.class);
	}

	@Test
	void getTitle() {
		String expected = "title";
		String actual = videoplayerImpl.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getId() {
		String expected = "video source";
		String actual = videoplayerImpl.getId();
		assertEquals(expected, actual);
	}

	@Test
	void getVideo_type() {
		String expected = "youtube";
		String actual = videoplayerImpl.getVideo_type();
		assertEquals(expected, actual);
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = videoplayerImpl.getExportedType();
		assertEquals(expected, actual);
	}

	@Test
	void getVideo_title() {
		String expected = "video title";
		String actual = videoplayerImpl.getVideo_title();
		assertEquals(expected, actual);
	}
}
