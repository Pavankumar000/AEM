package com.toyota.tmna.lexusdrivers.core.servlets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;

import com.day.cq.commons.jcr.JcrConstants;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.wrappers.ValueMapDecorator;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.ui.components.ds.DataSource;
import com.adobe.granite.ui.components.ds.SimpleDataSource;
import com.adobe.granite.ui.components.ds.ValueMapResource;

@Component(service = Servlet.class, property = { "sling.servlet.resourceTypes=" + ConstantsUtil.SERVLET_RESOURCE_TYPE_DROPDOWN })
public class HandleDropdownsServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(HandleDropdownsServlet.class);
	private static final String GENERIC_PATH = ConstantsUtil.DROPDOWN_GENERIC_PATH;
	private static final String APPS_PATH = ConstantsUtil.APPS_PATH;
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
		Resource r = request.getResource();
		Resource dataSource = r.getChild("datasource");
		if (dataSource != null) {
			String rootPath = APPS_PATH + GENERIC_PATH + dataSource.getValueMap().get("dropdownListName", String.class);
			List<Resource> dropDownList = new ArrayList<>();
			List<Resource> dropDownListWithoutRule = new ArrayList<>();
			ResourceResolver resourceResolver = request.getResourceResolver();
			Resource resource = resourceResolver.resolve(rootPath);
			if (resource.hasChildren()) {
				Iterator<Resource> listChildren = resource.listChildren();
				while (listChildren.hasNext()) {
					Resource child = listChildren.next();
					ValueMap valuemap = child.adaptTo(ValueMap.class);
					ValueMap vmap = new ValueMapDecorator(new HashMap<>());
					if(valuemap !=null && valuemap.get("text", String.class)!=null){
					vmap.put("text", valuemap.get("text", String.class));
					if (valuemap.containsKey("reg") && valuemap.containsKey("msg")) {
						vmap.put("value",
								valuemap.get("reg", String.class) + " || " + valuemap.get("msg", String.class));
					} else {
						vmap.put("value", valuemap.get("value", String.class));
					}
					dropDownList.add(
							new ValueMapResource(resourceResolver, new ResourceMetadata(), JcrConstants.NT_UNSTRUCTURED, vmap));
					}
				}
				if (!dropDownList.isEmpty()) {
					DataSource datasource = new SimpleDataSource(dropDownList.iterator());
					request.setAttribute(DataSource.class.getName(), datasource);
				}
			} else {
				ValueMap vmap = new ValueMapDecorator(new HashMap<>());
				vmap.put("text", "Nothing Found");
				vmap.put("value", "nothing found");
				dropDownListWithoutRule
						.add(new ValueMapResource(resourceResolver, new ResourceMetadata(), JcrConstants.NT_UNSTRUCTURED, vmap));
				DataSource datasource = new SimpleDataSource(dropDownListWithoutRule.iterator());
				request.setAttribute(DataSource.class.getName(), datasource);

			}
		}else{
			log.info("HandleDropdownsServlet :: Resource Not Found");
		}

	}

}