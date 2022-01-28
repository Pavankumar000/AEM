package com.toyota.tmna.lexusdrivers.core.models.impl;

import javax.inject.Inject;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.TileComponent;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { TileComponentImpl.class,
		ComponentExporter.class }, resourceType = "lexusdrivers/components/content/tiles")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class TileComponentImpl implements TileComponent {

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String tiletitle;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String titleicon;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String iconerrormsg;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String erromsg;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String mediumTileMessage;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String smallTileMessage;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String errorctalabel;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String errorctalink;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String type;
	@ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
    private Resource tilesList;
	@SlingObject
	private Resource resource;

	@Override
	public String getExportedType() {
		return resource.getResourceType();
	}

	@Override
	public String getTiletitle() {
		return tiletitle;
	}

	@Override
	public String getTitleicon() {
		return titleicon;
	}

	@Override
	public String getIconerrormsg() {
		return iconerrormsg;
	}

	@Override
	public String getErromsg() {
		return erromsg;
	}

	@Override
	public String getMediumTileMessage() {
		return mediumTileMessage;
	}

	@Override
	public String getSmallTileMessage() {
		return smallTileMessage;
	}


	@Override
	public String getErrorctalabel() {
		return errorctalabel;
	}

	@Override
	public String getErrorctalink() {
		return errorctalink;
	}
	

	public Resource getTilesList() {
		return tilesList;
	}

	@Override
	public String getType() {
		return type;
	}
	

}