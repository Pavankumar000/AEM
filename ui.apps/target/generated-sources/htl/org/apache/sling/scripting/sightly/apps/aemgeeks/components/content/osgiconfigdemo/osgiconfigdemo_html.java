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
package org.apache.sling.scripting.sightly.apps.aemgeeks.components.content.osgiconfigdemo;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class osgiconfigdemo_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_osgiconfig = null;
Collection var_collectionvar4_list_coerced$ = null;
Collection var_collectionvar18_list_coerced$ = null;
out.write("<h1>OSGi Configuration Demo</h1>\r\n");
_global_osgiconfig = renderContext.call("use", com.aem.geeks.core.models.OSGiConfigDemo.class.getName(), obj());
out.write("<div></div>\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n--------------------Start Tutorial #31-----------------------\r\n<div><p> Service Name : <b>");
{
    Object var_0 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_osgiconfig, "serviceName"), "text");
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</b></p></div>\r\n<div><p> Service Count : <b>");
{
    Object var_1 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_osgiconfig, "serviceCount"), "text");
    out.write(renderContext.getObjectModel().toString(var_1));
}
out.write("</b></p></div>\r\n<div><p> Live Data : <b>");
{
    Object var_2 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_osgiconfig, "liveData"), "text");
    out.write(renderContext.getObjectModel().toString(var_2));
}
out.write("</b></p></div>\r\n<div><p> Run Mode : <b>");
{
    Object var_3 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_osgiconfig, "runModes"), "text");
    out.write(renderContext.getObjectModel().toString(var_3));
}
out.write("</b></p></div>\r\n<div><b>Countries</b></div>\r\n");
{
    Object var_collectionvar4 = renderContext.getObjectModel().resolveProperty(_global_osgiconfig, "countries");
    {
        long var_size5 = ((var_collectionvar4_list_coerced$ == null ? (var_collectionvar4_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar4)) : var_collectionvar4_list_coerced$).size());
        {
            boolean var_notempty6 = (var_size5 > 0);
            if (var_notempty6) {
                {
                    long var_end9 = var_size5;
                    {
                        boolean var_validstartstepend10 = (((0 < var_size5) && true) && (var_end9 > 0));
                        if (var_validstartstepend10) {
                            out.write("<ul>");
                            if (var_collectionvar4_list_coerced$ == null) {
                                var_collectionvar4_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar4);
                            }
                            long var_index11 = 0;
                            for (Object item : var_collectionvar4_list_coerced$) {
                                {
                                    boolean var_traversal13 = (((var_index11 >= 0) && (var_index11 <= var_end9)) && true);
                                    if (var_traversal13) {
                                        out.write("\r\n    <li>");
                                        {
                                            Object var_14 = renderContext.call("xss", item, "text");
                                            out.write(renderContext.getObjectModel().toString(var_14));
                                        }
                                        out.write("</li>\r\n");
                                    }
                                }
                                var_index11++;
                            }
                            out.write("</ul>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar4_list_coerced$ = null;
}
out.write("\r\n--------------------End Tutorial #31-----------------------\r\n<div> </div>\r\n--------------------Start Tutorial #32-----------------------\r\n<div><p> Service ID : <b>");
{
    Object var_15 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_osgiconfig, "serviceId"), "text");
    out.write(renderContext.getObjectModel().toString(var_15));
}
out.write("</b></p></div>\r\n<div><p> Service Name : <b>");
{
    Object var_16 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_osgiconfig, "serviceNameModule"), "text");
    out.write(renderContext.getObjectModel().toString(var_16));
}
out.write("</b></p></div>\r\n<div><p> Service URL : <b>");
{
    Object var_17 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_osgiconfig, "serviceURL"), "text");
    out.write(renderContext.getObjectModel().toString(var_17));
}
out.write("</b></p></div>\r\n--------------------End Tutorial #32-----------------------\r\n\r\n<div> </div>\r\n--------------------Start Tutorial #33-----------------------\r\n");
{
    Object var_collectionvar18 = renderContext.getObjectModel().resolveProperty(_global_osgiconfig, "allOSGiConfigs");
    {
        long var_size19 = ((var_collectionvar18_list_coerced$ == null ? (var_collectionvar18_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar18)) : var_collectionvar18_list_coerced$).size());
        {
            boolean var_notempty20 = (var_size19 > 0);
            if (var_notempty20) {
                {
                    long var_end23 = var_size19;
                    {
                        boolean var_validstartstepend24 = (((0 < var_size19) && true) && (var_end23 > 0));
                        if (var_validstartstepend24) {
                            out.write("<div>");
                            if (var_collectionvar18_list_coerced$ == null) {
                                var_collectionvar18_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar18);
                            }
                            long var_index25 = 0;
                            for (Object item : var_collectionvar18_list_coerced$) {
                                {
                                    long itemlist_field$_count = (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.ADD.eval(var_index25, 1)).longValue());
                                    {
                                        boolean var_traversal27 = (((var_index25 >= 0) && (var_index25 <= var_end23)) && true);
                                        if (var_traversal27) {
                                            out.write("\r\n     ------Config # <b>");
                                            {
                                                Object var_28 = renderContext.call("xss", itemlist_field$_count, "text");
                                                out.write(renderContext.getObjectModel().toString(var_28));
                                            }
                                            out.write("</b>-----\r\n    <div><p> Config ID: <b>");
                                            {
                                                Object var_29 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "configID"), "text");
                                                out.write(renderContext.getObjectModel().toString(var_29));
                                            }
                                            out.write("</b></p></div>\r\n    <div><p> Service Name: <b>");
                                            {
                                                Object var_30 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "serviceName"), "text");
                                                out.write(renderContext.getObjectModel().toString(var_30));
                                            }
                                            out.write("</b></p></div>\r\n    <div><p> Service URL : <b>");
                                            {
                                                Object var_31 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "serviceURL"), "text");
                                                out.write(renderContext.getObjectModel().toString(var_31));
                                            }
                                            out.write("</b></p></div>\r\n");
                                        }
                                    }
                                }
                                var_index25++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar18_list_coerced$ = null;
}
out.write("\r\n--------------------End Tutorial #33-----------------------\r\n\r\n\r\n\r\n\r\n\r\n\r\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

