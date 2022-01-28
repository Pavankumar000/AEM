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
import com.toyota.tmna.lexusdrivers.core.models.Copypanel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
    CopypanelImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/copypanel")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class CopypanelImpl
    implements Copypanel
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String title;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String showTitleasLink;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String showHeaderasLink;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String description;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String icon;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String type;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String alignment;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String ctaLink;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String ctatext;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String hasDividerLine;
	
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	public String image;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	public String video;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	public String extrapadding;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	public String header;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String imagealt;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String ctatype;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String cssClassName;

	
    @SlingObject
    public Resource resource;

    @Override
    public String getTitle() {
        return title;
    }
     @Override
    public String getShowTitleInasLink() {
        return showTitleasLink;
    }
     @Override
    public String getShowHeaderasLink() {
        return showHeaderasLink;
    }
     
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String richTextTitle;
    
    @Override
    public String getRichTextTitle() {
        return richTextTitle;
    }

    
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String joinDesc;
    
    @Override
    public String getJoinDesc() {
        return joinDesc;
    }

    @Override
    public String getDescription() {
        return description;
    }


    @Override
    public String getCtatype() {
        return ctatype;
    }

    @Override
    public String getIcon() {
        return icon;
    }

    @Override
    public String getType() {
        return type;
    }


    @Override
    public String getAlignment() {
        return alignment;
    }

    @Override
    public String getCtaLink() {
        return ctaLink;
    }

    @Override
    public String getCtatext() {
        return ctatext;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }
	@Override
	public String getHasDividerLine() {
		return hasDividerLine;
	}
	@Override
	public String getImage() {
		return image;
	}

	@Override
	public String getVideo() {
		return video;
	}

	@Override
	public String getExtrapadding() {
		return extrapadding;
	}

	@Override
	public String getHeader() {
		return header;
	}

	@Override
	public String getImagealt() {
		return imagealt;
	}

    @Override
	public String getCssClassName() {
		return cssClassName;
	}
}
