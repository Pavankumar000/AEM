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
package org.apache.sling.scripting.sightly.apps.aemgeeks.components.content.author__002d__books;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class author__002d__books_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_books = null;
Collection var_collectionvar1_list_coerced$ = null;
Collection var_collectionvar14_list_coerced$ = null;
Collection var_collectionvar28_list_coerced$ = null;
Collection var_collectionvar42_list_coerced$ = null;
Collection var_collectionvar55_list_coerced$ = null;
_global_books = renderContext.call("use", com.aem.geeks.core.models.AuthorBooks.class.getName(), obj());
out.write("<div>\r\n    <h1>");
{
    String var_0 = (renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_global_books, "authorName"), "text")) + " Books");
    out.write(renderContext.getObjectModel().toString(var_0));
}
out.write("</h1>\r\n    ===================Multifield with single field=============\r\n    ");
{
    Object var_collectionvar1 = renderContext.getObjectModel().resolveProperty(_global_books, "authorBooks");
    {
        long var_size2 = ((var_collectionvar1_list_coerced$ == null ? (var_collectionvar1_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar1)) : var_collectionvar1_list_coerced$).size());
        {
            boolean var_notempty3 = (var_size2 > 0);
            if (var_notempty3) {
                {
                    long var_end6 = var_size2;
                    {
                        boolean var_validstartstepend7 = (((0 < var_size2) && true) && (var_end6 > 0));
                        if (var_validstartstepend7) {
                            out.write("<div>");
                            if (var_collectionvar1_list_coerced$ == null) {
                                var_collectionvar1_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar1);
                            }
                            long var_index8 = 0;
                            for (Object item : var_collectionvar1_list_coerced$) {
                                {
                                    long itemlist_field$_count = (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.ADD.eval(var_index8, 1)).longValue());
                                    {
                                        boolean var_traversal10 = (((var_index8 >= 0) && (var_index8 <= var_end6)) && true);
                                        if (var_traversal10) {
                                            {
                                                String var_11 = (("\r\n         ---------------Book : " + renderContext.getObjectModel().toString(renderContext.call("xss", itemlist_field$_count, "text"))) + "--------------\r\n        ");
                                                out.write(renderContext.getObjectModel().toString(var_11));
                                            }
                                            out.write("<p> Book : <b>");
                                            {
                                                String var_12 = (renderContext.getObjectModel().toString(renderContext.call("xss", item, "text")) + " ");
                                                out.write(renderContext.getObjectModel().toString(var_12));
                                            }
                                            out.write("</b></p>\r\n    ");
                                        }
                                    }
                                }
                                var_index8++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar1_list_coerced$ = null;
}
out.write("\r\n    <p> ALL Book : <b>");
{
    Object var_13 = renderContext.call("xss", renderContext.call("join", renderContext.getObjectModel().resolveProperty(_global_books, "authorBooks"), ", "), "text");
    out.write(renderContext.getObjectModel().toString(var_13));
}
out.write("</b></p>\r\n\r\n    ========================== USING MAP ================================\r\n    ");
{
    Object var_collectionvar14 = renderContext.getObjectModel().resolveProperty(_global_books, "bookDetailsWithMap");
    {
        long var_size15 = ((var_collectionvar14_list_coerced$ == null ? (var_collectionvar14_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar14)) : var_collectionvar14_list_coerced$).size());
        {
            boolean var_notempty16 = (var_size15 > 0);
            if (var_notempty16) {
                {
                    long var_end19 = var_size15;
                    {
                        boolean var_validstartstepend20 = (((0 < var_size15) && true) && (var_end19 > 0));
                        if (var_validstartstepend20) {
                            out.write("<div>");
                            if (var_collectionvar14_list_coerced$ == null) {
                                var_collectionvar14_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar14);
                            }
                            long var_index21 = 0;
                            for (Object item : var_collectionvar14_list_coerced$) {
                                {
                                    long itemlist_field$_count = (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.ADD.eval(var_index21, 1)).longValue());
                                    {
                                        boolean var_traversal23 = (((var_index21 >= 0) && (var_index21 <= var_end19)) && true);
                                        if (var_traversal23) {
                                            {
                                                String var_24 = (("\r\n        ---------------Book : " + renderContext.getObjectModel().toString(renderContext.call("xss", itemlist_field$_count, "text"))) + "--------------\r\n        ");
                                                out.write(renderContext.getObjectModel().toString(var_24));
                                            }
                                            out.write("<p> Book : <b>");
                                            {
                                                String var_25 = (renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "bookname"), "text")) + " ");
                                                out.write(renderContext.getObjectModel().toString(var_25));
                                            }
                                            out.write("</b></p>\r\n        <p> Subject : <b>");
                                            {
                                                Object var_26 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "booksubject"), "text");
                                                out.write(renderContext.getObjectModel().toString(var_26));
                                            }
                                            out.write("</b> </p>\r\n        <p> Publish : <b>");
                                            {
                                                Object var_27 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "publishyear"), "text");
                                                out.write(renderContext.getObjectModel().toString(var_27));
                                            }
                                            out.write("</b> </p>\r\n    ");
                                        }
                                    }
                                }
                                var_index21++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar14_list_coerced$ = null;
}
out.write("\r\n\r\n\r\n    ========================== USING BEAN ================================\r\n    ");
{
    Object var_collectionvar28 = renderContext.getObjectModel().resolveProperty(_global_books, "bookDetailsWithBean");
    {
        long var_size29 = ((var_collectionvar28_list_coerced$ == null ? (var_collectionvar28_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar28)) : var_collectionvar28_list_coerced$).size());
        {
            boolean var_notempty30 = (var_size29 > 0);
            if (var_notempty30) {
                {
                    long var_end33 = var_size29;
                    {
                        boolean var_validstartstepend34 = (((0 < var_size29) && true) && (var_end33 > 0));
                        if (var_validstartstepend34) {
                            out.write("<div>");
                            if (var_collectionvar28_list_coerced$ == null) {
                                var_collectionvar28_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar28);
                            }
                            long var_index35 = 0;
                            for (Object item : var_collectionvar28_list_coerced$) {
                                {
                                    long itemlist_field$_count = (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.ADD.eval(var_index35, 1)).longValue());
                                    {
                                        boolean var_traversal37 = (((var_index35 >= 0) && (var_index35 <= var_end33)) && true);
                                        if (var_traversal37) {
                                            {
                                                String var_38 = (("\r\n        ---------------Book : " + renderContext.getObjectModel().toString(renderContext.call("xss", itemlist_field$_count, "text"))) + "--------------\r\n        ");
                                                out.write(renderContext.getObjectModel().toString(var_38));
                                            }
                                            out.write("<p> Book : <b>");
                                            {
                                                String var_39 = (renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "bookName"), "text")) + " ");
                                                out.write(renderContext.getObjectModel().toString(var_39));
                                            }
                                            out.write("</b></p>\r\n        <p> Date : <b>");
                                            {
                                                Object var_40 = renderContext.call("xss", renderContext.call("format", "MMM dd,yyyy", obj().with("format", renderContext.getObjectModel().resolveProperty(item, "publishDate"))), "text");
                                                out.write(renderContext.getObjectModel().toString(var_40));
                                            }
                                            out.write("</b> </p>\r\n        <p> Copies : <b>");
                                            {
                                                Object var_41 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "copies"), "text");
                                                out.write(renderContext.getObjectModel().toString(var_41));
                                            }
                                            out.write("</b> </p>\r\n    ");
                                        }
                                    }
                                }
                                var_index35++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar28_list_coerced$ = null;
}
out.write("\r\n\r\n\r\n\r\n    ================== USING NASTED MULTIFIELD ====================\r\n    ");
{
    Object var_collectionvar42 = renderContext.getObjectModel().resolveProperty(_global_books, "bookDetailsWithNastedMultifield");
    {
        long var_size43 = ((var_collectionvar42_list_coerced$ == null ? (var_collectionvar42_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar42)) : var_collectionvar42_list_coerced$).size());
        {
            boolean var_notempty44 = (var_size43 > 0);
            if (var_notempty44) {
                {
                    long var_end47 = var_size43;
                    {
                        boolean var_validstartstepend48 = (((0 < var_size43) && true) && (var_end47 > 0));
                        if (var_validstartstepend48) {
                            out.write("<div>");
                            if (var_collectionvar42_list_coerced$ == null) {
                                var_collectionvar42_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar42);
                            }
                            long var_index49 = 0;
                            for (Object item : var_collectionvar42_list_coerced$) {
                                {
                                    long itemlist_field$_count = (renderContext.getObjectModel().toNumber(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.ADD.eval(var_index49, 1)).longValue());
                                    {
                                        boolean var_traversal51 = (((var_index49 >= 0) && (var_index49 <= var_end47)) && true);
                                        if (var_traversal51) {
                                            {
                                                String var_52 = (("\r\n        ---------------Book : " + renderContext.getObjectModel().toString(renderContext.call("xss", itemlist_field$_count, "text"))) + "--------------\r\n        ");
                                                out.write(renderContext.getObjectModel().toString(var_52));
                                            }
                                            out.write("<p> Book : <b>");
                                            {
                                                String var_53 = (renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "bookName"), "text")) + " ");
                                                out.write(renderContext.getObjectModel().toString(var_53));
                                            }
                                            out.write("</b></p>\r\n        <p> Subject : <b>");
                                            {
                                                String var_54 = (renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(item, "bookSubject"), "text")) + " ");
                                                out.write(renderContext.getObjectModel().toString(var_54));
                                            }
                                            out.write("</b></p>\r\n        ");
                                            {
                                                Object var_collectionvar55 = renderContext.getObjectModel().resolveProperty(item, "bookEditons");
                                                {
                                                    long var_size56 = ((var_collectionvar55_list_coerced$ == null ? (var_collectionvar55_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar55)) : var_collectionvar55_list_coerced$).size());
                                                    {
                                                        boolean var_notempty57 = (var_size56 > 0);
                                                        if (var_notempty57) {
                                                            {
                                                                long var_end60 = var_size56;
                                                                {
                                                                    boolean var_validstartstepend61 = (((0 < var_size56) && true) && (var_end60 > 0));
                                                                    if (var_validstartstepend61) {
                                                                        out.write("<div>");
                                                                        if (var_collectionvar55_list_coerced$ == null) {
                                                                            var_collectionvar55_list_coerced$ = renderContext.getObjectModel().toCollection(var_collectionvar55);
                                                                        }
                                                                        long var_index62 = 0;
                                                                        for (Object editon : var_collectionvar55_list_coerced$) {
                                                                            {
                                                                                boolean var_traversal64 = (((var_index62 >= 0) && (var_index62 <= var_end60)) && true);
                                                                                if (var_traversal64) {
                                                                                    out.write("\r\n            <p> Book Editon : <b>");
                                                                                    {
                                                                                        String var_65 = (renderContext.getObjectModel().toString(renderContext.call("xss", renderContext.getObjectModel().resolveProperty(editon, "bookEditon"), "text")) + " ");
                                                                                        out.write(renderContext.getObjectModel().toString(var_65));
                                                                                    }
                                                                                    out.write("</b></p>\r\n            <p> Published Date : <b>");
                                                                                    {
                                                                                        Object var_66 = renderContext.call("xss", renderContext.call("format", "MMM dd,yyyy", obj().with("format", renderContext.getObjectModel().resolveProperty(editon, "editonDate"))), "text");
                                                                                        out.write(renderContext.getObjectModel().toString(var_66));
                                                                                    }
                                                                                    out.write("</b> </p>\r\n        ");
                                                                                }
                                                                            }
                                                                            var_index62++;
                                                                        }
                                                                        out.write("</div>");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                var_collectionvar55_list_coerced$ = null;
                                            }
                                            out.write("\r\n    ");
                                        }
                                    }
                                }
                                var_index49++;
                            }
                            out.write("</div>");
                        }
                    }
                }
            }
        }
    }
    var_collectionvar42_list_coerced$ = null;
}
out.write("\r\n\r\n</div>\r\n\r\n\r\n\r\n\r\n\r\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

