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
import com.toyota.tmna.lexusdrivers.core.models.Finddealermap;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import com.toyota.tmna.lexusdrivers.core.models.Zipinput;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
    Finddealermap.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/finddealermap")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class FinddealermapImpl
    implements Finddealermap,Zipinput
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;

     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String errorMessage;

     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String mapIcon;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String mobileGridIcon;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String mobileMapIcon;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String zipInputLabel;

     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String mapLabel;

     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String gridIcon;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String searchIcon;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String gridLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String nearestdealerLabel;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String stateLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String stateErrorMessage;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String dealerPlaceholder;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String dealerLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String zipPlaceholder;
   
    @Override
    public String getZipInputLabel() {
        return zipInputLabel;
    }

@ResourcePath(paths=ConstantsUtil.STATES_RESOURCE_PATH)
	private Resource stateList;
     
	public Resource getStateList() {
		return stateList;
	}
    @SlingObject
    private Resource resource;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getNearestdealerLabel() {
        return nearestdealerLabel;
    }
    @Override
    public String getGridLabel() {
        return gridLabel;
    }
    @Override
    public String getGridIcon() {
        return gridIcon;
    }

    @Override
    public String getMobileGridIcon() {
        return mobileGridIcon;
    }
    @Override
    public String getMobileMapIcon() {
        return mobileMapIcon;
    }


    @Override
    public String getMapLabel() {
        return mapLabel;
    }
    @Override
    public String getSearchIcon() {
        return searchIcon;
    }
    @Override
    public String getMapIcon() {
        return mapIcon;
    }
     @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String getStateLabel() {
        return stateLabel;
    }
    @Override
    public String getStateErrorMessage() {
        return stateErrorMessage;
    }

    @Override
    public String getDealerPlaceholder() {
        return dealerPlaceholder;
    }
    @Override
    public String getDealerLabel() {
        return dealerLabel;
    }
    @Override
    public String getZipPlaceholder() {
        return zipPlaceholder;
    }
   
   @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	public Resource zipCodeValidations;

	public Resource getZipCodeValidations() {
		return zipCodeValidations;
    }
    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	public Resource dealerNameValidations;

	public Resource getDealerNameValidations() {
		return dealerNameValidations;
    }
    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
