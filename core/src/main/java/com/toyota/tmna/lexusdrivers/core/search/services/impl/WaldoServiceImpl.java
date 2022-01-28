package com.toyota.tmna.lexusdrivers.core.search.services.impl;

import java.io.IOException;
import java.util.Map;

import com.toyota.tmna.lexusdrivers.core.factory.IFactory;
import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.crypto.CryptoException;
import com.adobe.granite.crypto.CryptoSupport;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.toyota.tmna.lexusdrivers.core.search.ServiceClient;
import com.toyota.tmna.lexusdrivers.core.search.services.WaldoService;
import com.toyota.tmna.lexusdrivers.core.search.services.WaldoConfigs;
import com.toyota.tmna.lexusdrivers.core.util.SearchConstants;


@Component(service = WaldoService.class, immediate = true)
@Designate(ocd = WaldoConfigs.class)
public class WaldoServiceImpl  extends ServiceClient implements WaldoService{
    private static final long serialVersionUID = 1L;
    private String waldoReferer;
    private String waldoKey;
    private String waldoZIPEndPoint;
    private String waldoLatLangEndPoint;
    private String waldoZipCityStateEndPoint;

    @Reference
    private transient IFactory iFactory;

    private static final Logger LOGGER = LoggerFactory.getLogger(WaldoService.class);

    @Activate
    public void activate(WaldoConfigs config) throws IOException {
        waldoReferer = config.WaldoReferer();
        waldoKey = iFactory.getEndPointsMap().get("waldo").get("ApiKey");
        waldoZIPEndPoint = config.WaldoZipEndPoint();
        waldoLatLangEndPoint = config.WaldoLatLangEndPoint();
        waldoZipCityStateEndPoint = config.WaldoZipCityStateEndPoint();
    }

    @Override
    public String getLatlang(String param) throws IOException {
        return this.getStateLatLngResponse(waldoZIPEndPoint, param, waldoReferer, waldoKey);
    }

    @Override
    public String getZip(String lat, String lang) throws IOException {
        return this.getZipResponse(waldoLatLangEndPoint, lat, lang, waldoReferer, waldoKey);
    }
    @Override
   	public String getState(String zip) throws IOException {

		String state = StringUtils.EMPTY;
		String responseBody = this.getStateLatLngResponse(waldoZipCityStateEndPoint, zip, waldoReferer, waldoKey);
		JsonElement jsonElement = new JsonParser().parse(responseBody);
		JsonElement resultsElement = jsonElement.getAsJsonObject().get(SearchConstants.RESULTS);
		JsonArray jsonArray = resultsElement.getAsJsonArray();
		for (JsonElement element : jsonArray) {
			state = element.getAsJsonObject().get(SearchConstants.STATE_ABBR).toString();
		}

		return state;
      }

}
