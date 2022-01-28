package com.toyota.tmna.lexusdrivers.core.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.osgi.service.component.ComponentContext;

import com.adobe.granite.crypto.CryptoSupport;
import com.toyota.tmna.lexusdrivers.core.configs.HeaderFactoryEndPointsConfig;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
class HeaderFactoryEndPointsTest {
	
	@Mock
	private HeaderFactoryEndPointsConfig hfEndPointsConfig;
	
	@InjectMocks 
	HeaderFactoryEndPoints hfep;
	
	@Mock
	private ComponentContext context;

	@Mock
	CryptoSupport cryptoSupport;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		Dictionary<String, Object> props=new Hashtable<String, Object>();
		props.put("analytics", "{\"url\":\"https://nexus.toyota.com/toyotanational/l-drivers-s/Bootstrap.js\"}");
		
		props.put("dcs1Private", "{ \"HostName\": \"next.staging.b2c.ws.tms.aws.toyota.com\",\"ApiKey\": \"{2d456c460424da51d8c2e1205fc871a833807ad13c56886d4be9ee1d42bdcfab44a14dbcb6b9b126a39d04fb5187a83c4ee7821485f6fb201cf715fae4defbc8}\"}");
		Mockito.when(context.getProperties()).thenReturn(props);
		hfep.activate(hfEndPointsConfig,context);
	}

	@Test
	public void activate() {
		assertNotNull(context.getProperties().get("analytics"));
	}

	@Test
	void readProperties() {
		assertEquals("{\"url\":\"https://nexus.toyota.com/toyotanational/l-drivers-s/Bootstrap.js\"}", context.getProperties().get("analytics"));
	}

	@Test
	void getServiceEndpoint() throws IOException {
		 assertNotNull(hfep.getEndPointsMap());
	}

	@Test
	void readPropertiesExcpetion() throws IOException {
		HeaderFactoryEndPoints hfep2 = new HeaderFactoryEndPoints();
		hfep2.readProperties("key", "value");
	}

}