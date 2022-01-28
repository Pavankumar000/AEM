package com.toyota.tmna.lexusdrivers.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.Template;
import com.toyota.tmna.lexusdrivers.core.models.GlobalNavigationModel;
import com.toyota.tmna.lexusdrivers.core.util.GlobalNavConstants;
import com.toyota.tmna.lexusdrivers.core.util.AEMServletUtil;


@Component( service = Servlet.class,
property = {
"sling.servlet.resourceTypes =" + ConstantsUtil.SERVLET_RESOURCE_TYPE,
"sling.servlet.selectors=" + "globalnav",
"sling.servlet.extensions=" + ConstantsUtil.SERVLET_EXTENSIONS})
public class GlobalNavigationServlet extends SlingSafeMethodsServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -419582993485076957L;
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalNavigationServlet.class);

	private static final String GLOBAL_NAV = "/structure/jcr:content/root/globalnav";
	private static final String CAROUSEL = "Carousel";
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.info("getHostHeaderInformation host value:: "+request.getHeader("Host"));
		//invoking method to log header values
		AEMServletUtil.getHeaderInformation(request);
		
		PrintWriter out = response.getWriter();
		JSONObject output = new JSONObject();
		Resource resource = request.getResource();
		ResourceResolver resolver = request.getResourceResolver();

		PageManager pm = resolver.adaptTo(PageManager.class);
		if (pm == null) {
			return;
		}
		Page currentPage = pm.getContainingPage(resource);
		Template template = currentPage!=null?currentPage.getTemplate():null;

		Resource globalNavResource = resolver.getResource(template!=null ? (template.getPath()+GLOBAL_NAV):"" );
		if (globalNavResource == null) {
			return;
		}
		Resource appconfigResource = resolver.getResource(GlobalNavConstants.CONTENT_FRAGMENT_APP_CONFIG);
		ValueMap appConfigProperties = ResourceUtil.getValueMap(appconfigResource);
		try {
			JSONObject data =  new JSONObject();
			
			LOGGER.error(" Global Navigation  Set Data Json ; Cookie Value " +AEMServletUtil.getCookieToken(request,ConstantsUtil.ID_TOKEN) );
			
			setDataJson(data, globalNavResource,appConfigProperties);
			output.put(GlobalNavConstants.KEY_DATA, data);
		} catch (JSONException e) {
			LOGGER.error(" JSON exception occured : {0}", e);
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(output.toString());
		out.flush();
		out.close();
	}

	private void setDataJson(JSONObject data, Resource globalNavResource, ValueMap appConfigProperties) throws JSONException {
		
		GlobalNavigationModel model = globalNavResource.adaptTo(GlobalNavigationModel.class);
		LOGGER.error(" Global Navigation  Set Data Json " +model );
		if (model == null) {
			return;
		}
		
		JSONObject navigationLinks =  new JSONObject();
		setNavigationLinks(navigationLinks, globalNavResource);
		data.put(GlobalNavConstants.KEY_NAVIGATION_LINK, navigationLinks);

		JSONObject selectVehicle =  new JSONObject();
		setSelectVehicle(selectVehicle, globalNavResource);
		data.put(GlobalNavConstants.KEY_SELECTED_VEHICLE, selectVehicle);

		JSONObject loggedIn =  new JSONObject();
		setLoggedIn(loggedIn, globalNavResource);
		data.put(GlobalNavConstants.KEY_LOGGED_IN, loggedIn);
		
		JSONObject headerLogo =  new JSONObject();
		setHeaderLogo(headerLogo, model);
		data.put(GlobalNavConstants.KEY_HEADER_LOGO, headerLogo);
		
		JSONObject loggedOut =  new JSONObject();
		setLoggedOut(loggedOut, globalNavResource);
		data.put(GlobalNavConstants.KEY_LOGGED_OUT, loggedOut);		
		data.put(GlobalNavConstants.KEY_WELCOME_EXPERIENCE, StringUtils.EMPTY);		
		data.put(GlobalNavConstants.KEY_NAV_SEARCH, appConfigProperties.getOrDefault(GlobalNavConstants.PROP_NAV_SEARCH, StringUtils.EMPTY));
		data.put(GlobalNavConstants.KEY_FUEL_GRADES, appConfigProperties.getOrDefault(GlobalNavConstants.PROP_FUEL_GRADES, StringUtils.EMPTY));
		data.put(GlobalNavConstants.KEY_MY_FILTER, appConfigProperties.getOrDefault(GlobalNavConstants.PROP_MY_FILTER, StringUtils.EMPTY));
		data.put(GlobalNavConstants.KEY_FSPORT_FILTER, appConfigProperties.getOrDefault(GlobalNavConstants.PROP_FSPORT_FILTER, StringUtils.EMPTY));
		data.put(GlobalNavConstants.KEY_LEGACY_MODEL_EXPERIENCE, appConfigProperties.getOrDefault(GlobalNavConstants.PROP_LEGACY_MODEL_EXPERIENCE, StringUtils.EMPTY));		
		
	}
	
	private void setSelectVehicle(JSONObject selectVehicle, Resource globalNavResource) throws JSONException {
		JSONArray children = new JSONArray();
		ValueMap properties = ResourceUtil.getValueMap(globalNavResource);
		
		JSONObject child = new JSONObject();
		child.put(GlobalNavConstants.KEY_NAME, properties.getOrDefault(GlobalNavConstants.PROP_SECTION_LABEL, StringUtils.EMPTY));
		
		JSONObject navLabel = getObj();
		navLabel.getJSONObject(GlobalNavConstants.KEY_OBJ).put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(GlobalNavConstants.PROP_SECTION_LABEL, StringUtils.EMPTY));
		navLabel.put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(GlobalNavConstants.PROP_SECTION_LABEL, StringUtils.EMPTY));
		child.put(GlobalNavConstants.KEY_NAV_LABEL, navLabel);
		
		JSONArray childrenLOne = new JSONArray();
		
		childrenLOne.put(getHealthReport(properties));
		childrenLOne.put(getAddVehicle(properties));
		childrenLOne.put(getCarousel(globalNavResource));
		childrenLOne.put(getQuicklinks(globalNavResource));
		childrenLOne.put(getManageGarage(globalNavResource));
		getNavigationError(childrenLOne, globalNavResource);
		
		child.put(GlobalNavConstants.KEY_CHILDREN, childrenLOne);	
		children.put(child);
		selectVehicle.put(GlobalNavConstants.KEY_CHILDREN, children);
	}

	private void getNavigationError(JSONArray childrenLOne, Resource globalNavResource) throws JSONException {
		
		Resource resource = globalNavResource.getChild(GlobalNavConstants.NODE_NAVIGATION_MESSAGE);
		if (null == resource) {
			return;
		}
		Iterator<Resource> childrenRes = resource.listChildren();
		while (childrenRes.hasNext()) {
			JSONObject child = new JSONObject();
			Resource childRes = childrenRes.next();
			ValueMap properties = ResourceUtil.getValueMap(childRes);

			child.put(GlobalNavConstants.KEY_NAME, properties.getOrDefault(GlobalNavConstants.PROP_ERROR_MSG_NAME, StringUtils.EMPTY));
			child.put(GlobalNavConstants.KEY_TITLE, getObj(properties, GlobalNavConstants.PROP_ERROR_MSG_TITLE));
			child.put(GlobalNavConstants.KEY_BODY, getObj(properties, GlobalNavConstants.PROP_ERROR_MSG_BODY));
			child.put(GlobalNavConstants.KEY_BUTTON_LABEL,getObj(properties,GlobalNavConstants.PROP_BUTTON_LABEL));
			child.put(GlobalNavConstants.KEY_SUCCESS_URL,getSuccessObj(properties,GlobalNavConstants.PROP_SUCCESS_URL));
			
			childrenLOne.put(child);
		}		
	}

	private JSONObject getManageGarage(Resource globalNavResource) throws JSONException {
		ValueMap properties = ResourceUtil.getValueMap(globalNavResource);
		JSONObject manageGarage = new JSONObject();
		
		manageGarage.put(GlobalNavConstants.KEY_NAME, properties.getOrDefault(GlobalNavConstants.PROP_GARAGE_NAME, StringUtils.EMPTY));
		manageGarage.put(GlobalNavConstants.KEY_TITLE, getObj(properties, GlobalNavConstants.PROP_GARAGE_VALUE));
		manageGarage.put(GlobalNavConstants.KEY_GARAGE_TEXT, getObj(properties, GlobalNavConstants.PROP_GARAGE_TEXT));
		manageGarage.put(GlobalNavConstants.KEY_GARAGE_LINK,getManageGarageLinkObj(properties));
		
		setGarageLinks(manageGarage, globalNavResource);
		
		return manageGarage;
	}

	private void setGarageLinks(JSONObject manageGarage, Resource globalNavResource) throws JSONException {
		//JSONArray children = new JSONArray();
		
		Resource resource = globalNavResource.getChild(GlobalNavConstants.NODE_MANAGE_GARAGE);
		if (null == resource) {
			return;
		}
		Iterator<Resource> childrenRes = resource.listChildren();
		while (childrenRes.hasNext()) {
		//	JSONObject child = new JSONObject();
			Resource childRes = childrenRes.next();
			ValueMap properties = ResourceUtil.getValueMap(childRes);
			//manageGarage.put(GlobalNavConstants.KEY_TITLE, getObj(properties, GlobalNavConstants.PROP_GARAGE_TITLE));
			manageGarage.put(GlobalNavConstants.KEY_DESCRIPTION, getObj(properties, GlobalNavConstants.PROP_GARAGE_DESCRIPTION));
			manageGarage.put(GlobalNavConstants.KEY_CAR_IMAGE, getObj());
			manageGarage.put(GlobalNavConstants.KEY_CAR_MODEL, getObj());
			manageGarage.put(GlobalNavConstants.KEY_FIND_DEALER_LABEL, getObj(properties, GlobalNavConstants.PROP_DEALER_LABEL));
			manageGarage.put(GlobalNavConstants.KEY_FIND_DEALER_LINK, getObj(properties, GlobalNavConstants.PROP_DEALER_LINK));
			
			//children.put(child);
		}
		//manageGarage.put(GlobalNavConstants.KEY_CHILDREN, children);
		
	}

	private void setNavigationLinks(JSONObject navigationLinks, Resource globalNavResource) throws JSONException {
		JSONArray children = new JSONArray();
		
		Resource resource = globalNavResource.getChild(GlobalNavConstants.NODE_NAVIGATION_LINKS);
		if (null == resource) {
			return;
		}
		Iterator<Resource> childrenRes = resource.listChildren();
		while (childrenRes.hasNext()) {
			JSONObject child = new JSONObject();
			Resource childRes = childrenRes.next();
			ValueMap properties = ResourceUtil.getValueMap(childRes);
			
			child.put(GlobalNavConstants.KEY_NAME, properties.getOrDefault(GlobalNavConstants.PROP_NAME, StringUtils.EMPTY));
			
			JSONObject navLabel = getObj();
			navLabel.getJSONObject(GlobalNavConstants.KEY_OBJ).put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(GlobalNavConstants.PROP_LABEL, StringUtils.EMPTY));
			navLabel.put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(GlobalNavConstants.PROP_LABEL, StringUtils.EMPTY));
			child.put(GlobalNavConstants.KEY_NAV_LABEL, navLabel);				
			setNavLevelOne(child, childRes);	
			children.put(child);			
		}
		navigationLinks.put(GlobalNavConstants.KEY_CHILDREN, children);
	}

	private void setNavLevelOne(JSONObject navigation, Resource navRes) throws JSONException {
		JSONArray children = new JSONArray();
		
		Resource resource = navRes.getChild(GlobalNavConstants.NODE_CHILDREN);
		Resource carouselResource = navRes.getChild(GlobalNavConstants.NODE_CAROUSEL_TILES);
		if (null == resource) {
			return;
		}
		Iterator<Resource> childrenRes = resource.listChildren();
		while (childrenRes.hasNext()) {
			JSONObject child = new JSONObject();
			Resource childRes = childrenRes.next();
			ValueMap properties = ResourceUtil.getValueMap(childRes);
			
			child.put(GlobalNavConstants.KEY_NAME, properties.getOrDefault(GlobalNavConstants.PROP_NAME, StringUtils.EMPTY));
			
			JSONObject navLabel = getObj();
			navLabel.getJSONObject(GlobalNavConstants.KEY_OBJ).put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(GlobalNavConstants.PROP_NAV_LABEL_LEVEL_ONE, StringUtils.EMPTY));
			navLabel.put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(GlobalNavConstants.PROP_NAV_LABEL_LEVEL_ONE, StringUtils.EMPTY));
			child.put(GlobalNavConstants.KEY_NAV_LABEL, navLabel);
			
			JSONObject value = new JSONObject();
			String link = getLinkNavOne(value, properties);
			JSONObject navLink = getObj();			
			navLink.put(GlobalNavConstants.KEY_VALUE, link);
			navLink.getJSONObject(GlobalNavConstants.KEY_OBJ).put(GlobalNavConstants.KEY_VALUE, value);
			child.put(GlobalNavConstants.KEY_NAVLINK, navLink);
			
			setNavLevelTwo(child, childRes);
			
			children.put(child);			
		}
		if(carouselResource != null) {
		  Iterator<Resource> carouselChildrenRes = carouselResource.listChildren();
		  JSONObject carousel = new JSONObject();
		  JSONArray carouselChildren = new JSONArray();
		  carousel.put(GlobalNavConstants.KEY_NAME, CAROUSEL);

			  while (carouselChildrenRes.hasNext()) {
				  JSONObject child = new JSONObject();
				  Resource childRes = carouselChildrenRes.next();
				  ValueMap properties = ResourceUtil.getValueMap(childRes);
				  child.put(GlobalNavConstants.KEY_TITLE, getObj(properties, GlobalNavConstants.PROP_SELECT_CAROUSEL_TITLE));
				  child.put(GlobalNavConstants.KEY_LABEL, getObj(properties, GlobalNavConstants.PROP_SELECT_CAROUSEL_TITLE));
				  child.put(GlobalNavConstants.KEY_CAROUSEL_THUMBNAIL, getThumbnailObj(properties, GlobalNavConstants.PROP_CAROUSEL_THUMBNAIL));
				  child.put(GlobalNavConstants.KEY_VIDEO_SLIDE, getVideoSlideObj(properties, GlobalNavConstants.PROP_VIDEO_SLIDE));
				  child.put(GlobalNavConstants.KEY_LINKOUT_URL, getLinkoutObj(properties, GlobalNavConstants.PROP_LINKOUT_URL));
				  carouselChildren.put(child);
				  carousel.put(GlobalNavConstants.KEY_CHILDREN, carouselChildren);
			  }
			children.put(carousel);
		  }

		navigation.put(GlobalNavConstants.KEY_CHILDREN, children);

	}

	private void setNavLevelTwo(JSONObject navigation, Resource navRes) throws JSONException {
		JSONArray children = new JSONArray();		
		Resource resource = navRes.getChild(GlobalNavConstants.NODE_CHILDREN);		
		if (resource == null) {
			return;
		}		
		Iterator<Resource> childrenRes = resource.listChildren();
		while (childrenRes.hasNext()) {
			JSONObject child = new JSONObject();
			Resource childRes = childrenRes.next();
			ValueMap properties = ResourceUtil.getValueMap(childRes);
			
			JSONObject navLabel = getObj();
			navLabel.getJSONObject(GlobalNavConstants.KEY_OBJ).put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(GlobalNavConstants.PROP_NAV_LABEL_LEVEL_TWO, StringUtils.EMPTY));
			navLabel.put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(GlobalNavConstants.PROP_NAV_LABEL_LEVEL_TWO, StringUtils.EMPTY));
			child.put(GlobalNavConstants.KEY_NAV_LABEL, navLabel);
			
			JSONObject value = new JSONObject();
			String link = getLinkNavTwo(value, properties);
			JSONObject navLink = getObj();			
			navLink.put(GlobalNavConstants.KEY_VALUE, link);
			navLink.getJSONObject(GlobalNavConstants.KEY_OBJ).put(GlobalNavConstants.KEY_VALUE, value);
			child.put(GlobalNavConstants.KEY_NAVLINK, navLink);
			
			JSONObject navIcon = getObj();
			navIcon.getJSONObject(GlobalNavConstants.KEY_OBJ).put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(GlobalNavConstants.PROP_NAV_ICON, StringUtils.EMPTY));
			navIcon.put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(GlobalNavConstants.PROP_NAV_ICON, StringUtils.EMPTY));
			child.put(GlobalNavConstants.KEY_NAV_ICON, navIcon);
			
			children.put(child);			
		}
		navigation.put(GlobalNavConstants.KEY_CHILDREN, children);
	}

	private String getLinkNavOne(JSONObject value, ValueMap properties) throws JSONException {
		StringBuilder sb = new StringBuilder();
		sb.append(GlobalNavConstants.HTML_ELE_LINK);
		value.put(GlobalNavConstants.KEY_HREF, properties.getOrDefault(GlobalNavConstants.PROP_URL, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_HREF).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_URL, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		value.put(GlobalNavConstants.KEY_URL, properties.getOrDefault(GlobalNavConstants.PROP_URL, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_URL).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_URL, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		value.put(GlobalNavConstants.KEY_ANCHOR, properties.getOrDefault(GlobalNavConstants.PROP_ANCHOR, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_ANCHOR).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_ANCHOR, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		value.put(GlobalNavConstants.KEY_TARGET, properties.getOrDefault(GlobalNavConstants.PROP_TARGET, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_ANCHOR).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_TARGET, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		value.put(GlobalNavConstants.KEY_LINKTYPE, properties.getOrDefault(GlobalNavConstants.PROP_LINK_TYPE_LEVEL_ONE, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_LINKTYPE).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_LINK_TYPE_LEVEL_ONE, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		sb.append(GlobalNavConstants.HTML_ELE_END);
		return sb.toString();
	}

	private String getLinkNavTwo(JSONObject value, ValueMap properties) throws JSONException {
		StringBuilder sb = new StringBuilder();
		sb.append(GlobalNavConstants.HTML_ELE_LINK);
		value.put(GlobalNavConstants.KEY_HREF, properties.getOrDefault(GlobalNavConstants.PROP_URL, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_HREF).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_URL, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		value.put(GlobalNavConstants.KEY_URL, properties.getOrDefault(GlobalNavConstants.PROP_URL, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_HREF).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_URL, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		value.put(GlobalNavConstants.KEY_ANCHOR, properties.getOrDefault(GlobalNavConstants.PROP_ANCHOR, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_ANCHOR).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_ANCHOR, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		value.put(GlobalNavConstants.KEY_TARGET, properties.getOrDefault(GlobalNavConstants.PROP_TARGET, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_TARGET).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_TARGET, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		value.put(GlobalNavConstants.KEY_LINKTYPE, properties.getOrDefault(GlobalNavConstants.PROP_LINK_TYPE_LEVEL_TWO, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_LINKTYPE).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_LINK_TYPE_LEVEL_TWO, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		
		value.put(GlobalNavConstants.KEY_STYLECLASS, properties.getOrDefault(GlobalNavConstants.PROP_STYLECLASS, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_STYLECLASS).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_STYLECLASS, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		
		
		sb.append(GlobalNavConstants.HTML_ELE_END);
		return sb.toString();
	}

	private JSONObject getQuicklinks(Resource globalNavResource) throws JSONException {
		ValueMap properties = ResourceUtil.getValueMap(globalNavResource);
		JSONObject quickLink = new JSONObject();
		
		quickLink.put(GlobalNavConstants.KEY_NAV_LABEL, getObj(properties, GlobalNavConstants.PROP_QUICKNAV_LABEL));
		quickLink.put(GlobalNavConstants.KEY_LABEL, getObj(properties, GlobalNavConstants.PROP_QUICK_LABEL));
		quickLink.put(GlobalNavConstants.KEY_NAVLINK,getQuickLink(properties));
		
		setQuickLinks(quickLink, globalNavResource);
		
		return quickLink;
	}
	
	private void setQuickLinks(JSONObject quickLink, Resource globalNavResource) throws JSONException {
		JSONArray children = new JSONArray();		
		Resource resource = globalNavResource.getChild(GlobalNavConstants.NODE_QUICK_LINKS);		
		if (resource == null) {
			return;
		}		
		Iterator<Resource> childrenRes = resource.listChildren();
		while (childrenRes.hasNext()) {
			JSONObject child = new JSONObject();
			Resource childRes = childrenRes.next();
			ValueMap properties = ResourceUtil.getValueMap(childRes);
			child.put(GlobalNavConstants.KEY_NAV_LABEL, getObj(properties, GlobalNavConstants.PROP_NAV_LABEL_LEVEL_TWO));
			child.put(GlobalNavConstants.KEY_NAVLINK,getQuickNavLink(properties));
			children.put(child);
		}
		quickLink.put(GlobalNavConstants.KEY_CHILDREN, children);
	}

	private JSONObject getQuickNavLink(ValueMap properties) throws JSONException {
		JSONObject value = new JSONObject();
		StringBuilder sb = new StringBuilder();
		sb.append(GlobalNavConstants.HTML_ELE_LINK);
		value.put(GlobalNavConstants.KEY_HREF, properties.getOrDefault(GlobalNavConstants.PROP_NAV_LINK, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_HREF).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_NAV_LINK, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		value.put(GlobalNavConstants.KEY_URL, properties.getOrDefault(GlobalNavConstants.PROP_NAV_LINK, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_URL).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_NAV_LINK, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		value.put(GlobalNavConstants.KEY_LINKTYPE, properties.getOrDefault(GlobalNavConstants.PROP_LINK_TYPE_LEVEL_TWO, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_LINKTYPE).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_LINK_TYPE_LEVEL_TWO, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		sb.append(GlobalNavConstants.HTML_ELE_END);
		return getObj(sb.toString(), value);
	}

	private JSONObject getQuickLink(ValueMap properties) throws JSONException {
		JSONObject value = new JSONObject();
		StringBuilder sb = new StringBuilder();
		sb.append(GlobalNavConstants.HTML_ELE_LINK);
		value.put(GlobalNavConstants.KEY_HREF, properties.getOrDefault(GlobalNavConstants.PROP_QUICK_LINK_URL, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_HREF).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_QUICK_LINK_URL, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		value.put(GlobalNavConstants.KEY_URL, properties.getOrDefault(GlobalNavConstants.PROP_QUICK_LINK_URL, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_URL).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_QUICK_LINK_URL, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		value.put(GlobalNavConstants.KEY_LINKTYPE, properties.getOrDefault(GlobalNavConstants.PROP_QUICK_LINK_TYPE, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_LINKTYPE).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_QUICK_LINK_TYPE, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		sb.append(GlobalNavConstants.HTML_ELE_END);
		return getObj(sb.toString(), value);
	}

	private JSONObject getCarousel(Resource globalNavResource) throws JSONException {
		JSONArray childrenLOne= new JSONArray();
		JSONObject carousel = new JSONObject();		
		carousel.put(GlobalNavConstants.KEY_NAME, CAROUSEL);
		Resource resource = globalNavResource.getChild(GlobalNavConstants.NODE_CAROUSEL_TILES);
		Iterator<Resource> childrenRes = resource!=null?resource.listChildren():null;
		while (childrenRes!=null && childrenRes.hasNext()) {
			JSONObject child = new JSONObject();
			Resource childRes = childrenRes.next();
			ValueMap properties = ResourceUtil.getValueMap(childRes);

			child.put(GlobalNavConstants.KEY_TITLE, getObj(properties, GlobalNavConstants.PROP_SELECT_CAROUSEL_TITLE));
			child.put(GlobalNavConstants.KEY_LABEL, getObj(properties, GlobalNavConstants.PROP_SELECT_CAROUSEL_TITLE));
			child.put(GlobalNavConstants.KEY_CAROUSEL_THUMBNAIL, getThumbnailObj(properties, GlobalNavConstants.PROP_CAROUSEL_THUMBNAIL));
			child.put(GlobalNavConstants.KEY_VIDEO_SLIDE, getVideoSlideObj(properties, GlobalNavConstants.PROP_VIDEO_SLIDE));
			child.put(GlobalNavConstants.KEY_LINKOUT_URL, getLinkoutObj(properties, GlobalNavConstants.PROP_LINKOUT_URL));
			childrenLOne.put(child);
			
		}				
		carousel.put(GlobalNavConstants.KEY_CHILDREN, childrenLOne);
		
		return carousel;
	}	

	private JSONObject getAddVehicle(ValueMap properties) throws JSONException {
		JSONObject addVehicle = new JSONObject();
		
		addVehicle.put(GlobalNavConstants.KEY_TITLE, getObj(properties, GlobalNavConstants.PROP_SECTION_DESCRIPTION));
		addVehicle.put(GlobalNavConstants.KEY_VEHICLE_DEFAULT_TEXT, getObj(properties, GlobalNavConstants.PROP_VEHICLE_SELECT_TEXT));		
		addVehicle.put(GlobalNavConstants.KEY_VIN_LABEL, getObj(properties, GlobalNavConstants.PROP_VIN_LABEL));
		addVehicle.put(GlobalNavConstants.KEY_YEAR_DEFAULT_TEXT, getObj(properties, GlobalNavConstants.PROP_VEHICLE_YEAR_SELECTOR));
		addVehicle.put(GlobalNavConstants.KEY_BUTTON_LABEL, getObj(properties, GlobalNavConstants.PROP_BUTTON_LABEL));
		addVehicle.put(GlobalNavConstants.KEY_BOTTOM_TEXT, getObj(properties, GlobalNavConstants.PROP_BOTTOM_TEXT));
		
		return addVehicle;
	}

	private JSONObject getHealthReport(ValueMap properties) throws JSONException {
		JSONObject healthReport = new JSONObject();
		healthReport.put(GlobalNavConstants.KEY_TITLE, getObj(properties, GlobalNavConstants.PROP_BENIFITS_TITLE));
		healthReport.put(GlobalNavConstants.KEY_BODY, getObj(properties, GlobalNavConstants.PROP_BODY));
		return healthReport;
	}

	private JSONObject getObj(ValueMap properties, String propertyName) throws JSONException {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put(GlobalNavConstants.KEY_OBJ, new JSONObject().put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(propertyName, StringUtils.EMPTY)));
		jsonObj.put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(propertyName, StringUtils.EMPTY));
		
		return jsonObj;
	}
	private JSONObject getThumbnailObj(ValueMap properties, String propertyName) throws JSONException {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put(GlobalNavConstants.KEY_OBJ, new JSONObject().put(GlobalNavConstants.KEY_VALUE, new JSONObject().put(GlobalNavConstants.KEY_SRC,properties.getOrDefault(propertyName, StringUtils.EMPTY))));
		jsonObj.put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(propertyName, StringUtils.EMPTY));
		
		return jsonObj;
	}
	
	private JSONObject getSuccessObj(ValueMap properties, String propertyName) throws JSONException {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put(GlobalNavConstants.KEY_OBJ, new JSONObject().put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(propertyName, StringUtils.EMPTY)));
		jsonObj.put(GlobalNavConstants.KEY_VALUE,new JSONObject().put(GlobalNavConstants.KEY_VALUE,properties.getOrDefault(propertyName, StringUtils.EMPTY)));		
		return jsonObj;
	}
	
	
	private JSONObject getVideoSlideObj(ValueMap properties, String propertyName) throws JSONException {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put(GlobalNavConstants.KEY_OBJ, new JSONObject().put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(propertyName, StringUtils.EMPTY).toString().equalsIgnoreCase("true")?true:false));
		jsonObj.put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(propertyName, StringUtils.EMPTY).toString().equalsIgnoreCase("true")?true:false);
		
		return jsonObj;
	}
	private JSONObject getLinkoutObj(ValueMap properties, String propertyName) throws JSONException {
		JSONObject jsonObj = new JSONObject();
		JSONObject jsonObjInner = new JSONObject();
		JSONObject jsonObjInnerValue = new JSONObject();
		jsonObjInner.put(GlobalNavConstants.KEY_HREF, properties.getOrDefault(propertyName, StringUtils.EMPTY));
		jsonObjInner.put(GlobalNavConstants.KEY_URL, properties.getOrDefault(propertyName, StringUtils.EMPTY));
		jsonObjInnerValue.put(GlobalNavConstants.KEY_VALUE, jsonObjInner);
		jsonObj.put(GlobalNavConstants.KEY_OBJ, jsonObjInnerValue);
		jsonObj.put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(propertyName, StringUtils.EMPTY));		
		return jsonObj;
		
	}
	
	private JSONObject getManageGarageLinkObj(ValueMap properties) throws JSONException {
		JSONObject jsonObj = new JSONObject();
		JSONObject jsonObjLink = new JSONObject();
		JSONObject jsonObjLinkValue = new JSONObject();
		jsonObjLinkValue.put(GlobalNavConstants.KEY_HREF, properties.getOrDefault(GlobalNavConstants.PROP_GARAGE_LINK, StringUtils.EMPTY));
		jsonObjLinkValue.put(GlobalNavConstants.KEY_TEXT, properties.getOrDefault(GlobalNavConstants.PROP_GARAGE_TEXT, StringUtils.EMPTY));
		jsonObjLinkValue.put(GlobalNavConstants.KEY_LINKTYPE, properties.getOrDefault(GlobalNavConstants.PROP_GARAGE_LINK_TYPE, StringUtils.EMPTY));
		jsonObjLinkValue.put(GlobalNavConstants.KEY_URL, properties.getOrDefault(GlobalNavConstants.PROP_GARAGE_LINK, StringUtils.EMPTY));
		jsonObjLinkValue.put(GlobalNavConstants.KEY_ANCHOR, properties.getOrDefault(GlobalNavConstants.PROP_ANCHOR, StringUtils.EMPTY));
		jsonObjLinkValue.put(GlobalNavConstants.KEY_TARGET, properties.getOrDefault(GlobalNavConstants.PROP_TARGET, StringUtils.EMPTY));
		jsonObjLink.put(GlobalNavConstants.KEY_VALUE, jsonObjLinkValue);
		jsonObj.put(GlobalNavConstants.KEY_OBJ,jsonObjLink);
		
		
		return jsonObj;
	}
	
	private JSONObject getObj(String stringValue, JSONObject value) throws JSONException {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put(GlobalNavConstants.KEY_OBJ, new JSONObject().put(GlobalNavConstants.KEY_VALUE, value));
		jsonObj.put(GlobalNavConstants.KEY_VALUE, stringValue);		
		return jsonObj;
	}

	private void setLoggedOut(JSONObject loggedOut, Resource globalNavResource) throws JSONException {
		JSONArray children = new JSONArray();
		
		Resource resource = globalNavResource.getChild(GlobalNavConstants.NODE_LOGGED_OUT);
		if (null == resource) {
			return;
		}
		Iterator<Resource> childrenRes = resource.listChildren();
		while (childrenRes.hasNext()) {
			JSONObject child = new JSONObject();
			Resource childRes = childrenRes.next();
			ValueMap properties = ResourceUtil.getValueMap(childRes);
			JSONObject value = new JSONObject();
			String link = getLinkLogout(value, properties);
			JSONObject navLink = getObj();			
			navLink.put(GlobalNavConstants.KEY_VALUE, link);
			navLink.getJSONObject(GlobalNavConstants.KEY_OBJ).put(GlobalNavConstants.KEY_VALUE, value);
			child.put(GlobalNavConstants.KEY_NAVLINK, navLink);
			
			JSONObject navLabel = getObj();
			navLabel.getJSONObject(GlobalNavConstants.KEY_OBJ).put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(GlobalNavConstants.PROP_CTA_LABEL, StringUtils.EMPTY));
			navLabel.put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(GlobalNavConstants.PROP_CTA_LABEL, StringUtils.EMPTY));
			child.put(GlobalNavConstants.KEY_NAV_LABEL, navLabel);
			children.put(child);
		}
		loggedOut.put(GlobalNavConstants.KEY_CHILDREN, children);
		
	}

	private String getLinkLogout(JSONObject value, ValueMap properties) throws JSONException {
		StringBuilder sb = new StringBuilder();
		sb.append(GlobalNavConstants.HTML_ELE_LINK);
		value.put(GlobalNavConstants.KEY_HREF, properties.getOrDefault(GlobalNavConstants.PROP_CTA_LINK, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_HREF).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_CTA_LINK, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		value.put(GlobalNavConstants.KEY_URL, properties.getOrDefault(GlobalNavConstants.PROP_CTA_LINK, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_URL).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_CTA_LINK, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		value.put(GlobalNavConstants.KEY_TEXT, properties.getOrDefault(GlobalNavConstants.PROP_CTA_LABEL, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_TEXT).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_CTA_LABEL, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		value.put(GlobalNavConstants.KEY_LINKTYPE, properties.getOrDefault(GlobalNavConstants.PROP_CTA_TYPE, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_LINKTYPE).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_CTA_TYPE, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		sb.append(GlobalNavConstants.HTML_ELE_END);
		return sb.toString();
	}

	private void setHeaderLogo(JSONObject headerLogo, GlobalNavigationModel model) throws JSONException {
		JSONArray children = new JSONArray();
		JSONObject child = new JSONObject();
		child.put(GlobalNavConstants.KEY_IMAGE, getImage(model));
		child.put(GlobalNavConstants.KEY_TITLE, getObj());
		child.put(GlobalNavConstants.KEY_DESCRIPTION, getObj());
		children.put(child);
		headerLogo.put(GlobalNavConstants.KEY_CHILDREN, children);
		
	}

	private JSONObject getImage(GlobalNavigationModel model) throws JSONException {
		StringBuilder sb = new StringBuilder();
		sb.append(GlobalNavConstants.HTML_ELE_IMG);
		if (!StringUtils.isEmpty(model.getLogoimage())) {
			sb.append(GlobalNavConstants.HTML_ATTR_SRC).append(model.getLogoimage()).append(GlobalNavConstants.HTML_END_ATTR);
		}
		if (!StringUtils.isEmpty(model.getLogoalt())) {
			sb.append(GlobalNavConstants.HTML_ATTR_ALT).append(model.getLogoalt()).append(GlobalNavConstants.HTML_END_ATTR);
		}
		sb.append(GlobalNavConstants.HTML_ELE_END);
		JSONObject obj = getObj();
		obj.put(GlobalNavConstants.KEY_VALUE, sb.toString());
		return obj;
	}

	private JSONObject getObj() throws JSONException {
		JSONObject obj = new JSONObject();
		JSONObject value = new JSONObject();
		value.put(GlobalNavConstants.KEY_VALUE, new JSONObject());
		obj.put(GlobalNavConstants.KEY_OBJ, value);
		obj.put(GlobalNavConstants.KEY_VALUE, StringUtils.EMPTY);
		return obj;
	}

	private void setLoggedIn(JSONObject loggedIn, Resource globalNavResource) throws JSONException {
		
		JSONArray children = new JSONArray();		
		Resource resource = globalNavResource.getChild(GlobalNavConstants.NODE_LOGGED_IN);
		if (null == resource) {
			return;
		}
		Iterator<Resource> childrenRes = resource.listChildren();
		while (childrenRes.hasNext()) {
			JSONObject child = new JSONObject();
			Resource childRes = childrenRes.next();
			ValueMap properties = ResourceUtil.getValueMap(childRes);
			JSONObject enableExperience = getObj();
			enableExperience.getJSONObject(GlobalNavConstants.KEY_OBJ).put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(GlobalNavConstants.KEY_ENABLE_EXPERIENCE, StringUtils.EMPTY).toString().equalsIgnoreCase("true")?true:false);
			enableExperience.put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(GlobalNavConstants.KEY_ENABLE_EXPERIENCE, StringUtils.EMPTY).toString().equalsIgnoreCase("true")?true:false);
			child.put(GlobalNavConstants.KEY_ENABLE_EXPERIENCE, enableExperience);
			JSONObject deviceStyles = getObj();
			deviceStyles.getJSONObject(GlobalNavConstants.KEY_OBJ).put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(GlobalNavConstants.PROP_DEVICE_STYLES, StringUtils.EMPTY));
			deviceStyles.put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(GlobalNavConstants.PROP_DEVICE_STYLES, StringUtils.EMPTY));
			child.put(GlobalNavConstants.KEY_DEVICE_STYLES, deviceStyles);
			JSONObject value = new JSONObject();
			String link = getLinkLoggedIn(value, properties);
			JSONObject obj = getObj();
			obj.put(GlobalNavConstants.KEY_VALUE, link);
			obj.getJSONObject(GlobalNavConstants.KEY_OBJ).put(GlobalNavConstants.KEY_VALUE, value);
			child.put(GlobalNavConstants.KEY_NAVLINK, obj);
			
			JSONObject navLabel = getObj();
			navLabel.getJSONObject(GlobalNavConstants.KEY_OBJ).put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(GlobalNavConstants.PROP_LINK_LABLE, StringUtils.EMPTY));
			navLabel.put(GlobalNavConstants.KEY_VALUE, properties.getOrDefault(GlobalNavConstants.PROP_LINK_LABLE, StringUtils.EMPTY));
			child.put(GlobalNavConstants.KEY_NAV_LABEL, navLabel);
			children.put(child);
		}
		loggedIn.put(GlobalNavConstants.KEY_CHILDREN, children);
	}

	private String getLinkLoggedIn(JSONObject value, ValueMap properties) throws JSONException {
		
		StringBuilder sb = new StringBuilder();
		sb.append(GlobalNavConstants.HTML_ELE_LINK);
		value.put(GlobalNavConstants.KEY_HREF, properties.getOrDefault(GlobalNavConstants.PROP_LINK_URL, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_HREF).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_LINK_URL, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		value.put(GlobalNavConstants.KEY_URL, properties.getOrDefault(GlobalNavConstants.PROP_LINK_URL, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_URL).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_LINK_URL, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		value.put(GlobalNavConstants.KEY_CLASS, properties.getOrDefault(GlobalNavConstants.PROP_DEVICE_STYLE, StringUtils.EMPTY));
		sb.append(GlobalNavConstants.KEY_CLASS).append(GlobalNavConstants.HTML_START_ATTR).append(properties.getOrDefault(GlobalNavConstants.PROP_DEVICE_STYLE, StringUtils.EMPTY)).append(GlobalNavConstants.HTML_END_ATTR);
		sb.append(GlobalNavConstants.HTML_ELE_END);
		return sb.toString();
	}

}
