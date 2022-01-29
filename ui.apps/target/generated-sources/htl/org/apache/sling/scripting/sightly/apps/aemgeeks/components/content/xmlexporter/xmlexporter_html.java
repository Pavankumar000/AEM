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
package org.apache.sling.scripting.sightly.apps.aemgeeks.components.content.xmlexporter;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class xmlexporter_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_geekexporter = null;
Object _dynamic_card = bindings.get("card");
Collection var_collectionvar4_list_coerced$ = null;
_global_geekexporter = renderContext.call("use", com.aem.geeks.core.models.XmlExporter.class.getName(), obj());
out.write("<div></div>\r\n<!-- Basic Card Example -->\r\n <div class=\"card shadow mb-4\">\r\n     <div class=\"card-header py-3\">\r\n         <h6 class=\"m-0 font-weight-bold text-primary\">");
{
    Object var_0 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_card, "title"), "text");
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</h6>\r\n     </div>\r\n     <div class=\"card-body\">\r\n         <p>Title : <b>");
{
    Object var_1 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_geekexporter, "title"), "text");
    out.write(renderContext.getObjectModel().toString(var_1));
}
out.write("</b></p>\r\n         <p>Description :<b>");
{
    Object var_2 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_geekexporter, "description"), "text");
    out.write(renderContext.getObjectModel().toString(var_2));
}
out.write("</b></p>\r\n         <p> Date : <b>");
{
    Object var_3 = renderContext.call("xss", renderContext.call("format", "MMM dd,yyyy", obj().with("format", renderContext.getObjectModel().resolveProperty(_global_geekexporter, "date"))), "text");
    out.write(renderContext.getObjectModel().toString(var_3));
}
out.write("</b> </p>\r\n\r\n         ================== USING LIST ================\r\n         ");
{
    Object var_collectionvar4 = renderContext.getObjectModel().resolveProperty(_global_geekexporter, "books");
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
                            out.write("<div>");
                            if (var_collectionvar4_list_coerced$ == null) {
                                var_collectionvar4_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar4);
                            }
                            long var_index11 = 0;
                            for (Object item : var_collectionvar4_list_coerced$) {
                                {
                                    long itemlist_field$_count = (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.ADD.eval(var_index11, 1)).longValue());
                                    {
                                        boolean var_traversal13 = (((var_index11 >= 0) && (var_index11 <= var_end9)) && true);
                                        if (var_traversal13) {
                                            out.write("\r\n             <p>");
                                            {
                                                String var_14 = ((" Book " + renderContext.getObjectModel().toString(renderContext.call("xss", itemlist_field$_count, "text"))) + " : ");
                                                out.write(renderContext.getObjectModel().toString(var_14));
                                            }
                                            out.write("<b>");
                                            {
                                                String var_15 = (renderContext.getObjectModel().toString(renderContext.call("xss", item, "text")) + " ");
                                                out.write(renderContext.getObjectModel().toString(var_15));
                                            }
                                            out.write("</b></p>\r\n         ");
                                        }
                                    }
                                }
                                var_index11++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar4_list_coerced$ = null;
}
out.write("\r\n\r\n     </div>\r\n </div>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

