package com.toyota.tmna.lexusdrivers.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class GlobalFooterModelFailTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private   GlobalFooterModel globalFooterModel;


    @BeforeEach
    void setUp() {
        context.addModelsForClasses(GlobalFooterModel.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/GlobalFooterTestFail.json", "/contentfail");
        context.registerService(ModelFactory.class, modelFactory,
                org.osgi.framework.Constants.SERVICE_RANKING, Integer.MAX_VALUE);
        context.currentResource("/contentfail");
        globalFooterModel = context.request().adaptTo(GlobalFooterModel.class);
    }    

   
}

