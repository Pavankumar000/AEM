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
package org.apache.sling.scripting.sightly.apps.aemgeeks.components.global.navigation;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class navigation_html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

out.write("\r\n     <ul class=\"navbar-nav bg-gradient-primary sidebar sidebar-dark accordion\" id=\"accordionSidebar\">\r\n     <!-- Sidebar - Brand -->\r\n      <a class=\"sidebar-brand d-flex align-items-center justify-content-center\" href=\"#\">\r\n        <div class=\"sidebar-brand-icon rotate-n-15\">\r\n          <i class=\"fas fa-laugh-wink\"></i>\r\n        </div>\r\n        <div class=\"sidebar-brand-text mx-3\">GEEKS <sup>AEM</sup></div>\r\n      </a>\r\n\r\n      <!-- Divider -->\r\n      <hr class=\"sidebar-divider my-0\"/>\r\n\r\n      <!-- Nav Item - Dashboard -->\r\n      <li class=\"nav-item\">\r\n        <a class=\"nav-link\" href=\"#\">\r\n          <i class=\"fas fa-fw fa-tachometer-alt\"></i>\r\n          <span>Dashboard</span></a>\r\n      </li>\r\n\r\n      <!-- Divider -->\r\n      <hr class=\"sidebar-divider\"/>\r\n\r\n      <!-- Heading -->\r\n      <div class=\"sidebar-heading\">\r\n        Interface\r\n      </div>\r\n\r\n      <!-- Nav Item - Pages Collapse Menu -->\r\n      <li class=\"nav-item\">\r\n        <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseTwo\" aria-expanded=\"true\" aria-controls=\"collapseTwo\">\r\n          <i class=\"fas fa-fw fa-cog\"></i>\r\n          <span>Components</span>\r\n        </a>\r\n        <div id=\"collapseTwo\" class=\"collapse\" aria-labelledby=\"headingTwo\" data-parent=\"#accordionSidebar\">\r\n          <div class=\"bg-white py-2 collapse-inner rounded\">\r\n            <h6 class=\"collapse-header\">Custom Components:</h6>\r\n            <a class=\"collapse-item\" href=\"#\">Buttons</a>\r\n            <a class=\"collapse-item\" href=\"#\">Cards</a>\r\n          </div>\r\n        </div>\r\n      </li>\r\n\r\n      <!-- Nav Item - Utilities Collapse Menu -->\r\n      <li class=\"nav-item\">\r\n        <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseUtilities\" aria-expanded=\"true\" aria-controls=\"collapseUtilities\">\r\n          <i class=\"fas fa-fw fa-wrench\"></i>\r\n          <span>Utilities</span>\r\n        </a>\r\n        <div id=\"collapseUtilities\" class=\"collapse\" aria-labelledby=\"headingUtilities\" data-parent=\"#accordionSidebar\">\r\n          <div class=\"bg-white py-2 collapse-inner rounded\">\r\n            <h6 class=\"collapse-header\">Custom Utilities:</h6>\r\n            <a class=\"collapse-item\" href=\"#\">Colors</a>\r\n            <a class=\"collapse-item\" href=\"#\">Borders</a>\r\n            <a class=\"collapse-item\" href=\"#\">Animations</a>\r\n            <a class=\"collapse-item\" href=\"#\">Other</a>\r\n          </div>\r\n        </div>\r\n      </li>\r\n\r\n      <!-- Divider -->\r\n      <hr class=\"sidebar-divider\"/>\r\n\r\n      <!-- Heading -->\r\n      <div class=\"sidebar-heading\">\r\n        Addons\r\n      </div>\r\n\r\n      <!-- Nav Item - Pages Collapse Menu -->\r\n      <li class=\"nav-item active\">\r\n        <a class=\"nav-link\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapsePages\" aria-expanded=\"true\" aria-controls=\"collapsePages\">\r\n          <i class=\"fas fa-fw fa-folder\"></i>\r\n          <span>Pages</span>\r\n        </a>\r\n        <div id=\"collapsePages\" class=\"collapse show\" aria-labelledby=\"headingPages\" data-parent=\"#accordionSidebar\">\r\n          <div class=\"bg-white py-2 collapse-inner rounded\">\r\n            <h6 class=\"collapse-header\">Login Screens:</h6>\r\n            <a class=\"collapse-item\" href=\"#\">Login</a>\r\n            <a class=\"collapse-item\" href=\"#\">Register</a>\r\n            <a class=\"collapse-item\" href=\"#\">Forgot Password</a>\r\n            <div class=\"collapse-divider\"></div>\r\n            <h6 class=\"collapse-header\">Other Pages:</h6>\r\n            <a class=\"collapse-item\" href=\"#\">404 Page</a>\r\n            <a class=\"collapse-item active\" href=\"#\">Blank Page</a>\r\n          </div>\r\n        </div>\r\n      </li>\r\n\r\n      <!-- Nav Item - Charts -->\r\n      <li class=\"nav-item\">\r\n        <a class=\"nav-link\" href=\"#\">\r\n          <i class=\"fas fa-fw fa-chart-area\"></i>\r\n          <span>Charts</span></a>\r\n      </li>\r\n\r\n      <!-- Nav Item - Tables -->\r\n      <li class=\"nav-item\">\r\n        <a class=\"nav-link\" href=\"#\">\r\n          <i class=\"fas fa-fw fa-table\"></i>\r\n          <span>Tables</span></a>\r\n      </li>\r\n\r\n      <!-- Divider -->\r\n      <hr class=\"sidebar-divider d-none d-md-block\"/>\r\n\r\n      <!-- Sidebar Toggler (Sidebar) -->\r\n      <div class=\"text-center d-none d-md-inline\">\r\n        <button class=\"rounded-circle border-0\" id=\"sidebarToggle\"></button>\r\n      </div>\r\n    </ul>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

