package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.SearchPageContainerImpl;
import org.junit.jupiter.api.Test;

public class SearchPageContainerImplTest {

    SearchPageContainerImpl searchPageContainer;

    @Test
    void checkContainer() {
        searchPageContainer = new SearchPageContainerImpl();
        searchPageContainer.getTitle();
    }
}
