
package com.toyota.tmna.lexusdrivers.core.models.impl;
import java.util.Map;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Manualspageview;
import com.toyota.tmna.lexusdrivers.core.models.SearchPageView;
import com.toyota.tmna.lexusdrivers.core.util.ContainerUtil;
import org.jetbrains.annotations.NotNull;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { SearchPageViewImpl.class,
		ComponentExporter.class }, resourceType = SearchPageViewImpl.RESOURCETYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class SearchPageViewImpl extends ContainerUtil  implements SearchPageView {
	
	protected static final String RESOURCETYPE = "lexusdrivers/components/structure/searchPageView";
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String topsearch;
	
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String pagination;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String searchtip;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String noresults;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String viewfewmodels;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String viewmoremodels;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String gallerytitle;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String searchtipdescription;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String baseurl;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String generalicon;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String pdficon;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String searchurl;
	
	
	public String @NotNull [] getExportedItemsOrder() {
		return super.getExportedItemsOrder();
	}

	public @NotNull Map<String, ? extends ComponentExporter> getExportedItems() {
		 return super.getExportedItems();
	}

	public @NotNull String getExportedType() {
		return super.getExportedType();
	}

	@Override
	public String getTopsearch() {
		return topsearch;
	}
	@Override
	public String getPagination() {
		return pagination;
	}

	public void setPagination(String pagination) {
		this.pagination = pagination;
	}
	@Override
	public String getSearchtip() {
		return searchtip;
	}

	public void setSearchtip(String searchtip) {
		this.searchtip = searchtip;
	}
	@Override
	public String getNoresults() {
		return noresults;
	}

	public void setNoresults(String noresults) {
		this.noresults = noresults;
	}
	@Override
	public String getViewfewmodels() {
		return viewfewmodels;
	}

	public void setViewfewmodels(String viewfewmodels) {
		this.viewfewmodels = viewfewmodels;
	}
	@Override
	public String getViewmoremodels() {
		return viewmoremodels;
	}

	public void setViewmoremodels(String viewmoremodels) {
		this.viewmoremodels = viewmoremodels;
	}
	@Override
	public String getGallerytitle() {
		return gallerytitle;
	}

	public void setGallerytitle(String gallerytitle) {
		this.gallerytitle = gallerytitle;
	}
	@Override
	public String getSearchtipdescription() {
		return searchtipdescription;
	}

	public void setSearchtipdescription(String searchtipdescription) {
		this.searchtipdescription = searchtipdescription;
	}
	@Override
	public String getBaseurl() {
		return baseurl;
	}

	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}
	
	@Override
	public String getGeneralicon() {
		return generalicon;
	}

	public void setGeneralicon(String generalicon) {
		this.generalicon = generalicon;
	}
	@Override
	public String getPdficon() {
		return pdficon;
	}

	public void setPdficon(String pdficon) {
		this.pdficon = pdficon;
	}
	@Override
	public String getSearchurl() {
		return searchurl;
	}

	public void setSearchurl(String searchurl) {
		this.searchurl = searchurl;
	}

	
	public void setTopsearch(String topsearch) {
		this.topsearch = topsearch;
	}

	
	

}