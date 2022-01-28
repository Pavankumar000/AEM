/*

 * ***********************************************************************

 * Lexus Drivers CONFIDENTIAL

 * ___________________

 *

 * Copyright 2019 Lexus Drivers.

 * All Rights Reserved.

 *

 * NOTICE:  All information contained herein is, and remains the property

 * of Lexus Drivers and its suppliers, if any. The intellectual and

 * technical concepts contained herein are proprietary to Lexus Drivers

 * and its suppliers and are protected by trade secret or copyright law.

 * Dissemination of this information or reproduction of this material

 * is strictly forbidden unless prior written permission is obtained

 * from Lexus Drivers.

 * ***********************************************************************

 */


package com.toyota.tmna.lexusdrivers.core.models.impl;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;
import com.adobe.cq.export.json.ComponentExporter;
import com.toyota.tmna.lexusdrivers.core.models.Panelfilter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Zipinput;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
    Panelfilter.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/panelfilter")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class PanelfilterImpl  implements Panelfilter,Zipinput
{
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String filterType;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String selectAllLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String viewLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String selectedLabel;


    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String nonUsaError;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String invalidError;


     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String searchIcon;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String gridIcon;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String listIcon;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String allTypes;

     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String allVideoTypes;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String searchPlaceholder;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String zipInputLabel;
    
    @SlingObject
    private Resource resource;


    @ResourcePath(paths=ConstantsUtil.STATES_RESOURCE_PATH)
	private Resource stateList;
     
	public Resource getStateList() {
		return stateList;
	}

     @Override
    public String getSearchPlaceholder() {
        return searchPlaceholder;
    }
     @Override
    public String getAllVideoTypes() {
        return allVideoTypes;
    }

    @Override
    public String getAllTypes() {
        return allTypes;
    }

   @Override
    public String getTitle() {
        return title;
    }

     @Override
    public String getSelectAllLabel() {
        return selectAllLabel;
    }
     @Override
    public String getViewLabel() {
        return viewLabel;
    }
     @Override
    public String getSelectedLabel() {
        return selectedLabel;
    }
     @Override
    public String getFilterType() {
        return filterType;
    }

     @Override
    public String getInvalidError() {
        return invalidError;
    }
     @Override
    public String getNonUsaError() {
        return nonUsaError;
    }

    @Override
    public String getListIcon() {
        return listIcon;
    }
    @Override
    public String getSearchIcon() {
        return searchIcon;
    }
    @Override
    public String getGridIcon() {
        return gridIcon;
    }   

    @Override
    public String getZipInputLabel() {
        return zipInputLabel;
    }

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource videoTypesList;
	public Resource getVideoTypesList() {
		return videoTypesList;
	}

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource extraEventsList;
	public Resource getExtraEventsList() {
		return extraEventsList;
	}

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource rewardsEventsTypesList;
	public Resource getRewardsEventsTypesList() {
		return rewardsEventsTypesList;
	}

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	public Resource zipCodeValidations;
	public Resource getZipCodeValidations() {
		return zipCodeValidations;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
