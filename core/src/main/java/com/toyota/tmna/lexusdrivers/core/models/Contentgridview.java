/*
 * 
 * ***********************************************************************
 * 
 * Lexus Drivers CONFIDENTIAL
 * 
 * ___________________
 *
 * 
 * 
 * Copyright 2019 Lexus Drivers.
 * 
 * All Rights Reserved.
 *
 * 
 * 
 * NOTICE: All information contained herein is, and remains the property
 * 
 * of Lexus Drivers and its suppliers, if any. The intellectual and
 * 
 * technical concepts contained herein are proprietary to Lexus Drivers
 * 
 * and its suppliers and are protected by trade secret or copyright law.
 * 
 * Dissemination of this information or reproduction of this material
 * 
 * is strictly forbidden unless prior written permission is obtained
 * 
 * from Lexus Drivers.
 * 
 * ***********************************************************************
 * 
 * 
 * 
 * 
 * package com.toyota.tmna.lexusdrivers.core.models;
 * 
 * import com.adobe.cq.export.json.ComponentExporter; import
 * org.osgi.annotation.versioning.ConsumerType;
 * 
 * @ConsumerType public interface Contentgridview extends ComponentExporter{
 * 
 * String getTitle();
 * 
 * }
 * 
 */

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2018 Adobe
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~     http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
package com.toyota.tmna.lexusdrivers.core.models;

import java.util.List;
import java.util.Map;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.osgi.annotation.versioning.ConsumerType;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ContainerExporter;

/**
 * A base interface to be extended by containers such as the {@link Carousel}, {@link Tabs} and {@link Accordion} models.
 *
 * @since com.adobe.cq.wcm.core.components.models 12.5.0
 */
@ConsumerType
public interface Contentgridview extends Component, ContainerExporter {

	public String getTitle();
	public String getColCountSmall();
	public String getColCountMedium();
	public String getColCountLarge();
	public Boolean getHasBorder();
	public Boolean getHasFeature();

   /**
     * @see ContainerExporter#getExportedItems()
     * @since com.adobe.cq.wcm.core.components.models 12.5.0
     */
    @NotNull
    @Override
    default Map<String, ? extends ComponentExporter> getExportedItems() {
        throw new UnsupportedOperationException();
    }

    /**
     * @see ContainerExporter#getExportedItemsOrder()
     * @since com.adobe.cq.wcm.core.components.models 12.5.0
     */
    @NotNull
    @Override
    default String @NotNull [] getExportedItemsOrder() {
        throw new UnsupportedOperationException();
    }
}
