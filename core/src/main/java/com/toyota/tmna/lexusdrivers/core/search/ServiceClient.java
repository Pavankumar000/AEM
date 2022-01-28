package com.toyota.tmna.lexusdrivers.core.search;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.toyota.tmna.lexusdrivers.core.util.SearchConstants;

public class ServiceClient implements Serializable{
	private static final long serialVersionUID = 5286496917586674662L;
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceClient.class);
    
	public String getStateLatLngResponse(String url, String zip, String referer, String key) throws IOException {
		String responseBody = StringUtils.EMPTY;
		HttpUriRequest request = RequestBuilder.get()
	               .setUri(url)
	               .addParameter(SearchConstants.ZIP,zip)
	               .setHeader(SearchConstants.HEADER_REFERER, referer)
	               .setHeader(SearchConstants.HEADER_X_API_KEY, key)
	               .build();
		 try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
 	           try (CloseableHttpResponse response = httpClient.execute(request)) {
 	               responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
 	               LOGGER.info("responseBody in getStateLatLngResponse ::" + responseBody);
 	           }
		 }
		 return responseBody;
	}
	
	public String getZipResponse(String url, String lat, String lang, String referer, String key) throws IOException {
		String responseBody = StringUtils.EMPTY;
		HttpUriRequest request = RequestBuilder.get()
                .setUri(url)
                .addParameter(SearchConstants.LAT, lat)
                .addParameter(SearchConstants.LNG, lang)
                .setHeader(SearchConstants.HEADER_REFERER, referer)
                .setHeader(SearchConstants.HEADER_X_API_KEY, key)
                .build();

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
	            LOGGER.info("responseBody in getZipResponse ::" + responseBody);
            }
        }
        return responseBody;
	}
	
}
