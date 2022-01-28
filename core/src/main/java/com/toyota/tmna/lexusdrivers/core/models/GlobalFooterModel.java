package com.toyota.tmna.lexusdrivers.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.inject.Inject;

@Model(adaptables = SlingHttpServletRequest.class, resourceType = GlobalFooterModel.RESOURCE_TYPE, adapters = {
        GlobalFooterModel.class,
        ComponentExporter.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, selector = ConstantsUtil.GLOBAL_FOOTER_SELECTOR, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class GlobalFooterModel implements ComponentExporter {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalFooterModel.class);
    protected static final String RESOURCE_TYPE = ConstantsUtil.GLOBAL_FOOTER_RESOURCE;

    @SlingObject
    private
    SlingHttpServletRequest req;

    @ValueMapValue(name = "headline")
    private String headline;
    @ValueMapValue(name = "headPathOpennewwindow")
    private String headPathOpennewwindow;
    @ValueMapValue(name = "copyopennewwindow")
    private String copyopennewwindow;
    @ValueMapValue(name = "copyRightText")
    private String copyRightText;
    @ValueMapValue(name = "headlinePath")
    private String headlinePath;
    @ValueMapValue(name = "copyRightLink")
    private String copyRightLink;
    @ValueMapValue(name = "copyRightDesc")
    private String copyRightDesc;

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource socialLinks;
	@ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource mainMenuLinks;
	@ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource navigationLinks;

    @Inject
    @Via("resource")
    private Resource footercolumns;
	
    public void setFootercolumns(Resource footercolumns) {
        this.footercolumns = footercolumns;
    }

    @Inject
    @Via("resource")
    private Resource footercolumnsTwo;

    
    public String getCopyopennewwindow() {
        return copyopennewwindow;
    }

    public String getHeadPathOpennewwindow() {
        return headPathOpennewwindow;
    }

    public String getCopyRightDesc() {
        return copyRightDesc;
    }
 public String getCopyRightText() {
        return copyRightText;
    }
    public String getHeadlinePath() {
        return headlinePath;
    }

    public String getHeadline() {
        return headline;
    }

    public String getCopyRightLink() {
        return copyRightLink;
    }
	 
	 public Resource getSocialLinks() {
		return socialLinks;
	}
	 public Resource getMainMenuLinks() {
		return mainMenuLinks;
	}
	 public Resource getNavigationLinks() {
		return navigationLinks;
	}

    @Nonnull
    @Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }
}
