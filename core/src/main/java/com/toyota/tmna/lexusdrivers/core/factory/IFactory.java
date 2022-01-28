package com.toyota.tmna.lexusdrivers.core.factory;
import java.util.Map;
/*
* A factory for creating I objects.
*/
public interface IFactory {

	/**
	 * Gets the service endpoint.
	 *
	 * @param serviceName the method
	 * @return the service endpoint
	 */
	//String getServiceEndpoint(final String serviceName);
	Map<String, Map<String, String>> getEndPointsMap();
}
