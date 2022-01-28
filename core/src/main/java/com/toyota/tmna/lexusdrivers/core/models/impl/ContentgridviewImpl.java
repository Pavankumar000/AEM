//ContentgridviewImpl
package com.toyota.tmna.lexusdrivers.core.models.impl;

import java.util.Map;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ContainerExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Contentgridview;
import com.toyota.tmna.lexusdrivers.core.util.ContainerUtil;
import org.jetbrains.annotations.NotNull;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { ContentgridviewImpl.class,
		ComponentExporter.class, ContainerExporter.class }, resourceType = ContentgridviewImpl.RESOURCETYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ContentgridviewImpl extends ContainerUtil implements Contentgridview {

	protected static final String RESOURCETYPE = "lexusdrivers/components/structure/ContentGridView";
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String title;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String colCountSmall;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String colCountMedium;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String colCountLarge;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Boolean hasBorder;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Boolean hasFeature;
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColCountSmall() {
		return colCountSmall;
	}

	public void setColCountSmall(String colCountSmall) {
		this.colCountSmall = colCountSmall;
	}

	public String getColCountMedium() {
		return colCountMedium;
	}

	public void setColCountMedium(String colCountMedium) {
		this.colCountMedium = colCountMedium;
	}

	public String getColCountLarge() {
		return colCountLarge;
	}

	public void setColCountLarge(String colCountLarge) {
		this.colCountLarge = colCountLarge;
	}

	public Boolean getHasBorder() {
		return hasBorder;
	}

	public void setHasBorder(Boolean hasBorder) {
		this.hasBorder = hasBorder;
	}

	public Boolean getHasFeature() {
		return hasFeature;
	}

	public void setHasFeature(Boolean hasFeature) {
		this.hasFeature = hasFeature;
	}

	public String getGridClassName() {
		return gridClassName;
	}

	public void setGridClassName(String gridClassName) {
		this.gridClassName = gridClassName;
	}

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String gridClassName;

	public @NotNull String getExportedType() {
		return super.getExportedType()+"--title:"+this.title+"--colCountSmall:"+this.colCountSmall+"--colCountMedium:"+this.colCountMedium+"--colCountLarge:"+this.colCountLarge+"--hasBorder:"+this.hasBorder+"--hasFeature:"+this.hasFeature+"--gridClassName:"+this.gridClassName;
	}



}