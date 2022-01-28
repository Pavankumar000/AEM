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
import com.toyota.tmna.lexusdrivers.core.models.ComplementaryMaintenance;
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
    ComplementaryMaintenanceImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/cstilecomponent")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ComplementaryMaintenanceImpl extends TileComponentImpl
    implements ComplementaryMaintenance
{
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String scheduleServiceLink;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String scheduleServiceLabel;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String noServiceDataMessage;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String sixMonthsLabel;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String twelveMonthLabel;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String unitsForMonth;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String unitsForMiles;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String minUsageMonths;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String maxUsageMonths;

    @SlingObject
    private Resource resource;

    @Override
    public String getScheduleServiceLink() {
         return scheduleServiceLink;
     }
     @Override
    public String getScheduleServiceLabel() {
         return scheduleServiceLabel;
     }
     @Override
    public String getNoServiceDataMessage() {
         return noServiceDataMessage;
     }
     @Override
    public String getSixMonthsLabel() {
         return sixMonthsLabel;
     }
     @Override
    public String getTwelveMonthLabel() {
         return twelveMonthLabel;
     }
     @Override
    public String getUnitsForMonth() {
         return unitsForMonth;
     }
      @Override
    public String getUnitsForMiles() {
         return unitsForMiles;
     }
      @Override
    public String getMinUsageMonths() {
         return minUsageMonths;
     }
      @Override
    public String getMaxUsageMonths() {
         return maxUsageMonths;
     }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }


}
