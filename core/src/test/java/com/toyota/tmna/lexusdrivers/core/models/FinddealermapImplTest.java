package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.ExploredriversImpl;
import com.toyota.tmna.lexusdrivers.core.models.impl.FinddealermapImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class FinddealermapImplTest {

    FinddealermapImpl finddealermap;


    @Test
    void test(){
        finddealermap = new FinddealermapImpl();
        assertNull(finddealermap.getTitle());
        assertNull(finddealermap.getDealerLabel());
        assertNull(finddealermap.getDealerNameValidations());
        assertNull(finddealermap.getDealerPlaceholder());
        assertNull(finddealermap.getErrorMessage());
        assertNull(finddealermap.getGridIcon());
        assertNull(finddealermap.getGridLabel());
        assertNull(finddealermap.getMapIcon());
        assertNull(finddealermap.getMapLabel());
        assertNull(finddealermap.getMobileGridIcon());
        assertNull(finddealermap.getMobileMapIcon());
        assertNull(finddealermap.getNearestdealerLabel());
        assertNull(finddealermap.getSearchIcon());
        assertNull(finddealermap.getStateErrorMessage());
        assertNull(finddealermap.getStateLabel());
        assertNull(finddealermap.getStateList());
        assertNull(finddealermap.getZipCodeValidations());
        assertNull(finddealermap.getZipInputLabel());
        assertNull(finddealermap.getZipPlaceholder());
        try{
            finddealermap.getExportedType();
        } catch (NullPointerException e){}
    }
}
