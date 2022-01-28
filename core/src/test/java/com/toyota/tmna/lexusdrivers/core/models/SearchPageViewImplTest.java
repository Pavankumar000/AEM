package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.SearchPageViewImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchPageViewImplTest {

    SearchPageViewImpl searchPageView;

    @Test
    void checkContainer(){
        searchPageView = new SearchPageViewImpl();
        searchPageView.setBaseurl("baseUrl");
        searchPageView.setGallerytitle("galleryTitle");
        searchPageView.setGeneralicon("genIcon");
        searchPageView.setNoresults("noResults");
        searchPageView.setPagination("pagination");
        searchPageView.setPdficon("pdfIcon");
        searchPageView.setSearchtip("searchTip");
        searchPageView.setSearchtipdescription("searchTipDesc");
        searchPageView.setSearchurl("searchUrl");
        searchPageView.setTopsearch("topSearch");
        searchPageView.setViewfewmodels("viewModels");
        searchPageView.setViewmoremodels("viewMoreModels");
        assertEquals("baseUrl", searchPageView.getBaseurl());
        assertEquals("galleryTitle", searchPageView.getGallerytitle());
        assertEquals("genIcon", searchPageView.getGeneralicon());
        assertEquals("noResults", searchPageView.getNoresults());
        assertEquals("pagination", searchPageView.getPagination());
        assertEquals("pdfIcon", searchPageView.getPdficon());
        assertEquals("searchTip", searchPageView.getSearchtip());
        assertEquals("searchTipDesc", searchPageView.getSearchtipdescription());
        assertEquals("searchUrl", searchPageView.getSearchurl());
        assertEquals("topSearch", searchPageView.getTopsearch());
        assertEquals("viewModels", searchPageView.getViewfewmodels());
        assertEquals("viewMoreModels", searchPageView.getViewmoremodels());
        assertNotNull(searchPageView.getExportedItems());
        assertNotNull(searchPageView.getExportedItemsOrder());
        try{
            searchPageView.getExportedType();
        } catch(NullPointerException e){}

    }
}
