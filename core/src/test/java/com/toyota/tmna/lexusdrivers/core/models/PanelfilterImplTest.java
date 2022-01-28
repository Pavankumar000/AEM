package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.PanelfilterImpl;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

public class PanelfilterImplTest {

    PanelfilterImpl panelfilter;

    @Test
    void checkContainer() {
        panelfilter = new PanelfilterImpl();
        panelfilter.getTitle();
        panelfilter.getAllTypes();
        panelfilter.getAllVideoTypes();
        panelfilter.getExtraEventsList();
        panelfilter.getFilterType();
        panelfilter.getGridIcon();
        panelfilter.getInvalidError();
        panelfilter.getListIcon();
        panelfilter.getNonUsaError();
        panelfilter.getRewardsEventsTypesList();
        panelfilter.getSearchIcon();
        panelfilter.getSearchPlaceholder();
        panelfilter.getSelectAllLabel();
        panelfilter.getSelectedLabel();
        panelfilter.getStateList();
        panelfilter.getVideoTypesList();
        panelfilter.getViewLabel();
        panelfilter.getZipCodeValidations();
        panelfilter.getZipInputLabel();
        try{
            panelfilter.getExportedType();
        } catch (NullPointerException e){}
    }
}
