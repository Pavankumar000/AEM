package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.TechnologyCarouselImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class TechnologyCarouselImplTest {

    TechnologyCarouselImpl technologyCarousel;

    @Test
    void checkContainer() {
        technologyCarousel = new TechnologyCarouselImpl();
        assertNull(technologyCarousel.getTitle());
    }


}
