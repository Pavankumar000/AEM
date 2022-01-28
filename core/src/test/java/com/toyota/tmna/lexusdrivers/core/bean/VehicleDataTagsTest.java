package com.toyota.tmna.lexusdrivers.core.bean;

import io.wcm.testing.mock.aem.junit5.AemContext;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class VehicleDataTagsTest {

        private  VehicleDataTags vehicleDataTags;
        MockSlingHttpServletRequest mockSlingHttpServletRequest;
        private final AemContext context = new AemContext();
        final String PARAM_YEAR = "year";
        final String PARAM_MODEL = "model";
        final String PARAM_CODE = "code";
        final String PARAM_TRIM = "trim";

        @BeforeEach
        public void setUp() throws Exception {

            mockSlingHttpServletRequest = context.request();
            mockSlingHttpServletRequest.addRequestParameter(PARAM_YEAR, PARAM_YEAR);
            mockSlingHttpServletRequest.addRequestParameter(PARAM_MODEL, PARAM_MODEL);
            mockSlingHttpServletRequest.addRequestParameter(PARAM_CODE, PARAM_CODE);
            mockSlingHttpServletRequest.addRequestParameter(PARAM_TRIM, PARAM_TRIM);
            vehicleDataTags = new VehicleDataTags("", mockSlingHttpServletRequest);

            vehicleDataTags.setCfPath("cfPath");
            vehicleDataTags.setCfBannerPath("cfBannerPath");
            vehicleDataTags.setTrim("trim");
            vehicleDataTags.setTagFolderExists(true);
            vehicleDataTags.setTagFolderExistsVHR(true);



    }

        @Test
        void getFirstName() {
        String expected = "cfPath";
        String actual = vehicleDataTags.getCfPath();
        assertEquals(expected, actual);
    }

        @Test
        void getLastName() {
        String expected = "cfBannerPath";
        String actual = vehicleDataTags.getCfBannerPath();
        assertEquals(expected, actual);
    }

        @Test
        void getSigninType() {
        String expected = "trim";
        String actual = vehicleDataTags.getTrim();
        assertEquals(expected, actual);
    }

    @Test
    void getTagFolderExistsVHR() {
        Boolean expected = Boolean.TRUE;
        Boolean actual = vehicleDataTags.isTagFolderExistsVHR();
        assertEquals(expected, actual);
    }

    @Test
    void getTagFolderExists() {
        Boolean expected = Boolean.TRUE;
        Boolean actual = vehicleDataTags.isTagFolderExists();
        assertEquals(expected, actual);
    }

    @Test
    void getEmptyFileds() {
        String tag = vehicleDataTags.getTag();
        String modelTag = vehicleDataTags.getModelTag();
        String sportsTag = vehicleDataTags.getFsportsTag();
        String defaultTag = vehicleDataTags.getDefaultTag();
    }


    @Test
    void paramDataForMultipleVehiclesTwoLenModel(){
        final String FSPORT = "-fsport";
        final String FSPORT_2 = "-FSport";
        final String FSPORT_3 = "-Fsport";
        mockSlingHttpServletRequest = context.request();
        mockSlingHttpServletRequest.addRequestParameter(PARAM_YEAR, PARAM_YEAR);
        mockSlingHttpServletRequest.addRequestParameter(PARAM_MODEL, PARAM_MODEL);
        mockSlingHttpServletRequest.addRequestParameter(PARAM_CODE, PARAM_CODE);
        mockSlingHttpServletRequest.addRequestParameter(PARAM_TRIM, PARAM_TRIM);
        vehicleDataTags = new VehicleDataTags("year:year;model:ch;code:code;trim:trim", mockSlingHttpServletRequest);
    }

    @Test
    void paramDataForMultipleVehiclesHModel(){
        final String FSPORT = "-fsport";
        final String FSPORT_2 = "-FSport";
        final String FSPORT_3 = "-Fsport";
        MockSlingHttpServletRequest slingHttpServletRequest;
        slingHttpServletRequest = context.request();
        slingHttpServletRequest.addRequestParameter(PARAM_YEAR, PARAM_YEAR);
        slingHttpServletRequest.addRequestParameter(PARAM_MODEL, "cth2016");
        slingHttpServletRequest.addRequestParameter(PARAM_CODE, PARAM_CODE);
        slingHttpServletRequest.addRequestParameter(PARAM_TRIM, PARAM_TRIM);
        vehicleDataTags = new VehicleDataTags("year:year;model:cth2016;code:code;trim:trim", slingHttpServletRequest);
    }

    @Test
    void testSetters(){
        final String FSPORT = "-fsport";
        final String FSPORT_2 = "-FSport";
        final String FSPORT_3 = "-Fsport";
        mockSlingHttpServletRequest = context.request();
        vehicleDataTags.setCFBanner("bannerModelValue", new StringBuilder(), "2020", "");
        vehicleDataTags.setCFBanner("bannerModelValue", new StringBuilder(), "", "");
        vehicleDataTags.toString();
        vehicleDataTags.setTagFolders(mockSlingHttpServletRequest,"", "model");
        vehicleDataTags.setTagFolders(mockSlingHttpServletRequest,"2021", "model");
        AemContext context2 = new AemContext();
        MockSlingHttpServletRequest mockSlingHttpServletRequestNull = context2.request();;
        mockSlingHttpServletRequestNull.addRequestParameter(PARAM_YEAR, null);
        mockSlingHttpServletRequestNull.addRequestParameter(PARAM_MODEL, null);
        mockSlingHttpServletRequestNull.addRequestParameter(PARAM_CODE, null);
        mockSlingHttpServletRequestNull.addRequestParameter(PARAM_TRIM, null);
        vehicleDataTags.setFSportTag(new StringBuilder(), new StringBuilder(), FSPORT, PARAM_MODEL);
        vehicleDataTags.setFSportTag(new StringBuilder(), new StringBuilder(), FSPORT_2, PARAM_MODEL);
        vehicleDataTags.setFSportTag(new StringBuilder(), new StringBuilder(), FSPORT_3, PARAM_MODEL);
        vehicleDataTags.setParameterData(mockSlingHttpServletRequestNull);
    }

    @Test
    void checkHTmodelTCheck(){
        String HTModel = vehicleDataTags.checkHTmodel( "cft016");
        assertEquals("cft016", HTModel);
    }

    @Test
    void checkHTmodelTCheck2(){
        String HTModel = vehicleDataTags.checkHTmodel( "ctt2016");
        assertEquals("cTt2016",HTModel);
    }

    @Test
    void checkHTmodelHCheck(){
        String HTModel = vehicleDataTags.checkHTmodel( "hth2016");
        assertEquals("Hth2016", HTModel);
    }

    @Test
    void setCFDataTest(){
        vehicleDataTags.setCFData( "hth2016","2021", "ctt",
                "bannerModelValue", "code", new StringBuilder(), new StringBuilder());
    }

    @Test
    void setCFDataTestH(){
        vehicleDataTags.setCFData( "hth2016","2021", "cth",
                "bannerModelValue", "code", new StringBuilder(), new StringBuilder());
    }

    @Test
    void setCFandBannerModel(){
        final String SAMPLE_MODEL = "CTH 2000";
        final String SAMPLE_MODEL_2 = "CTt";
        final String SAMPLE_MODEL_3 = "hhh 2000";
        final String SAMPLE_MODEL_4 = "hh";
        vehicleDataTags.setCFandBannerModel(PARAM_MODEL, new StringBuilder(), PARAM_MODEL);
        vehicleDataTags.setCFandBannerModel(SAMPLE_MODEL, new StringBuilder(), SAMPLE_MODEL);
        vehicleDataTags.setCFandBannerModel(SAMPLE_MODEL_2, new StringBuilder(), SAMPLE_MODEL_2);
        vehicleDataTags.setCFandBannerModel(SAMPLE_MODEL_3, new StringBuilder(), SAMPLE_MODEL_3);
        vehicleDataTags.setCFandBannerModel(SAMPLE_MODEL_4, new StringBuilder(), SAMPLE_MODEL_4);
    }

}

