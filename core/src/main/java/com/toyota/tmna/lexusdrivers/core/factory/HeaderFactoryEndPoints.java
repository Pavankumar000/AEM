package com.toyota.tmna.lexusdrivers.core.factory;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.crypto.CryptoException;
import com.adobe.granite.crypto.CryptoSupport;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toyota.tmna.lexusdrivers.core.configs.HeaderFactoryEndPointsConfig;

@Component(service = IFactory.class,  immediate = true,
configurationPid = "com.toyota.tmna.lexusdrivers.core.factory.HeaderFactoryEndPoints",
name = "com.toyota.tmna.lexusdrivers.core.factory.HeaderFactoryEndPoints")
@Designate(ocd = HeaderFactoryEndPointsConfig.class)
public class HeaderFactoryEndPoints implements IFactory {

	private static final Logger log = LoggerFactory.getLogger(HeaderFactoryEndPoints.class);

	private static Map<String, Map<String, String>> endPointsMap = new HashMap<>();
	
	@Reference
	private CryptoSupport cryptoSupport;
	
	@Activate
	public void activate(HeaderFactoryEndPointsConfig config,ComponentContext context) {
		Dictionary<String, Object> prop = context.getProperties();
		log.info("properties size"+prop.size());
		Enumeration<String> keys = prop.keys();
		while(keys.hasMoreElements())
		{
			String key=keys.nextElement();
			String value = prop.get(key).toString();
			readProperties(key, value);
		}
		
	}

	protected void readProperties(String key, String value) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			if(StringUtils.isNotEmpty(value)) {
				@SuppressWarnings("unchecked")
				Map<String, String> mapvalue = mapper.readValue(value, Map.class);
				Map<String, String> uncryptedMap = new HashMap<String, String>();
				for (Map.Entry<String, String> entry : mapvalue.entrySet()) {
					String encryptedValue = entry.getValue();
					String unencryptedvalue=StringUtils.EMPTY;
					if (cryptoSupport != null) {
						if (this.cryptoSupport.isProtected(encryptedValue)) {
							try {
								unencryptedvalue = this.cryptoSupport.unprotect(encryptedValue);
								log.info("Inside decryption");
							} catch (CryptoException e) {
								log.error("Exception in encryptedValue {} and error massage {}"+encryptedValue, e.getMessage());
							}
						} else {
							unencryptedvalue = encryptedValue;
						}
					} else {
						unencryptedvalue = encryptedValue;
					}
					log.info("entry.getKey() : "+entry.getKey());
					log.info("unencryptedvalue ** : "+unencryptedvalue);
					uncryptedMap.put(entry.getKey(),unencryptedvalue);
				}
				log.info("key : "+key);
				log.info("values  : "+uncryptedMap.size());
				endPointsMap.put(key, uncryptedMap);
			}
		} catch (IOException ioe) { // Any property that is not a json will fail and will cn with remaining.
			log.error("Unable to readProperties IO : {}", ioe);
		}
	}

	@Override
	public Map<String, Map<String, String>> getEndPointsMap() {
		return endPointsMap;
	}
}