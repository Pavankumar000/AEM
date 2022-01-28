package com.toyota.tmna.lexusdrivers.core.models;

import com.adobe.cq.export.json.ContainerExporter;
import com.adobe.cq.export.json.hierarchy.HierarchyNodeExporter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public interface HierarchyPage extends HierarchyNodeExporter, ContainerExporter {
    
    /**
     * Title of the page.
     *
     * @return
     */
     @JsonProperty("title")
     public String getTitle();

     /**
     * Css Classname of the page.
     *
     * @return
     */
    
     @JsonProperty("pageClassName")
     public String getPageClassName();

     /**
     * URL to the root model of the App
     *
     * @return
     */
     @JsonIgnore
     public String getRootUrl();

     @JsonIgnore
     public HierarchyPage getRootModel();
}