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
package org.apache.sling.scripting.sightly.apps.aemgeeks.components.content.servicedemo;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class servicedemo_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_service = null;
Collection var_collectionvar0_list_coerced$ = null;
Collection var_collectionvar12_list_coerced$ = null;
out.write("<h1>Service Demo</h1>\r\n");
_global_service = renderContext.call("use", com.aem.geeks.core.models.ServiceDemo.class.getName(), obj());
out.write("<div></div>\r\n\r\n--------------------Start Tutorial #29-----------------------\r\n<div></div>\r\n==================== USING Service and Iterator =============\r\n");
{
    Object var_collectionvar0 = renderContext.getObjectModel().resolveProperty(_global_service, "pagesList");
    {
        long var_size1 = ((var_collectionvar0_list_coerced$ == null ? (var_collectionvar0_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar0)) : var_collectionvar0_list_coerced$).size());
        {
            boolean var_notempty2 = (var_size1 > 0);
            if (var_notempty2) {
                {
                    long var_end5 = var_size1;
                    {
                        boolean var_validstartstepend6 = (((0 < var_size1) && true) && (var_end5 > 0));
                        if (var_validstartstepend6) {
                            out.write("<div>");
                            if (var_collectionvar0_list_coerced$ == null) {
                                var_collectionvar0_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar0);
                            }
                            long var_index7 = 0;
                            for (Object item : var_collectionvar0_list_coerced$) {
                                {
                                    long itemlist_field$_count = (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.ADD.eval(var_index7, 1)).longValue());
                                    {
                                        boolean var_traversal9 = (((var_index7 >= 0) && (var_index7 <= var_end5)) && true);
                                        if (var_traversal9) {
                                            out.write("\r\n    <p>");
                                            {
                                                String var_10 = ((" Page " + renderContext.getObjectModel().toString(renderContext.call("xss", itemlist_field$_count, "text"))) + " Title : ");
                                                out.write(renderContext.getObjectModel().toString(var_10));
                                            }
                                            out.write("<b>");
                                            {
                                                String var_11 = (renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "title"), "text")) + " ");
                                                out.write(renderContext.getObjectModel().toString(var_11));
                                            }
                                            out.write("</b></p>\r\n");
                                        }
                                    }
                                }
                                var_index7++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar0_list_coerced$ = null;
}
out.write("\r\n==================== USING Service and List ==================\r\n");
{
    Object var_collectionvar12 = renderContext.getObjectModel().resolveProperty(_global_service, "pageTitleList");
    {
        long var_size13 = ((var_collectionvar12_list_coerced$ == null ? (var_collectionvar12_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar12)) : var_collectionvar12_list_coerced$).size());
        {
            boolean var_notempty14 = (var_size13 > 0);
            if (var_notempty14) {
                {
                    long var_end17 = var_size13;
                    {
                        boolean var_validstartstepend18 = (((0 < var_size13) && true) && (var_end17 > 0));
                        if (var_validstartstepend18) {
                            out.write("<div>");
                            if (var_collectionvar12_list_coerced$ == null) {
                                var_collectionvar12_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar12);
                            }
                            long var_index19 = 0;
                            for (Object item : var_collectionvar12_list_coerced$) {
                                {
                                    long itemlist_field$_count = (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.ADD.eval(var_index19, 1)).longValue());
                                    {
                                        boolean var_traversal21 = (((var_index19 >= 0) && (var_index19 <= var_end17)) && true);
                                        if (var_traversal21) {
                                            out.write("\r\n    <p>");
                                            {
                                                String var_22 = ((" Page " + renderContext.getObjectModel().toString(renderContext.call("xss", itemlist_field$_count, "text"))) + " Title : ");
                                                out.write(renderContext.getObjectModel().toString(var_22));
                                            }
                                            out.write("<b>");
                                            {
                                                String var_23 = (renderContext.getObjectModel().toString(renderContext.call("xss", item, "text")) + " ");
                                                out.write(renderContext.getObjectModel().toString(var_23));
                                            }
                                            out.write("</b></p>\r\n");
                                        }
                                    }
                                }
                                var_index19++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar12_list_coerced$ = null;
}
out.write("\r\n---------------------End Tutorial #29-------------------------\r\n<div></div>\r\n--------------------Start Tutorial #30-----------------------\r\n<div><p> Name : <b>");
{
    Object var_24 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_service, "nameFromService"), "text");
    out.write(renderContext.getObjectModel().toString(var_24));
}
out.write("</b></p></div>\r\n<div><p> Name : <b>");
{
    Object var_25 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_service, "nameFromServiceB"), "text");
    out.write(renderContext.getObjectModel().toString(var_25));
}
out.write("</b></p></div>\r\n<div><p> Name With Reference : <b>");
{
    Object var_26 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_service, "nameWithReference"), "text");
    out.write(renderContext.getObjectModel().toString(var_26));
}
out.write("</b></p></div>\r\n---------------------End Tutorial #30-------------------------\r\n\r\n\r\n\r\n\r\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

