package com.toyota.tmna.lexusdrivers.core.models;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.components.ComponentContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Set;

public class HierarchyComponentContextWrapperTest {

    com.toyota.tmna.lexusdrivers.core.models.HierarchyComponentContextWrapper hierarchyComponentContextWrapper;

    private ComponentContext wrappedComponentContext;
    private Page hierarchyPage;

    @Test
    void checkParent(){
        hierarchyComponentContextWrapper = new com.toyota.tmna.lexusdrivers.core.models.HierarchyComponentContextWrapper(wrappedComponentContext, hierarchyPage);
        try{
            hierarchyComponentContextWrapper.getParent();
        } catch (NullPointerException e) {}
    }

    @Test
    void checkRoot(){
        hierarchyComponentContextWrapper = new com.toyota.tmna.lexusdrivers.core.models.HierarchyComponentContextWrapper(wrappedComponentContext, hierarchyPage);
        try{
            hierarchyComponentContextWrapper.getRoot();
        } catch (NullPointerException e) {}
    }

    @Test
    void checkIsRoot(){
        hierarchyComponentContextWrapper = new com.toyota.tmna.lexusdrivers.core.models.HierarchyComponentContextWrapper(wrappedComponentContext, hierarchyPage);
        try{
            hierarchyComponentContextWrapper.isRoot();
        } catch (NullPointerException e) {}
    }

    @Test
    void checkResource(){
        hierarchyComponentContextWrapper = new com.toyota.tmna.lexusdrivers.core.models.HierarchyComponentContextWrapper(wrappedComponentContext, hierarchyPage);
        try{
            hierarchyComponentContextWrapper.getResource();
        } catch (NullPointerException e) {}
    }

    @Test
    void checkCell(){
        hierarchyComponentContextWrapper = new com.toyota.tmna.lexusdrivers.core.models.HierarchyComponentContextWrapper(wrappedComponentContext, hierarchyPage);
        try{
            hierarchyComponentContextWrapper.getCell();
        } catch (NullPointerException e) {}
    }

    @Test
    void checkgetEditContext(){
        hierarchyComponentContextWrapper = new com.toyota.tmna.lexusdrivers.core.models.HierarchyComponentContextWrapper(wrappedComponentContext, hierarchyPage);
        try{
            hierarchyComponentContextWrapper.getEditContext();
        } catch (NullPointerException e) {}
    }

    @Test
    void checkAnalyzeContext(){
        hierarchyComponentContextWrapper = new com.toyota.tmna.lexusdrivers.core.models.HierarchyComponentContextWrapper(wrappedComponentContext, hierarchyPage);
        try{
            hierarchyComponentContextWrapper.getAnalyzeContext();
        } catch (NullPointerException e) {}
    }

    @Test
    void checkComponent(){
        hierarchyComponentContextWrapper = new com.toyota.tmna.lexusdrivers.core.models.HierarchyComponentContextWrapper(wrappedComponentContext, hierarchyPage);
        try{
            hierarchyComponentContextWrapper.getComponent();
        } catch (NullPointerException e) {}
    }

    @Test
    void checkPage(){
        hierarchyComponentContextWrapper = new com.toyota.tmna.lexusdrivers.core.models.HierarchyComponentContextWrapper(wrappedComponentContext, hierarchyPage);
        try{
            hierarchyComponentContextWrapper.getPage();
        } catch (NullPointerException e) {}
    }

    @Test
    void checksetAttribute(){
        hierarchyComponentContextWrapper = new com.toyota.tmna.lexusdrivers.core.models.HierarchyComponentContextWrapper(wrappedComponentContext, hierarchyPage);
        try{
            hierarchyComponentContextWrapper.setAttribute("string", new Object());
        } catch (NullPointerException e) {}
    }

    @Test
    void checkAttribute(){
        hierarchyComponentContextWrapper = new com.toyota.tmna.lexusdrivers.core.models.HierarchyComponentContextWrapper(wrappedComponentContext, hierarchyPage);
        try{
            hierarchyComponentContextWrapper.getAttribute("string");
        } catch (NullPointerException e) {}
    }

    @Test
    void checkgetCssClassNames(){
        hierarchyComponentContextWrapper = new com.toyota.tmna.lexusdrivers.core.models.HierarchyComponentContextWrapper(wrappedComponentContext, hierarchyPage);
        try{
            hierarchyComponentContextWrapper.getCssClassNames();
        } catch (NullPointerException e) {}
    }

    @Test
    void checkDecoration(){
        hierarchyComponentContextWrapper = new com.toyota.tmna.lexusdrivers.core.models.HierarchyComponentContextWrapper(wrappedComponentContext, hierarchyPage);
        try{
            hierarchyComponentContextWrapper.hasDecoration();
        } catch (NullPointerException e) {}
    }

    @Test
    void checksetDecoration(){
        hierarchyComponentContextWrapper = new com.toyota.tmna.lexusdrivers.core.models.HierarchyComponentContextWrapper(wrappedComponentContext, hierarchyPage);
        try{
            hierarchyComponentContextWrapper.setDecorate(true);
        } catch (NullPointerException e) {}
    }

    @Test
    void checkgetDecorationTagName(){
        hierarchyComponentContextWrapper = new com.toyota.tmna.lexusdrivers.core.models.HierarchyComponentContextWrapper(wrappedComponentContext, hierarchyPage);
        try{
            hierarchyComponentContextWrapper.getDecorationTagName();
        } catch (NullPointerException e) {}
    }

    @Test
    void checksetDecorationTagName(){
        hierarchyComponentContextWrapper = new com.toyota.tmna.lexusdrivers.core.models.HierarchyComponentContextWrapper(wrappedComponentContext, hierarchyPage);
        try{
            hierarchyComponentContextWrapper.setDecorationTagName("string");
        } catch (NullPointerException e) {}
    }

    @Test
    void checkgetDefaultDecorationTagName(){
        hierarchyComponentContextWrapper = new com.toyota.tmna.lexusdrivers.core.models.HierarchyComponentContextWrapper(wrappedComponentContext, hierarchyPage);
        try{
            hierarchyComponentContextWrapper.getDefaultDecorationTagName();
        } catch (NullPointerException e) {}
    }

    @Test
    void checksetDefaultDecorationTagName(){
        hierarchyComponentContextWrapper = new com.toyota.tmna.lexusdrivers.core.models.HierarchyComponentContextWrapper(wrappedComponentContext, hierarchyPage);
        try{
            hierarchyComponentContextWrapper.setDefaultDecorationTagName("string");
        } catch (NullPointerException e) {}
    }
}
