package com.aem.geeks.core.servlets;

import com.day.cq.commons.jcr.JcrConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.request.RequestParameter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@Component(service = Servlet.class)
@SlingServletResourceTypes(
        methods = {HttpConstants.METHOD_GET,HttpConstants.METHOD_POST},
        resourceTypes = "aemgeeks/components/structure/page",
        selectors = {"geeks","test"},
        extensions = {"txt","xml"}
)
public class GeeksResourceTypesServlet extends SlingAllMethodsServlet {
    private static final Logger LOG = LoggerFactory.getLogger(GeeksResourceTypesServlet.class);

    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws ServletException, IOException {
        final Resource resource = req.getResource();//return the resource object on whose behalf 
        //servlet acts
        resp.setContentType("text/plain");
        resp.getWriter().write("Page Title = " + resource.getValueMap().get(JcrConstants.JCR_TITLE));
    }
    @Override
    protected void doPost(SlingHttpServletRequest req, SlingHttpServletResponse resp)
            throws ServletException, IOException {
        try {
            LOG.info("\n ------------------------STARTED POST-------------------------");
            List<RequestParameter> requestParameterList=req.getRequestParameterList();
            //getRequestParameter returns the value of the request parameter
            //this getRequestParameter is used if parameter has only one value
            //for this we have to import the request parameter sling api
            //getRequestParameter shortcut for getRequestParameterMap().getValue(String)
            for(RequestParameter requestParameter : requestParameterList){
                LOG.info("\n ==PARAMETERS===>  {} : {} ",requestParameter.getName(),requestParameter.getString());
            }
        }catch (Exception e){
            LOG.info("\n ERROR IN REQUEST {} ",e.getMessage());
        }
        resp.getWriter().write("======FORM SUBMITTED========");

    }

}
