package com.toyota.tmna.lexusdrivers.core.util;

public class ConstantsUtil {
	public static final String SLASH="/";
    public static final String COVERAGE="paramter to pass coverage";
    public static final String APPS_PATH= "/apps/";
    public static final String LOGGED_IN="LoggedIn";


    /* Global Footer*/
    public static final String GLOBAL_FOOTER_RESOURCE = "lexusdrivers/components/content/globalfooter";
    public static final String GLOBAL_FOOTER_SELECTOR = "footer";
    public static final String GF_COLUMN_HEADLINE = "footerColumnHeadline";
    
    public static final String GLOBAL_FOOTER_LINK="footerlinks";
    public static final String GLOBAL_FOOTER_LINKS_PATH = SLASH + GLOBAL_FOOTER_LINK;
    public static final String GLOBAL_FOOTER_LINKLIST="linklist";
    public static final String GF_LINK_TARGET_URL = "linktargeturl";
    public static final String GF_LINK_TITLE = "linktitle";
    public static final String GF_OPEN_NEW="openinnew";
    public static final String GF_THIRD_PARTY_ICON="thirdpartyicon";

    public static final String GF_LINKS_URLS="linksUrl";
    public static final String GF_LINKS_TITLE = "linkstitle";
    public static final String REFERER = "referer";
    
    public static final String DISCLAIMERS_PATH = "/content/dam/lexusdrivers/content-fragments/disclaimers/";
    public static final String DISCLAIMERS_MASTER_NODE = "/jcr:content/data/master";
    public static final String DISCLAIMERS_ID = "disclaimersID";
    public static final String DISCLAIMERS_DESCRIPTION = "Description";
    public static final String HERO_BANNER_CF = "/content/dam/lexusdrivers/content-fragments/herobanner";
    

    /* Display Message*/

    public static final String DISPLAY_MESSAGE_RESOURCE = "lexusdrivers/components/content/displayMessage";

    /* Forgot Password Message*/

    public static final String FP_RESOURCE_FOLDER = "lexusdrivers/components/content/"; //HF SA:03/05/2020 Security issue

    /* Global Navigation Message*/

    public static final String GNAV_MESSAGE_RESOURCE = "lexusdrivers/components/content/globalNav";

    /* HeaderConfiguration */

    public static final String URL_SERVICE_PID = "com.toyota.tmna.lexusdrivers.core.factory.HeaderFactoryEndPoints";
    public static final String EOSPUBLIC = "eospublic";

    public static final String X_EOS_API_KEY = "eosApiKey";

    public static final String DCS3 = "dcs3";

    public static final String X_DCS_API_KEY = "dcsApiKey";


    public static final String CONFIG_PATH= "lexusdrivers/components/content/config";

    public static final String COMPO_PATH = SLASH + "jcr:content/root/responsivegrid";

    public static final String RESPONSE_APPLICATION_JSON = "application/json";
    public static final String RESPONSE_CHARACTER_CODE = "UTF-8";
    
    public static final String STATES_RESOURCE_PATH = "/content/lexusdrivers/us/en/configuration/states/jcr:content/root/responsivegrid/stateconfiguration/multilist";
    public static final String SERVLET_RESOURCE_TYPE = "lexusdrivers/components/structure/spa-page";
    public static final String SERVLET_RESOURCE_TYPE_DROPDOWN = "/bin/dropdownds";
    public static final String SERVLET_EXTENSIONS = "html";
    public static final String SERVLET_EXTENSIONS_USERINFO = "html";
    public static final String USER_INFO = "userinfo";
    
    public static final String ID_TOKEN = "id_token";
    public static final String LAST_VIEWED_CARS_TOKEN = "last-viewed-cars";
    public static final String DROPDOWN_GENERIC_PATH = "lexusdrivers/components/core/content/dropdownlists/v1/";

    public static final String FIRST_NAME= "firstName";
    public static final String LAST_NAME= "lastName";
    public static final String EMAIL= "email";
    public static final String ID_TOKEN_JSON = "idToken";
    public static final String SIGN_IN_TYPE= "signinType";
    
    public static final String CPID= "CPID";
    public static final String CP_PATH= "/content/dam/lexusdrivers/content-fragments/communicationpreferences/";
    public static final String CP_MASTER_NODE="/jcr:content/data/master";
    
    public static final String LPSID= "LPSID";
    public static final String LPS_PATH= "/content/dam/lexusdrivers/content-fragments/lps/";
    public static final String LP_MASTER_NODE="jcr:content/data/master";

    //cloud search constants

    public static final String  STORIES_SECONDARY_DESCRIPTION= "/jcr:content/root/responsivegrid/ExperiencePageview/richtextwrapper0";
    public static final String  STORIES_ROTATIONAL_BANNER_IMAGE = "/jcr:content/root/responsivegrid/ExperiencePageview/herobanner/tiles";
    public static final String  STORIES_WRAPPER = "/jcr:content/root/responsivegrid/ExperiencePageview/wrapper";
    public static final String  REWARDS_WRAPPER = "/jcr:content/root/responsivegrid/rewardspageview/wrapper";
    public static final String  VIDEOS_WRAPPER ="/jcr:content/root/responsivegrid/videospageview/wrapper";
    public static final String  REWARDS_ROTATIONAL_BANNER_IMAGE = "/jcr:content/root/responsivegrid/rewardspageview/herobanner/tiles";
}
