package com.toyota.tmna.lexusdrivers.core.search.services.impl;

import com.toyota.tmna.lexusdrivers.core.search.services.WaldoConfigs;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.toyota.tmna.lexusdrivers.core.factory.IFactory;

import java.io.IOException;

public class WaldoServiceImplTest {

    @InjectMocks
    transient WaldoServiceImpl waldoService;
    @Mock
    WaldoConfigs config;
    @Mock
    IFactory iFactory;


    @Test
    void getLatLang() throws IOException {
        try {
            String test = waldoService.getLatlang("latLang");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void getZip() throws IOException {
        try {
            String test = waldoService.getZip("lat", "lang");
        } catch (NullPointerException e) {

        }
    }

    @Test
    void getState() throws IOException {
        try {
            waldoService.getState("zip");
        } catch (NullPointerException e) {

        }
    }
}
