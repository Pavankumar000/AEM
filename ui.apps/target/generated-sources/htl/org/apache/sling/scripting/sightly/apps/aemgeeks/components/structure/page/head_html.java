/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.sling.scripting.sightly.apps.aemgeeks.components.structure.page;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class head_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_head = getProperty("head");
out.write("\r\n");
out.write("\r\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------

/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
addSubTemplate("head", new RenderUnit() {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Sub-Template Body -------------------------------------------------------------------------

Object _global_headlibrenderer = null;
Object _global_headresources = null;
Object _dynamic_page = arguments.get("page");
Object _global_keywords = null;
Object _dynamic_properties = bindings.get("properties");
Object _global_description = null;
Object _global_templatename = null;
Object _global_appresourcespath = null;
_global_headlibrenderer = renderContext.call("use", "headlibs.html", obj());
_global_headresources = renderContext.call("use", "head.resources.html", obj());
out.write("\r\n    <meta charset=\"UTF-8\"/>\r\n    <title>");
{
    Object var_0 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_page, "title"), "text");
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</title>\r\n    ");
_global_keywords = renderContext.getObjectModel().resolveProperty(_dynamic_page, "keywords");
if (renderContext.getObjectModel().toBoolean(_global_keywords)) {
    out.write("<meta name=\"keywords\"");
    {
        Object var_attrvalue1 = _global_keywords;
        {
            Object var_attrcontent2 = renderContext.call("xss", var_attrvalue1, "attribute");
            {
                Object var_shoulddisplayattr4 = ((renderContext.getObjectModel().toBoolean(var_attrcontent2) ? var_attrcontent2 : ("false".equals(var_attrvalue1))));
                if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr4)) {
                    out.write(" content");
                    {
                        boolean var_istrueattr3 = (var_attrvalue1.equals(true));
                        if (!var_istrueattr3) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrcontent2));
                            out.write("\"");
                        }
                    }
                }
            }
        }
    }
    out.write("/>");
}
out.write("\r\n    ");
_global_description = renderContext.getObjectModel().resolveProperty(_dynamic_properties, "jcr:description");
if (renderContext.getObjectModel().toBoolean(_global_description)) {
    out.write("<meta name=\"description\"");
    {
        Object var_attrvalue5 = _global_description;
        {
            Object var_attrcontent6 = renderContext.call("xss", var_attrvalue5, "attribute");
            {
                Object var_shoulddisplayattr8 = ((renderContext.getObjectModel().toBoolean(var_attrcontent6) ? var_attrcontent6 : ("false".equals(var_attrvalue5))));
                if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr8)) {
                    out.write(" content");
                    {
                        boolean var_istrueattr7 = (var_attrvalue5.equals(true));
                        if (!var_istrueattr7) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrcontent6));
                            out.write("\"");
                        }
                    }
                }
            }
        }
    }
    out.write("/>");
}
out.write("\r\n    ");
_global_templatename = renderContext.getObjectModel().resolveProperty(_dynamic_page, "templateName");
if (renderContext.getObjectModel().toBoolean(_global_templatename)) {
    out.write("<meta name=\"template\"");
    {
        Object var_attrvalue9 = _global_templatename;
        {
            Object var_attrcontent10 = renderContext.call("xss", var_attrvalue9, "attribute");
            {
                Object var_shoulddisplayattr12 = ((renderContext.getObjectModel().toBoolean(var_attrcontent10) ? var_attrcontent10 : ("false".equals(var_attrvalue9))));
                if (renderContext.getObjectModel().toBoolean(var_shoulddisplayattr12)) {
                    out.write(" content");
                    {
                        boolean var_istrueattr11 = (var_attrvalue9.equals(true));
                        if (!var_istrueattr11) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrcontent10));
                            out.write("\"");
                        }
                    }
                }
            }
        }
    }
    out.write("/>");
}
out.write("\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>\r\n    ");
{
    Object var_includedresult13 = renderContext.call("include", "head.socialmedia.html", obj());
    out.write(renderContext.getObjectModel().toString(var_includedresult13));
}
out.write("\r\n    ");
{
    Object var_includedresult15 = renderContext.call("include", "customheaderlibs.html", obj());
    out.write(renderContext.getObjectModel().toString(var_includedresult15));
}
out.write("\r\n    ");
{
    Object var_templatevar17 = renderContext.getObjectModel().resolveProperty(_global_headlibrenderer, "headlibs");
    {
        Object var_templateoptions18_field$_clientlibcategories = renderContext.getObjectModel().resolveProperty(_dynamic_page, "clientLibCategories");
        {
            Object var_templateoptions18_field$_hascloudconfigsupport = renderContext.getObjectModel().resolveProperty(_dynamic_page, "hasCloudconfigSupport");
            {
                Object var_templateoptions18_field$_clientlibcategoriesjshead = renderContext.getObjectModel().resolveProperty(_dynamic_page, "clientLibCategoriesJsHead");
                {
                    Object var_templateoptions18_field$_staticdesignpath = renderContext.getObjectModel().resolveProperty(_dynamic_page, "staticDesignPath");
                    {
                        Object var_templateoptions18_field$_designpath = renderContext.getObjectModel().resolveProperty(_dynamic_page, "designPath");
                        {
                            java.util.Map var_templateoptions18 = obj().with("clientLibCategories", var_templateoptions18_field$_clientlibcategories).with("hasCloudconfigSupport", var_templateoptions18_field$_hascloudconfigsupport).with("clientLibCategoriesJsHead", var_templateoptions18_field$_clientlibcategoriesjshead).with("staticDesignPath", var_templateoptions18_field$_staticdesignpath).with("designPath", var_templateoptions18_field$_designpath);
                            callUnit(out, renderContext, var_templatevar17, var_templateoptions18);
                        }
                    }
                }
            }
        }
    }
}
out.write("\r\n    ");
_global_appresourcespath = renderContext.getObjectModel().resolveProperty(_dynamic_page, "appResourcesPath");
if (renderContext.getObjectModel().toBoolean(_global_appresourcespath)) {
    {
        Object var_templatevar19 = renderContext.getObjectModel().resolveProperty(_global_headresources, "favicons");
        {
            Object var_templateoptions20_field$_path = _global_appresourcespath;
            {
                java.util.Map var_templateoptions20 = obj().with("path", var_templateoptions20_field$_path);
                callUnit(out, renderContext, var_templatevar19, var_templateoptions20);
            }
        }
    }
}
out.write("\r\n");


// End Of Main Sub-Template Body ------------------------------------------------------------------
    }



    {
//Sub-Sub-Templates Initialization ----------------------------------------------------------------



//End of Sub-Sub-Templates Initialization ---------------------------------------------------------
    }
    
});


//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

