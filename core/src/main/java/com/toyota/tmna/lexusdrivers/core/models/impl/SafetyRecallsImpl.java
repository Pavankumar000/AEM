package com.toyota.tmna.lexusdrivers.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.SafetyRecalls;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.toyota.tmna.lexusdrivers.core.util.ContainerUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { SafetyRecallsImpl.class,
        ComponentExporter.class }, resourceType = SafetyRecallsImpl.RESOURCETYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class SafetyRecallsImpl extends ContainerUtil implements SafetyRecalls {

    protected static final String RESOURCETYPE = "lexusdrivers/components/structure/SafetyRecalls";

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
    private Resource safetyLinks;

    @Override
    public String getTitle() {
        return title;
    }

    public Resource getSafetyLinks() {
        return safetyLinks;
    }
}
