package com.toyota.tmna.lexusdrivers.core.search.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UploadRequestTest {

	UploadRequest uploadRequest;
	private String type;
	private String id;
	
	@BeforeEach
	public void setUp() throws Exception {
		uploadRequest = new UploadRequest("test", "id");
	}
	
	@Test
    public void testOne() {
		uploadRequest = new UploadRequest("test", "id");
	    String id = uploadRequest.getId();
	    assertEquals("id", id);
    }
	
	@Test
    public void testTwo() {
		//uploadRequest = new UploadRequest("test", "id");
	    uploadRequest.setId("abc");
	    String id2 = uploadRequest.getId();
	    assertEquals("abc", id2);
	    uploadRequest.setType("type");
	    String type2 = uploadRequest.getType();
	    assertEquals("type", type2);
	    Disclaimer disclaimer = new Disclaimer();
	    uploadRequest.setFields(disclaimer);
	    Disclaimer fieldsObj = (Disclaimer) uploadRequest.getFields();
	    assertEquals(disclaimer, fieldsObj);
    }
	@Test
    public void tesDisclaimerRequest() {
		uploadRequest = new UploadRequest("test", "id",new Disclaimer());
	    String id = uploadRequest.getId();
	    assertEquals("id", id);
	    assertNotNull(uploadRequest.getFields());
	}
}
