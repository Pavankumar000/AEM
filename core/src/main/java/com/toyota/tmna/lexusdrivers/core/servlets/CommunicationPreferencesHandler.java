package com.toyota.tmna.lexusdrivers.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;

@Component(service = Servlet.class,
        property = {
                "sling.servlet.resourceTypes =" + ConstantsUtil.SERVLET_RESOURCE_TYPE,
                "sling.servlet.selectors=" + "communicationpref",
                "sling.servlet.extensions=" + ConstantsUtil.SERVLET_EXTENSIONS})
public class CommunicationPreferencesHandler extends SlingAllMethodsServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(CommunicationPreferencesHandler.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        Map<String, String> output = new HashMap<>();
        String CPID = request.getParameter(ConstantsUtil.CPID);
        if (CPID != null && !CPID.equalsIgnoreCase(StringUtils.EMPTY)) {
            String CFPath = ConstantsUtil.CP_PATH + CPID + ".dcr" + ConstantsUtil.CP_MASTER_NODE;
            Resource CFresource = request.getResourceResolver().getResource(CFPath);
            if (CFresource != null) {
                ValueMap vm = CFresource.adaptTo(ValueMap.class);
                if (vm != null) {
                    output.put("name", extractValue(vm, "Name"));
                    output.put("heading", extractValue(vm, "Heading"));
                    output.put("shortDescription", extractValue(vm, "ShortDescription"));
                    output.put("description", extractValue(vm, "Description"));
                    output.put("desktopImageSrc", extractValue(vm, "desktopImageSrc"));
                    output.put("mobileImageSrc", extractValue(vm, "mobileImageSrc"));
                    output.put("tabImageSrc", extractValue(vm, "tabImageSrc"));
                }
            }
        }
        Gson gson = new Gson();
        String json = gson.toJson(output);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
        out.close();

    }

    private String extractValue(ValueMap vm, String key) {
        return vm.containsKey(key) ? vm.get(key, String.class) : org.apache.commons.lang3.StringUtils.EMPTY;
    }

}

