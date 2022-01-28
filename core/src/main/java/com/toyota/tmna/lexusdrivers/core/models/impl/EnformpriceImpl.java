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

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Enformprice;
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
    Enformprice.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/enformprice")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class EnformpriceImpl
    implements Enformprice
{


    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String additionalYearsLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String dealerLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String msrpUnitValue;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String msrpLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String yearlyUnitValue;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String yearlyLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String monthlyUnitValue;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String monthlyLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String priceType;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String cardTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String cardDescription;



    @SlingObject
    private Resource resource;

     @Override
    public String getCardDescription() {
        return cardDescription;
    }
     @Override
    public String getCardTitle() {
        return cardTitle;
    }

     @Override
    public String getAdditionalYearsLabel() {
        return additionalYearsLabel;
    }
     @Override
    public String getDealerLabel() {
        return dealerLabel;
    }
     @Override
    public String getMsrpUnitValue() {
        return msrpUnitValue;
    }
     @Override
    public String getMsrpLabel() {
        return msrpLabel;
    }
     @Override
    public String getYearlyUnitValue() {
        return yearlyUnitValue;
    }


    @Override
    public String getYearlyLabel() {
        return yearlyLabel;
    }

@Override
    public String getMonthlyUnitValue() {
        return monthlyUnitValue;
    }

@Override
    public String getMonthlyLabel() {
        return monthlyLabel;
    }

    @Override
    public String getPriceType() {
        return priceType;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
