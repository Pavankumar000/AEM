package com.toyota.tmna.lexusdrivers.core.util;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.day.cq.wcm.api.Page;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CommonUtilTest {
    CommonUtil commonUtil;
    @Mock
    Page currentPage;
    @Mock
    Resource resource;

    @Test
    void getItemsTest() {
        commonUtil = new CommonUtil();
        currentPage = Mockito.mock(Page.class);
        when(currentPage.getParent(1)).thenReturn(currentPage);
        when( currentPage.getContentResource()).thenReturn(resource);
        when(currentPage.getName()).thenReturn("page");
        when(currentPage.getPath()).thenReturn("path");
        when(currentPage.getName()).thenReturn("name");
        List<String> list =  commonUtil.getItems("1", currentPage, true);
        assertNotNull(list);
    }

    @Test
    void getItemsStartLevelTest() {
        commonUtil = new CommonUtil();
        currentPage = Mockito.mock(Page.class);
        List<String> list =  commonUtil.getItems(null, currentPage, true);
        assertNotNull(list);
    }

    @Test
    void getItemsPageTest() {
        commonUtil = new CommonUtil();
        currentPage = Mockito.mock(Page.class);
        List<String> list =  commonUtil.getItems("1", currentPage, true);
        assertNotNull(list);
    }

    @Test
    void getItemsContentTest() {
        commonUtil = new CommonUtil();
        currentPage = Mockito.mock(Page.class);
        when(currentPage.getParent(1)).thenReturn(currentPage);
        List<String> list =  commonUtil.getItems("1", currentPage, true);
        assertNotNull(list);
    }

    @Test
    void getItemsHiddenItemsTest() {
        commonUtil = new CommonUtil();
        currentPage = Mockito.mock(Page.class);
        when(currentPage.getParent(1)).thenReturn(currentPage);
        when( currentPage.getContentResource()).thenReturn(resource);
        when(currentPage.getName()).thenReturn("page");
        when(currentPage.getPath()).thenReturn("path");
        when(currentPage.getName()).thenReturn("name");
        List<String> list =  commonUtil.getItems("1", currentPage, false);
        assertNotNull(list);
    }
}
