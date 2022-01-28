package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.factory.IFactory;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class HeaderConfigurationTest {
	
    private final AemContext context = new AemContext();
    
    @InjectMocks
    private   HeaderConfiguration headerConfiguration;
    
    @Mock
    IFactory headerFactory ;
    
    @Mock
    ResourceResolver resolver;
    
    @Mock
    Resource SRMResource;
    
    @Mock
    AppConfig cfSRM ;
    
    private Map<String, Map<String, String>> endPointsMap = new HashMap<>();

    @BeforeEach
    void setUp() {
    	MockitoAnnotations.initMocks(this);
    	Map<String,String> config=new HashMap<String, String>();
    	config.put("url", "https://nexus.toyota.com/toyotanational/l-drivers-s/Bootstrap.js");
    	endPointsMap.put("analytics", config);
    	config=new HashMap<String, String>();
    	config.put("HostName", "next.staging.b2c.ws.tms.aws.toyota.com");
    	endPointsMap.put("dcs1Private", config);
        Mockito.when(headerFactory.getEndPointsMap()).thenReturn(endPointsMap);
        headerConfiguration.init();
    }

    @Test
    void getXeosapikey() {
      Map<String, Map<String, String>> actual = headerConfiguration.getExternalService();
        assertNotNull(actual);
        assertEquals("https://nexus.toyota.com/toyotanational/l-drivers-s/Bootstrap.js", actual.get("analytics").get("url"));
    }

    @Test
    void getAppConfig() {
    	Mockito.when(resolver.resolve("/content/dam/lexusdrivers/content-fragments/appconfig/app-config")).thenReturn(SRMResource);
    	Mockito.when(SRMResource.adaptTo(AppConfig.class)).thenReturn(cfSRM);
        AppConfig actual = headerConfiguration.getAppConfigs();
        assertNotNull(actual);
    }

    @Test
    void getExportedType() {
         String actual = headerConfiguration.getExportedType();
         assertEquals(ConstantsUtil.CONFIG_PATH,actual);
    }
}