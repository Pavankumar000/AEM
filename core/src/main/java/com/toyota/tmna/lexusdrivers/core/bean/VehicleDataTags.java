package com.toyota.tmna.lexusdrivers.core.bean;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VehicleDataTags {	

	private static final Logger LOGGER = LoggerFactory.getLogger(VehicleDataTags.class);
	
	private static final String TAG_ROOT_PATH = "/lexusdrivers/vehicles";
	private static final String TAG_DEFAULT_ROOT_PATH = "/lexusdrivers/vehicles/default";
	private static final String CONTENTFINDER_PATH = "/content/dam/lexusdrivers/content-fragments/vehicles/default";
	private static final String CONTENTFRAGMENT_PATH = "/content/dam/lexusdrivers/content-fragments/vehicles";
	private static final String CONTENTFINDER_TRIM_PATH = "/TrimData/TrimData/jcr:content/data/master";
	private static final String VISUALIZER_PATH="banner-visualizer/jcr:content/data/master";
	private static final String ROOT_VISUALIZER_PATH="/content/dam/lexusdrivers/media/images/visualizers";
	private static final String ROOT_VHR_PATH="/content/dam/lexusdrivers/media/images/VHR";
	private static final String FSPORT = "-fsport";
	private static final String FSPORT_2 = "-FSport";
	private static final String FSPORT_3 = "-Fsport";
	private static final String PARAM_YEAR = "year";
	private static final String PARAM_MODEL = "model";
	private static final String PARAM_CODE = "code";
	private static final String PARAM_TRIM = "trim";
	private static final String PARAM_FSPORT = "fsport";
	private static final String PATH_SLASH = "/";


	private static final String PATH_DEFAULT="default";
	private static final String SEPERATOR="_";
	
	private String cfPath;
	private String cfBannerPath;
	private String tag;
	private String modelTag;
	private String fsportsTag;
	private String defaultTag;
	private String trim;
	private boolean tagFolderExists=false;
	private boolean tagFolderExistsVHR=false;


	public VehicleDataTags(String vehicleData,SlingHttpServletRequest request) {
		StringBuilder sbTags = new StringBuilder();
		StringBuilder sbTagsFs = new StringBuilder();
		String[] vehicleDataTagsArray =vehicleData.split(";");	
		String year;
		String model;
		String bannerModelValue;
		String code;
		String trim;
		String incomingModelParam;
		String fsport =StringUtils.EMPTY;
		
		String parameterData;
		if(vehicleData.isEmpty()) {
			 parameterData=setParameterData(request);			
		}else {
			parameterData=setParameterDataForMultipleVehicles(vehicleDataTagsArray);
		}			
		String[]parameterDataArray=parameterData.split(SEPERATOR);		
		year=parameterDataArray[0].split(":").length>1?parameterDataArray[0].split(":")[1]:StringUtils.EMPTY;
		model=parameterDataArray[1].split(":").length>1?parameterDataArray[1].split(":")[1]:StringUtils.EMPTY;
		incomingModelParam=parameterDataArray[2].split(":").length>1?parameterDataArray[2].split(":")[1]:StringUtils.EMPTY;
		bannerModelValue=parameterDataArray[3].split(":").length>1?parameterDataArray[3].split(":")[1]:StringUtils.EMPTY;
		code=parameterDataArray[4].split(":").length>1?parameterDataArray[4].split(":")[1]:StringUtils.EMPTY;
		trim=parameterDataArray[5].split(":").length>1?parameterDataArray[5].split(":")[1]:StringUtils.EMPTY;		
		this.fsportsTag=fsport;
		sbTags=getsbTags(sbTags,year);	
		setFSportTag(sbTags,sbTagsFs,model,code);
		
		sbTags.append(model.toLowerCase());
		this.modelTag = sbTags.toString();
		
		setCodetosbTags(sbTags,code);		
		
		this.tag = sbTags.toString();
		this.trim=trim;
		
		this.defaultTag = TAG_DEFAULT_ROOT_PATH.concat(PATH_SLASH).concat(model.toLowerCase());

		
		StringBuilder sbCF = new StringBuilder();
		StringBuilder sbCFBanner = new StringBuilder();
		sbCFBanner.append(CONTENTFRAGMENT_PATH).append(PATH_SLASH);
		sbCF.append(CONTENTFINDER_PATH).append(PATH_SLASH);
		setCFData(model,year,incomingModelParam,bannerModelValue,code,sbCF,sbCFBanner);		
		sbCF.append(CONTENTFINDER_TRIM_PATH);
		this.cfPath = sbCF.toString();
		this.cfBannerPath=sbCFBanner.toString();
		setTagFolders(request,year,bannerModelValue);
				
		}	
	
	public StringBuilder getsbTags(StringBuilder sbTags, String year) {
		return sbTags.append(TAG_ROOT_PATH).append(PATH_SLASH).append(year!=null && !year.isEmpty() ? (year+PATH_SLASH):"");
	}

	public String setParameterData(SlingHttpServletRequest request) {
		String	year=request.getParameter(PARAM_YEAR)!=null?request.getParameter(PARAM_YEAR):StringUtils.EMPTY;
		String	model=request.getParameter(PARAM_MODEL)!=null?request.getParameter(PARAM_MODEL):StringUtils.EMPTY;
		String	incomingModelParam=request.getParameter(PARAM_MODEL)!=null?request.getParameter(PARAM_MODEL):StringUtils.EMPTY;
		String	bannerModelValue=request.getParameter(PARAM_MODEL)!=null?request.getParameter(PARAM_MODEL):StringUtils.EMPTY;
		String	code=request.getParameter(PARAM_CODE)!=null?request.getParameter(PARAM_CODE):StringUtils.EMPTY;
		String	trim=request.getParameter(PARAM_TRIM)!=null?request.getParameter(PARAM_TRIM):StringUtils.EMPTY;
		String	fsport=request.getParameter(PARAM_TRIM)!=null?request.getParameter(PARAM_FSPORT):StringUtils.EMPTY;
		return  "year:"+year+SEPERATOR+"model:"+model+SEPERATOR+"incomingModelParam:"+incomingModelParam+SEPERATOR+"bannerModelValue:"+bannerModelValue+SEPERATOR+"code:"+code+SEPERATOR+"trim:"+trim+SEPERATOR+"fsport:"+fsport;
	}
	
	public String setParameterDataForMultipleVehicles(String[] vehicleDataTagsArray) {
		String year=StringUtils.EMPTY;
		String model=StringUtils.EMPTY;
		String bannerModelValue=StringUtils.EMPTY;
		String incomingModelParam=StringUtils.EMPTY;
		String code=StringUtils.EMPTY;
		String trim=StringUtils.EMPTY;
		for(int i=0;i< vehicleDataTagsArray.length;i++) {
			if (vehicleDataTagsArray[i].split(":")[0].equals(PARAM_YEAR)) {
				 year=vehicleDataTagsArray[i].split(":")[1];
				
			}
			if (vehicleDataTagsArray[i].split(":")[0].equals(PARAM_MODEL)) {
				model=vehicleDataTagsArray[i].split(":")[1];
				bannerModelValue=vehicleDataTagsArray[i].split(":")[1];
				incomingModelParam=vehicleDataTagsArray[i].split(":")[1];
				
			}
			if (vehicleDataTagsArray[i].split(":")[0].equals(PARAM_CODE)) {
				code=vehicleDataTagsArray[i].split(":")[1];
				
			}
			if (vehicleDataTagsArray[i].split(":")[0].equals(PARAM_TRIM)) {
				trim=vehicleDataTagsArray[i].split(":")[1];
				
			}
		}
		return  "year:"+year+SEPERATOR+"model:"+model+SEPERATOR+"incomingModelParam:"+incomingModelParam+SEPERATOR+"bannerModelValue:"+bannerModelValue+SEPERATOR+"code:"+code+SEPERATOR+"trim:"+trim;
		 	
	}
	
	public void setFSportTag(StringBuilder sbTags,StringBuilder sbTagsFs, String model, String code) {
		if (model.contains(FSPORT)) {
			sbTagsFs = sbTagsFs.append(sbTags).append(PATH_SLASH);
			this.fsportsTag = sbTagsFs.append(model.toLowerCase()).append(PATH_SLASH).append(code).toString();
			
		} else if(model.contains(FSPORT_2)) {
			sbTagsFs = sbTagsFs.append(sbTags).append(PATH_SLASH);
			this.fsportsTag = sbTagsFs.append(model.toLowerCase()).append(PATH_SLASH).append(code).toString();
			
		}
		else if(model.contains(FSPORT_3)) {
			sbTagsFs = sbTagsFs.append(sbTags).append(PATH_SLASH);
			this.fsportsTag = sbTagsFs.append(model.toLowerCase()).append(PATH_SLASH).append(code).toString();
		}
	}
	
	public void setCodetosbTags(StringBuilder sbTags,String code) {
		if(code!=null&&!code.isEmpty()) {
			sbTags.append(PATH_SLASH).append(code);
		}		
	}
	
	public void setCFData(String model,String year,String incomingModelParam,String bannerModelValue, String code,StringBuilder sbCF,StringBuilder sbCFBanner) {
		sbCFBanner.append(year!=null&&!year.isEmpty()? (year+PATH_SLASH):"");
		
			if(model.length()==2) {
				sbCF.append(model.toUpperCase());	
				bannerModelValue=model.toUpperCase();
			}else {
				if(Character.toString(incomingModelParam.charAt(2)).equalsIgnoreCase("h")) {
					model=model.toUpperCase();
					model=model.replace('H', 'h');
					if(Character.toString(model.charAt(0)).equalsIgnoreCase("h"))
						model=model.replaceFirst("h","H");
					sbCF.append(model);	
					bannerModelValue=model;
				}else if(Character.toString(incomingModelParam.charAt(2)).equalsIgnoreCase("t")){

					model=model.toUpperCase();
					model=model.replace('T', 't');
					if(Character.toString(model.charAt(1)).equalsIgnoreCase("t"))
						model=model.replaceFirst("t","T");
					sbCF.append(model);	
					bannerModelValue=model;
				
				}
				else{
				model=model.toUpperCase();	
				sbCF.append(model);	
				bannerModelValue=model;
				}
			}		
		setCFBanner(bannerModelValue,sbCFBanner,year,code);
	}
	
	public void setCFBanner(String bannerModelValue, StringBuilder sbCFBanner, String year, String code) {
		sbCFBanner.append(bannerModelValue);
		if(!code.isEmpty()) {
			sbCFBanner.append(PATH_SLASH).append(code.toUpperCase()).append(PATH_SLASH).append(VISUALIZER_PATH);
		}else if(year!=null && !year.isEmpty()) {
			sbCFBanner.append(PATH_SLASH).append(PATH_DEFAULT).append(PATH_SLASH).append(VISUALIZER_PATH);
		}else {
			String cfBannerNoYearAndNoCode=sbCFBanner.toString();
			cfBannerNoYearAndNoCode=cfBannerNoYearAndNoCode.replace(bannerModelValue, PATH_DEFAULT+PATH_SLASH+bannerModelValue);
			sbCFBanner=new StringBuilder();
			sbCFBanner.append(cfBannerNoYearAndNoCode).append(PATH_SLASH).append(VISUALIZER_PATH);
		}
	}
	
	public void setTagFolders(SlingHttpServletRequest request,String year,String bannerModelValue) {	
		if(bannerModelValue.length()>2) {
			bannerModelValue = checkHTmodel(bannerModelValue);
		}
		if(!year.isEmpty()) {
			if(request.getResourceResolver().getResource(ROOT_VISUALIZER_PATH+PATH_SLASH+bannerModelValue+PATH_SLASH+year)!=null) {
				this.tagFolderExists=true;
			}
			if(request.getResourceResolver().getResource(ROOT_VHR_PATH+PATH_SLASH+bannerModelValue+PATH_SLASH+year)!=null) {
				this.tagFolderExistsVHR=true;
			}
		}else {
			if(request.getResourceResolver().getResource(ROOT_VISUALIZER_PATH+PATH_SLASH+bannerModelValue)!=null) {
				this.tagFolderExists=true;
			}
			if(request.getResourceResolver().getResource(ROOT_VHR_PATH+PATH_SLASH+bannerModelValue)!=null) {
				this.tagFolderExistsVHR=true;
			}
		}
	}
	public String checkHTmodel(String bannerModelValue) {
		if(Character.toString(bannerModelValue.charAt(2)).equalsIgnoreCase("h")){
			bannerModelValue=bannerModelValue.replace('H', 'h');
			if(Character.toString(bannerModelValue.charAt(0)).equalsIgnoreCase("h"))
				bannerModelValue=bannerModelValue.replaceFirst("h","H");
		}
		if(Character.toString(bannerModelValue.charAt(2)).equalsIgnoreCase("t")){
			bannerModelValue=bannerModelValue.replace('T', 't');
			if(Character.toString(bannerModelValue.charAt(1)).equalsIgnoreCase("t"))
				bannerModelValue=bannerModelValue.replaceFirst("t","T");
		}
		return bannerModelValue;
	}
	
	
	public String setCFandBannerModel(String model,StringBuilder sbCF,String incomingModelParam) {
		String bannerModelValueString;
		if(model.length()==2) {
			sbCF.append(model.toUpperCase());	
			bannerModelValueString=model.toUpperCase();
		}else {
			if(Character.toString(incomingModelParam.charAt(2)).equalsIgnoreCase("h")) {
				model=model.replace('H', 'h');
				if(Character.toString(model.charAt(0)).equalsIgnoreCase("h"))
					model=model.replaceFirst("h","H");
				sbCF.append(model);	
				bannerModelValueString=model;
			}else if(Character.toString(incomingModelParam.charAt(2)).equalsIgnoreCase("t")){
				model=model.replace('T', 't');
				if(Character.toString(model.charAt(1)).equalsIgnoreCase("t"))
					model=model.replaceFirst("t","T");
				sbCF.append(model);	
				bannerModelValueString=model;
			}
			else{
			sbCF.append(model);	
			bannerModelValueString=model;
			}
		}
		return bannerModelValueString;
	}
	
	public boolean isTagFolderExists() {
		return tagFolderExists;
	}


	public void setTagFolderExists(boolean tagFolderExists) {
		this.tagFolderExists = tagFolderExists;
	}

	public String getCfBannerPath() {
		return cfBannerPath;
	}


	/**
	 * @return the cfPath
	 */
	public String getCfPath() {
		return cfPath;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @return the modelTag
	 */
	public String getModelTag() {
		return modelTag;
	}

	/**
	 * @return the fsportsTag
	 */
	public String getFsportsTag() {
		return fsportsTag;
	}

	/**
	 * @return the defaultTag
	 */
	public String getDefaultTag() {
		return defaultTag;
	}
	
	public String getTrim() {
		return trim;
	}


	public void setTrim(String trim) {
		this.trim = trim;
	}

	public boolean isTagFolderExistsVHR() {
		return tagFolderExistsVHR;
	}


	public void setTagFolderExistsVHR(boolean tagFolderExistsVHR) {
		this.tagFolderExistsVHR = tagFolderExistsVHR;
	}

	public void setCfBannerPath(String cfBannerPath) {
		this.cfBannerPath = cfBannerPath;
	}

	public void setCfPath(String cfPath) {
		this.cfPath = cfPath;
	}
	
	@Override
	public String toString() {
		return "\n VehicleDataTags [\n cfPath= " + cfPath + ", \n tag= " + tag + ", \n modelTag= " + modelTag + ", \n fsportsTag= "
				+ fsportsTag + ", \n defaultTag= " + defaultTag + ",\n cfBannerPath= "+cfBannerPath+"]\n\n";
	}
}
