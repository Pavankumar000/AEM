package com.toyota.tmna.lexusdrivers.core.models;

import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppConfigTest {

    AppConfig appConfig;

    @Test
    public void getServiceResponsesExceptionTest(){
        appConfig = new AppConfig();
        try {
            appConfig.getServiceResponses();
        } catch (Exception e){
            Assert.assertNull(appConfig);
        }
    }

    @Test
    public void getLegacyModelFilterExceptionTest(){
        appConfig = new AppConfig();
        try {
            appConfig.getLegacyModelFilter();
        } catch (Exception e){
            Assert.assertNull(appConfig);
        }
    }

    @Test
    public void getFuelGradesExceptionTest(){
        appConfig = new AppConfig();
        try {
            appConfig.getFuelGrades();
        } catch (Exception e){
            Assert.assertNull(appConfig);
        }
    }

    @Test
    public void getMyFilterExceptionTest(){
        appConfig = new AppConfig();
        try {
            appConfig.getMyFilter();
        } catch (Exception e){
            Assert.assertNull(appConfig);
        }
    }

    @Test
    public void getLdNavSearchExceptionTest(){
        appConfig = new AppConfig();
        try {
            appConfig.getLdNavSearch();
        } catch (Exception e){
            Assert.assertNull(appConfig);
        }
    }

    @Test
    public void getFsportFilterExceptionTest(){
        appConfig = new AppConfig();
        try {
            appConfig.getFsportFilter();
        } catch (Exception e){
            Assert.assertNull(appConfig);
        }
    }








}
