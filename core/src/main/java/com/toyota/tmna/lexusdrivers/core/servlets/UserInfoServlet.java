package com.toyota.tmna.lexusdrivers.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.toyota.tmna.lexusdrivers.core.bean.UserInfo;
import com.toyota.tmna.lexusdrivers.core.util.AEMServletUtil;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;


@Component( service = Servlet.class,
property = {
"sling.servlet.resourceTypes =" + ConstantsUtil.SERVLET_RESOURCE_TYPE,
"sling.servlet.selectors=" + ConstantsUtil.USER_INFO,
"sling.servlet.extensions=" + ConstantsUtil.SERVLET_EXTENSIONS_USERINFO})
public class UserInfoServlet extends SlingSafeMethodsServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -419582993485076957L;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoServlet.class);

	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		JsonObject output = new JsonObject();
		UserInfo userinfo = null;
		String cookieName = ConstantsUtil.ID_TOKEN;
		LOGGER.info(" ID Token Cookie Name= "+cookieName);
		if(StringUtils.isNotEmpty(AEMServletUtil.getCookieToken(request,cookieName))) {
			LOGGER.info(" Cookie is not Empty  ");
			userinfo = AEMServletUtil.getUser(request);
			LOGGER.info(" Cookie is not Empty = "+((userinfo!=null) ? userinfo.toString() : " UserInfo Empty  "));
		}

		if(userinfo!=null) {
			JsonObject userDetails = new JsonObject();
			
			userDetails.addProperty(ConstantsUtil.ID_TOKEN_JSON, userinfo.getIdToken());
			
			output.add(ConstantsUtil.USER_INFO, userDetails);
		}	
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		LOGGER.debug(" Userinfo::value:: "+output.toString());
		out.print(output.toString());
		LOGGER.debug(" UserInfo Before FLushing");
		out.flush();
		LOGGER.debug(" UserInfo After Flush ");
		out.close();
		LOGGER.debug(" UserInfo Closed Resource");
	}
}
