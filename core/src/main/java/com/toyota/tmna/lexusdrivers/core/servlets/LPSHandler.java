package com.toyota.tmna.lexusdrivers.core.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.jcr.Node;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.dam.cfm.ContentFragment;
import com.adobe.cq.dam.cfm.FragmentTemplate;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;

@Component( service = Servlet.class,
property = {
"sling.servlet.resourceTypes =" + ConstantsUtil.SERVLET_RESOURCE_TYPE,
"sling.servlet.selectors=" + "lps",
"sling.servlet.extensions=" + ConstantsUtil.SERVLET_EXTENSIONS})
public class LPSHandler extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(LPSHandler.class);

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		
		 PrintWriter out = response.getWriter(); 
		 JsonArray jsonArray = new JsonArray();
		 String LPSID=request.getParameter(ConstantsUtil.LPSID);
		 if(LPSID!=null&&!LPSID.equalsIgnoreCase(StringUtils.EMPTY)) { 
			 String model=LPSID.split("-")[0];
			 String year=LPSID.split("-")[1]; 
			 String CFPath=ConstantsUtil.LPS_PATH+year+"/"+model; 
			 Resource CFresource = request.getResourceResolver().getResource(CFPath);
			 Iterator<Resource> childrenLPS=CFresource!=null?CFresource.getChildren().iterator():null;
		   while(childrenLPS!=null && childrenLPS.hasNext()) {
			   Resource lps=childrenLPS.next();
			   JsonObject lpsJson = new JsonObject();
			   if(lps!=null) { 
				   Resource lpsData=lps.getChild(ConstantsUtil.LP_MASTER_NODE);
					  if(lpsData!=null) {
						  ValueMap vm=lpsData.getValueMap();
						  lpsJson.addProperty("Model", extractValue(vm,"Model"));
						  lpsJson.addProperty("Year", extractValue(vm,"Year"));
						  lpsJson.addProperty("Type", extractValue(vm,"Type"));
						  lpsJson.addProperty("PDFSource", extractValue(vm,"PDF Source")); 
					  }
		  
			   		}
			   jsonArray.add(lpsJson);
		   	}
		 } 
		 Gson gson = new Gson(); 
		 String json = gson.toJson(jsonArray);
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8"); out.print(json); out.flush();
		 out.close();
	}		
		
		
	private String extractValue(ValueMap vm,String key){
		return vm.containsKey(key) ? vm.get(key, String.class) : org.apache.commons.lang3.StringUtils.EMPTY;
	}
	
}
