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

import com.toyota.tmna.lexusdrivers.core.models.Herobanner;
import com.toyota.tmna.lexusdrivers.core.models.Videoplayer;

import com.adobe.cq.export.json.ComponentExporter;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import javax.inject.Inject;
import org.apache.sling.models.annotations.Via;
import com.day.cq.wcm.api.Page;
import java.util.ArrayList;
import java.util.List;
import org.apache.sling.models.annotations.injectorspecific.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
        HerobannerImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/herobanner")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class HerobannerImpl extends CopypanelImpl
    implements Herobanner,Videoplayer
{
    private static final Logger log = LoggerFactory.getLogger(HerobannerImpl.class);

    @ScriptVariable
    private Page currentPage;

    @Self
    private SlingHttpServletRequest request;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String primaryCTA;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String makePrimaryCTA;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String successMessage;


    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String disclaimer;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String legalCopy;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String joinDesc;

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource tiles;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String id;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String video_type;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String video_title;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String myList;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String showInEditor;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String notApplicableMyList;
    
    @SlingObject
    private Resource resource;


 @Override
    public String getNotApplicableMyList() {
        return notApplicableMyList;
    }

     @Override
    public String getmyList() {
        return myList;
    }
     @Override
    public String getShowInEditor() {
        return showInEditor;
    }

    @Override
    public String getPrimaryCTA() {
        return primaryCTA;
    }
    @Override
    public String getMakePrimaryCTA() {
        return makePrimaryCTA;
    }
    @Override
    public String getSuccessMessage() {
        return successMessage;
    }

    @Override
    public String getDisclaimer() {
        return disclaimer;
    }
    @Override
    public String getLegalCopy() {
        return legalCopy;
    }
    

    @Override
    public String getJoinDesc() {
        return joinDesc;
    }

    public Resource getTiles() {
		return tiles;
	}
    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getVideo_type() {
        return video_type;
    }

    @Override
    public String getVideo_title() {
        return video_title;
    }
    
    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }
}
