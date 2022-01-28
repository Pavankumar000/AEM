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
import org.apache.sling.api.resource.Resource;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Vehiclehealthreport;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
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
    Vehiclehealthreport.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/vehiclehealthreport")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class VehiclehealthreportImpl
    implements Vehiclehealthreport
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String healthReportLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String healthHistoryLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String transmissionMsg;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String noTransmissionMsg;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String questionData;


    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String countLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String alertTitle;


    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String caption;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String resultsLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String milesDrivenDate;


     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String healthReportTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String pdfLabel;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String refreshLabel;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String timeStampMsg;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String infoDisclaimer;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String zeroAlerts;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vhrImage;





    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getHealthReportLabel() {
        return healthReportLabel;
    }

    @Override
    public String getVhrImage() {
        return vhrImage;
    }

    @Override
    public String getZeroAlerts() {
        return zeroAlerts;
    }

    @Override
    public String getHealthHistoryLabel() {
        return healthHistoryLabel;
    }

    @Override
    public String getTransmissionMsg() {
        return transmissionMsg;
    }
     @Override
    public String getQuestionData() {
        return questionData;
    }

      @Override
    public String getNoTransmissionMsg() {
        return noTransmissionMsg;
    }



     @Override
    public String getCountLabel() {
        return countLabel;
    }
     @Override
    public String getAlertTitle() {
        return alertTitle;
    }


    @Override
    public String getCaption() {
        return caption;
    }
    @Override
    public String getResultsLabel() {
        return resultsLabel;
    }
    @Override
    public String getMilesDrivenDate() {
        return milesDrivenDate;
    }



    @Override
    public String getHealthReportTitle() {
        return healthReportTitle;
    }
    @Override
    public String getPdfLabel() {
        return pdfLabel;
    }
    @Override
    public String getRefreshLabel() {
        return refreshLabel;
    }
    @Override
    public String getTimeStampMsg() {
        return timeStampMsg;
    }
    @Override
    public String getInfoDisclaimer() {
        return infoDisclaimer;
    }

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource toolCards;

	public Resource getToolCards() {

		return toolCards;
    }
    
    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource popoverData;

	public Resource getPopoverData() {

		return popoverData;
	}


    
	@SlingObject
	private Resource resource;

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
