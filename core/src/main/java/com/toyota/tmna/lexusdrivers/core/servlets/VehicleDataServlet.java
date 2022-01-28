package com.toyota.tmna.lexusdrivers.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;

import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.tagging.TagManager;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.toyota.tmna.lexusdrivers.core.bean.VehicleDataTags;
import com.toyota.tmna.lexusdrivers.core.util.AEMServletUtil;

/**
 * Servlet that will return vehicle data for an user. The
 * {@link SlingSafeMethodsServlet} shall be used for HTTP methods that are
 * idempotent. For write operations use the {@link SlingAllMethodsServlet}.
 */
@Component( service = Servlet.class,
property = {
		"sling.servlet.resourceTypes =" + ConstantsUtil.SERVLET_RESOURCE_TYPE,
		"sling.servlet.selectors=" + "vehicledata",
		"sling.servlet.extensions=" + ConstantsUtil.SERVLET_EXTENSIONS})
public class VehicleDataServlet extends SlingSafeMethodsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -183573336267832396L;
	private static final Logger LOGGER = LoggerFactory.getLogger(VehicleDataServlet.class);

	private static final String SEPARATOR_COMMA = ",";
	private static final String SEPARATOR_AMP = "&";
	private static final String SEPARATOR_EQUAL = "=";

	private static final String PROP_FUEL_GRADES = "FuelGrades";
	private static final String PROP_TANK_CAPACITY = "TankCapacity";

	private static final String PARAM_TYPE = "type";
	private static final String PARAM_MULTIPLE_VEHICLE = "multipleVehicles";
	private static final String PARAM_TRIM = "trim";

	private static final String TYPE_BANNER = "banner";
	private static final String TYPE_JELLY = "jelly";
	private static final String TYPE_TRIM = "trim";
	private static final String TYPE_VHR = "vhr";
	private static final String TYPE_ALL = "all";
	private static final String TYPE_FEATURE = "feature";

	private static final String KEY_DATA = "data";
	private static final String KEY_BANNER = "banner";
	private static final String KEY_VEHICLE_ID = "vehicleId";
	private static final String KEY_JELLY = "jellyImage";
	private static final String KEY_TRIM = "trimData";
	private static final String KEY_VHR = "VHRjellyImage";
	private static final String KEY_ALL = "All";
	private static final String KEY_FEATURE = "feature";
	private static final String KEY_DESKTOP_IMAGE = "desktopImage";
	private static final String KEY_TABLET_IMAGE = "tabletImage";
	private static final String KEY_MOBILE_IMAGE = "mobileImage";
	private static final String KEY_IMAGE_SOURCE = "imageSource";
	private static final String KEY_VIDEO_BANNER = "videoBanner";
	private static final String KEY_VIDEO_SOURCE = "videoSource";
	private static final String KEY_FUEL_GRADES = "fuelGrades";
	private static final String KEY_TANK_CAPACITY = "tankCapacity";
	private static final String KEY_SRC = "src";
	private static final String KEY_ALT = "alt";
	private static final String KEY_LEGAL_COPY = "LegalCopy";
	private static final String KEY_LSS_CAPABLE = "LSSCapable";
	private static final String KEY_ENFORM_CAPABLE = "EnformCapable";
	private static final String KEY_REMOTE_CAPABLE = "RemoteCapable";

	private static final String DEFAULT_CF_PATH="/content/dam/lexusdrivers/content-fragments/vehicles/default";
	private static final String REGULAR_CF_PATH="/content/dam/lexusdrivers/content-fragments/vehicles";
	private static final String BANNER_CF_SUB_PATH="/banner-visualizer/jcr:content/data/master";
	private static final String VHR_CF_SUB_PATH="/vhr-vehicle-image/jcr:content/data/master";
	private static final String JELLY_CF_SUB_PATH="/garage-vehicle-image/jcr:content/data/master";
	
	private static final String PATH_SLASH ="/";

	

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws IOException {

		PrintWriter out = response.getWriter();
		JsonObject output = new JsonObject();
		String types = request.getParameter(PARAM_TYPE);
		String mutipleVehicleData = request.getParameter(PARAM_MULTIPLE_VEHICLE)!=null?request.getParameter(PARAM_MULTIPLE_VEHICLE):"";
		LOGGER.info(" Updated Parameters  Without Split "+mutipleVehicleData);
		
		LOGGER.info("Type : "+types);
		String[] mutipleVehicleDataArray = mutipleVehicleData.split(SEPARATOR_COMMA);
		JsonObject vehicles = new JsonObject();
		try {
			for (int i=0;i<mutipleVehicleDataArray.length;i++) {
				JsonObject vehicle = new JsonObject();
				String vehicleId=StringUtils.EMPTY;
				LOGGER.info(" Parameters="+mutipleVehicleDataArray[i]);
				String[] vehicleDataTagsArray=mutipleVehicleDataArray[i].split(";");
				if (vehicleDataTagsArray[0].split(":")[0].equals(KEY_VEHICLE_ID)) {
					vehicleId=vehicleDataTagsArray[0].split(":")[1];					
				}
				VehicleDataTags tags = new VehicleDataTags(mutipleVehicleDataArray[i],request);
				String cfString=tags.getCfPath().replace("-FSPORT", "-FSport");
				String cfBannerString=tags.getCfBannerPath().replace("-FSPORT", "-FSport");
				tags.setCfPath(cfString);				
				tags.setCfBannerPath(cfBannerString);
				TagManager tm = request.getResourceResolver().adaptTo(TagManager.class);
				LOGGER.info(" Tags created : {}", tags);
				setVehicleData(tm,types,vehicle,request,tags);
				if(vehicleId.isEmpty()) {
					vehicles.add("vehicle" , vehicle);
				}else {
					vehicles.add(vehicleId , vehicle);
				}				
			}
			output.add(KEY_DATA, vehicles);	
		} catch (JsonIOException e) {
			out.write(AEMServletUtil.getErrorJson(e.getMessage()).toString());
			LOGGER.error(" JSON exception occured : {0}", e);
		}
		
		out.write(output.toString());
		out.flush();
		out.close();
	}

	private JsonObject getBannerData(ValueMap properties) throws JsonIOException {
		JsonObject banner = new JsonObject();
		if(properties!=null) {
			JsonObject videoBanner = new JsonObject();		
			banner.addProperty(KEY_DESKTOP_IMAGE, properties.get("DesktopImage") != null ?  properties.get("DesktopImage").toString(): StringUtils.EMPTY);
			banner.addProperty(KEY_MOBILE_IMAGE, properties.get("MobileImage") != null ?  properties.get("MobileImage").toString(): StringUtils.EMPTY);
			banner.add(KEY_VIDEO_BANNER, videoBanner);
			banner.addProperty(KEY_TABLET_IMAGE, properties.get("TabletImage") != null ?  properties.get("TabletImage").toString(): StringUtils.EMPTY);
			banner.addProperty(KEY_IMAGE_SOURCE, properties.get("ImageSource") != null ?  properties.get("ImageSource").toString(): StringUtils.EMPTY);
			banner.addProperty(KEY_LEGAL_COPY, properties.get("LegalCopy") != null ?  properties.get("LegalCopy").toString(): StringUtils.EMPTY);
			banner.addProperty(KEY_VIDEO_SOURCE,properties.get("VideoSource") != null ?  properties.get("VideoSource").toString(): StringUtils.EMPTY);
		}
		
		return banner;
	}	

	private JsonObject getVhrImage(ValueMap properties) {
		JsonObject imgJson = new JsonObject();
		if(properties!=null) {
			try {
				String description = properties.get("Description")!=null?properties.get("Description").toString():StringUtils.EMPTY;
				imgJson.addProperty(KEY_SRC, properties.get("VehicleImage") != null ?  properties.get("VehicleImage").toString(): StringUtils.EMPTY);
				imgJson.addProperty(KEY_ALT, description);
			} catch (JsonIOException e) {
				LOGGER.error(" JSON exception occured while preparing image JSON: {0}", e);
			}
		}
		return imgJson;
	}

	private JsonObject getJellyImage(ValueMap jellycfProperties) {
		JsonObject imgJson = new JsonObject();
		if(jellycfProperties!=null) {
			try {
				String description = jellycfProperties.get("Description")!=null?jellycfProperties.get("Description").toString():StringUtils.EMPTY;
				if(jellycfProperties.get("DesktopImage")!=null) {
					imgJson.addProperty(KEY_SRC, jellycfProperties.get("DesktopImage") != null ?  jellycfProperties.get("DesktopImage").toString(): StringUtils.EMPTY);
				}else {
					imgJson.addProperty(KEY_SRC, jellycfProperties.get("VehicleImage") != null ?  jellycfProperties.get("VehicleImage").toString(): StringUtils.EMPTY);
				}				
				imgJson.addProperty(KEY_ALT, description);
			} catch (JsonIOException e) {
				LOGGER.error(" JSON exception occured while preparing image JSON: {0}", e);
			}	
		}			
		return imgJson;
	}	

	private JsonObject getTrim(SlingHttpServletRequest request, VehicleDataTags tags) throws JsonIOException {
		JsonObject trim = new JsonObject();
		ResourceResolver resolver = request.getResourceResolver();
		Resource resource = resolver.getResource(tags.getCfPath());
		if(tags.getCfPath().contains("-FSport")&& resource==null) {
			resource=resolver.getResource(tags.getCfPath().replace("-FSport", ""));
		}
		String trimVal = request.getParameter(PARAM_TRIM);
		if(request.getParameter(PARAM_MULTIPLE_VEHICLE)!=null) {
			trimVal=tags.getTrim();
		}
		if (null == resource) {
			return trim;
		}
		ValueMap properties = ResourceUtil.getValueMap(resource);

		String fuelGrades = properties.get(PROP_FUEL_GRADES, String.class);
		String tankCapacity = properties.get(PROP_TANK_CAPACITY, String.class);
		if (fuelGrades == null || tankCapacity == null) {
			return trim;
		}

		trim.addProperty(KEY_FUEL_GRADES, gtTrimVal(fuelGrades, trimVal));
		trim.addProperty(KEY_TANK_CAPACITY, gtTrimVal(tankCapacity, trimVal));
		return trim;
	}

	private String gtTrimVal(String fuelGrades, String trimVal) {

		for (String item : fuelGrades.split(SEPARATOR_AMP)) {
			String[] val = item.split(SEPARATOR_EQUAL);
			if (val[0].equalsIgnoreCase(trimVal)) {
				return val[1];
			}
		}
		return StringUtils.EMPTY;
	}
	
	private String gtHTupdated(String value) {	
		StringBuilder valueSB=new StringBuilder(value.toUpperCase());
		if(valueSB.length()>2) {
			if(Character.toString(valueSB.charAt(2)).equalsIgnoreCase("h"))
				valueSB.setCharAt(2, 'h');		
			if(Character.toString(valueSB.charAt(2)).equalsIgnoreCase("t"))
				valueSB.setCharAt(2, 't');	
		}
		value=valueSB.toString().replace("-FSPORT", "-FSport");
		return value;
	}
	
	private JsonObject getFeatureData(ValueMap properties) throws JsonIOException {
		JsonObject banner = new JsonObject();
		if(properties!=null) {
			boolean lssCapable = (null != properties.get("LSSCapable")) ? (boolean) properties.get("LSSCapable") : false;
			boolean enformCapable = (null != properties.get("EnformCapable")) ? (boolean) properties.get("EnformCapable") : false;
			boolean remoteCapable = (null != properties.get("RemoteCapable")) ?  (boolean) properties.get("RemoteCapable") : false;
			
			banner.addProperty(KEY_LSS_CAPABLE,lssCapable);
			banner.addProperty(KEY_ENFORM_CAPABLE,enformCapable);
			banner.addProperty(KEY_REMOTE_CAPABLE,remoteCapable);
		}else {
			banner.addProperty(KEY_LSS_CAPABLE,false);
			banner.addProperty(KEY_ENFORM_CAPABLE,false);
			banner.addProperty(KEY_REMOTE_CAPABLE,false);
		}
		
		return banner;
	}	
	
	public void setVehicleData(TagManager tm, String types, JsonObject vehicle, SlingHttpServletRequest request, VehicleDataTags tags) {
		
		String tagsArray[]=tags.getTag().split("/");
		String model=StringUtils.EMPTY;
		String year=StringUtils.EMPTY;
		String code=StringUtils.EMPTY;
		String bannerRegularCFpath= StringUtils.EMPTY;
		String bannerDefaultCFpath;
		String vhrRegularCFpath= StringUtils.EMPTY;
		String vhrDefaultCFpath;
		if(tagsArray.length==6) {
		 model=tagsArray[tagsArray.length-2];
		 year = tagsArray[tagsArray.length-3];
		 code = tagsArray[tagsArray.length-1];
		 bannerRegularCFpath=REGULAR_CF_PATH+PATH_SLASH+year+PATH_SLASH+gtHTupdated(model)+PATH_SLASH+code+BANNER_CF_SUB_PATH;
		 vhrRegularCFpath=REGULAR_CF_PATH+PATH_SLASH+year+PATH_SLASH+gtHTupdated(model)+PATH_SLASH+code+VHR_CF_SUB_PATH;		
		}
		if(tagsArray.length==5) {
			 model=tagsArray[tagsArray.length-1];
			 year = tagsArray[tagsArray.length-2];
			 bannerRegularCFpath=REGULAR_CF_PATH+PATH_SLASH+year+PATH_SLASH+gtHTupdated(model)+BANNER_CF_SUB_PATH;
			 vhrRegularCFpath=REGULAR_CF_PATH+PATH_SLASH+year+PATH_SLASH+gtHTupdated(model)+VHR_CF_SUB_PATH;		
		}		
		bannerDefaultCFpath=DEFAULT_CF_PATH+PATH_SLASH+gtHTupdated(model)+BANNER_CF_SUB_PATH;
		ValueMap bannerRegularcfProperties = getProperties(request, bannerRegularCFpath);
		ValueMap bannerDefaultcfProperties = getProperties(request, bannerDefaultCFpath);
		ValueMap finalbannercfProperties = bannerDefaultcfProperties;
		if(bannerRegularcfProperties!=null) {
			finalbannercfProperties=bannerRegularcfProperties;
		}		
		
		vhrDefaultCFpath=DEFAULT_CF_PATH+PATH_SLASH+gtHTupdated(model)+VHR_CF_SUB_PATH;
		ValueMap vhrRegularcfProperties =getProperties(request, vhrRegularCFpath);
		ValueMap finalvhrcfProperties = getProperties(request, vhrDefaultCFpath);
		if(vhrRegularcfProperties!=null) {
			finalvhrcfProperties=vhrRegularcfProperties;
		}	
		String jellyColorcodeCFpath=StringUtils.EMPTY;
		if(code!=null&&!code.equalsIgnoreCase("")) {
			jellyColorcodeCFpath=REGULAR_CF_PATH+PATH_SLASH+year+PATH_SLASH+gtHTupdated(model)+PATH_SLASH+code+BANNER_CF_SUB_PATH;
		}
		
		String jellyDefaultCFpath=DEFAULT_CF_PATH+PATH_SLASH+gtHTupdated(model)+JELLY_CF_SUB_PATH;
		
		Resource jellyResource=getJellyresource(jellyColorcodeCFpath,request,jellyDefaultCFpath);
		
		ValueMap jellycfProperties =jellyResource!=null?jellyResource.getValueMap():null;
		String[]featureStrings=bannerRegularCFpath.split("/");	
		StringBuffer featurepath=new StringBuffer();
		for(int i=0;i<8;i++) {
			featurepath=featurepath.append(featureStrings[i]).append("/");
		}
			
		ValueMap featureProperties = getFeatureProperties(request, featurepath.toString());;
		
		setVehicleJson(types,finalbannercfProperties,jellycfProperties,finalvhrcfProperties,featureProperties,tags, request,vehicle);
	
	}
	
	private ValueMap getProperties(SlingHttpServletRequest request, String cfPath) {
		Resource resource = request. getResourceResolver().getResource(cfPath);
		if(cfPath.contains("-FSport")&&resource==null) {
			resource = request. getResourceResolver().getResource(cfPath.replace("-FSport", ""));	
		}
		return resource!=null?resource.getValueMap():null;
	}
	
	private ValueMap getFeatureProperties(SlingHttpServletRequest request, String cfPath) {
		Resource resource = request. getResourceResolver().getResource(cfPath+"Model/vehicle-feature/jcr:content/data/master");
		return resource!=null?resource.getValueMap():null;
	}
	
	private Resource getJellyresource(String jellyColorcodeCFpath,SlingHttpServletRequest request,String jellyDefaultCFpath) {
		Resource jellyResource = !jellyColorcodeCFpath.equalsIgnoreCase(StringUtils.EMPTY)?request. getResourceResolver().getResource(jellyColorcodeCFpath):request. getResourceResolver().getResource(jellyDefaultCFpath);
		if(jellyColorcodeCFpath.contains("-FSport")&&jellyResource==null)
			jellyResource = request.getResourceResolver().getResource(jellyColorcodeCFpath.replace("-FSport", ""));
		if(jellyDefaultCFpath.contains("-FSport")&&jellyResource==null)
			jellyResource = request.getResourceResolver().getResource(jellyDefaultCFpath.replace("-FSport", ""));
		if(jellyResource==null)
			jellyResource = request.getResourceResolver().getResource(jellyDefaultCFpath);
		
		return jellyResource;
	}

	public void setVehicleJson(String types,ValueMap finalbannercfProperties,ValueMap jellycfProperties,ValueMap finalvhrcfProperties, ValueMap featureProperties, VehicleDataTags tags, SlingHttpServletRequest request,JsonObject vehicle) {
		
		try{
			
			for (String type : types.split(SEPARATOR_COMMA)) {
		
			switch (type) {
			case TYPE_BANNER:
				vehicle.add(KEY_BANNER, getBannerData(finalbannercfProperties));
				break;

			case TYPE_JELLY:
				vehicle.add(KEY_JELLY, getJellyImage(jellycfProperties));
				break;

			case TYPE_TRIM:
				vehicle.add(KEY_TRIM, getTrim(request, tags));
				break;

			case TYPE_VHR:
				vehicle.add(KEY_VHR, getVhrImage(finalvhrcfProperties));
				break;
			case TYPE_FEATURE:
				vehicle.add(KEY_FEATURE, getFeatureData(featureProperties));
				break;
			case TYPE_ALL:
				vehicle.add(KEY_VHR, getVhrImage(finalvhrcfProperties));
				vehicle.add(KEY_TRIM, getTrim(request, tags));
				vehicle.add(KEY_JELLY, getJellyImage(jellycfProperties));
				vehicle.add(KEY_BANNER, getBannerData(finalbannercfProperties));
				vehicle.add(KEY_FEATURE, getFeatureData(featureProperties));
				break;
			default:
				break;
				}
			}
		} catch (JsonIOException e) {
			LOGGER.error(" JSON exception occured : {0}", e);
		 }
	}
}
