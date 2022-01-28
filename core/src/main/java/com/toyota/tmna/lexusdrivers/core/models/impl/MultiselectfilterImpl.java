/*

 * ***********************************************************************

 * Lexus CONFIDENTIAL

 * ___________________

 *

 * Copyright 2019 Lexus.

 * All Rights Reserved.

 *

 * NOTICE:  All information contained herein is, and remains the property

 * of Lexus and its suppliers, if any. The intellectual and

 * technical concepts contained herein are proprietary to Lexus

 * and its suppliers and are protected by trade secret or copyright law.

 * Dissemination of this information or reproduction of this material

 * is strictly forbidden unless prior written permission is obtained

 * from Lexus.

 * ***********************************************************************

 */


package com.toyota.tmna.lexusdrivers.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Multiselectfilter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
        MultiselectfilterImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/multiselectfilter")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class MultiselectfilterImpl
    implements Multiselectfilter
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String placeholderText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String selectAllLabel;
    

    @SlingObject
    private Resource resource;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getPlaceholderText() {
        return placeholderText;
    }
    @Override
    public String getSelectAllLabel() {
        return selectAllLabel;
    }

   

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource optionsList;

	public Resource getOptionsList() {

		return optionsList;
	}
    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
