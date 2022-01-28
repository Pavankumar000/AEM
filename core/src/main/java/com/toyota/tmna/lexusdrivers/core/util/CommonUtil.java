package com.toyota.tmna.lexusdrivers.core.util;

import com.day.cq.wcm.api.Page;
import com.toyota.tmna.lexusdrivers.core.models.impl.HerobannerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CommonUtil {
    private static final Logger log = LoggerFactory.getLogger(CommonUtil.class);

    public List<String> getItems(String startLevel, Page currentPage, Boolean showHiddenItems) {
        log.info("Retrieving data from CommonUtils", startLevel , currentPage, showHiddenItems);
        List<String> items = new ArrayList();
        if(startLevel != null) {
            Integer starLevelInt = Integer.parseInt(startLevel);
            Page page = currentPage.getParent(starLevelInt);
            if (page != null && page.getContentResource() != null) {
                if (checkIfNotHidden(page, showHiddenItems)) {
                    String headerRibbon = page.getName().replaceAll("-", " ");
                    String headerRibbonLink = page.getPath();
                    String menuLabel = currentPage.getName().replaceAll("-", " ");
                    items.add(headerRibbon);
                    items.add(headerRibbonLink);
                    items.add(menuLabel);
                    log.info("Breadcrumbs", items);
                }
            }
        }
        return items;
    }

    private boolean checkIfNotHidden(Page page, Boolean showHiddenItems) {
        return !page.isHideInNav() || showHiddenItems;
    }
}
