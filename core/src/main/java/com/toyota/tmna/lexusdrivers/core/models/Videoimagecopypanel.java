package com.toyota.tmna.lexusdrivers.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface Videoimagecopypanel extends ComponentExporter {

	
	String getAssetsource();
	
	String getTextplacement();

	String getAssetType();

	String getArticleType();

    String getMyList();

	String getNotApplicableMyList();
	
	String getShowCTA();

}
