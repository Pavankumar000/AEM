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
package org.apache.sling.scripting.sightly.apps.aemgeeks.components.content.author;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class author_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_author = null;
Collection var_collectionvar8_list_coerced$ = null;
out.write("<h1>Author Bio</h1>\r\n");
_global_author = renderContext.call("use", com.aem.geeks.core.models.Author.class.getName(), obj().with("rAttribute", "TestAttribute"));
out.write("<div></div>\r\n\r\n    <div>");
{
    String var_0 = (("First Name :  " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_author, "firstName"), "text"))) + " ");
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</div>\r\n    <div>");
{
    String var_1 = (("Lasr Name :  " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_author, "lastName"), "text"))) + "   ");
    out.write(renderContext.getObjectModel().toString(var_1));
}
out.write("</div>\r\n    <div>");
{
    String var_2 = (("Is Professor:  " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_author, "isProfessor"), "text"))) + "  ");
    out.write(renderContext.getObjectModel().toString(var_2));
}
out.write("</div>\r\n    <div>");
{
    String var_3 = (("Page Title :  " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_author, "pageTitle"), "text"))) + "  ");
    out.write(renderContext.getObjectModel().toString(var_3));
}
out.write("</div>\r\n    <div>");
{
    String var_4 = (("Request Attribute :  " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_author, "requestAttribute"), "text"))) + "  ");
    out.write(renderContext.getObjectModel().toString(var_4));
}
out.write("</div>\r\n    <div>");
{
    String var_5 = (("Home Page Name :  " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_author, "homePageName"), "text"))) + "  ");
    out.write(renderContext.getObjectModel().toString(var_5));
}
out.write("</div>\r\n    <div>");
{
    String var_6 = (("Modified By :  " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_author, "lastModifiedBy"), "text"))) + "  ");
    out.write(renderContext.getObjectModel().toString(var_6));
}
out.write("</div>\r\n    \r\n    <div>");
{
    String var_7 = ("Books : " + renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.call("join", renderContext.getObjectModel().resolveProperty(_global_author, "books"), ", "), "text")));
    out.write(renderContext.getObjectModel().toString(var_7));
}
out.write("</div>\r\n\r\n        ========================== USING MAP ================================\r\n    ");
{
    Object var_collectionvar8 = renderContext.getObjectModel().resolveProperty(_global_author, "bookDetailsWithMap");
    {
        long var_size9 = ((var_collectionvar8_list_coerced$ == null ? (var_collectionvar8_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar8)) : var_collectionvar8_list_coerced$).size());
        {
            boolean var_notempty10 = (var_size9 > 0);
            if (var_notempty10) {
                {
                    long var_end13 = var_size9;
                    {
                        boolean var_validstartstepend14 = (((0 < var_size9) && true) && (var_end13 > 0));
                        if (var_validstartstepend14) {
                            out.write("<div>");
                            if (var_collectionvar8_list_coerced$ == null) {
                                var_collectionvar8_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar8);
                            }
                            long var_index15 = 0;
                            for (Object item : var_collectionvar8_list_coerced$) {
                                {
                                    long itemlist_field$_count = (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.ADD.eval(var_index15, 1)).longValue());
                                    {
                                        boolean var_traversal17 = (((var_index15 >= 0) && (var_index15 <= var_end13)) && true);
                                        if (var_traversal17) {
                                            {
                                                String var_18 = (("\r\n        ---------------Book : " + renderContext.getObjectModel().toString(renderContext.call("xss", itemlist_field$_count, "text"))) + "--------------\r\n        ");
                                                out.write(renderContext.getObjectModel().toString(var_18));
                                            }
                                            out.write("<p> Book : <b>");
                                            {
                                                String var_19 = (renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "bookname"), "text")) + " ");
                                                out.write(renderContext.getObjectModel().toString(var_19));
                                            }
                                            out.write("</b></p>\r\n        <p> Subject : <b>");
                                            {
                                                Object var_20 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "booksubject"), "text");
                                                out.write(renderContext.getObjectModel().toString(var_20));
                                            }
                                            out.write("</b> </p>\r\n        <p> Publish : <b>");
                                            {
                                                Object var_21 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "publishyear"), "text");
                                                out.write(renderContext.getObjectModel().toString(var_21));
                                            }
                                            out.write("</b> </p>\r\n    ");
                                        }
                                    }
                                }
                                var_index15++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar8_list_coerced$ = null;
}
out.write("\r\n\r\n\r\n\r\n\r\n\r\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

