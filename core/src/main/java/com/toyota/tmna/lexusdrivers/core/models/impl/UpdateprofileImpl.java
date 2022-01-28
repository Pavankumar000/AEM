/*

 * ***********************************************************************

 * Lexus Drivers CONFIDENTIAL

 * ___________________

 *

 * Copyright 2019 Lexus Drivers.

 * All Rights Reserved.

 *

 * NOTICE:  All information contained herein is, and remains the property

 * of Lexus Drivers and its suppliers, if any. The intellectual and

 * technical concepts contained herein are proprietary to Lexus Drivers

 * and its suppliers and are protected by trade secret or copyright law.

 * Dissemination of this information or reproduction of this material

 * is strictly forbidden unless prior written permission is obtained

 * from Lexus Drivers.

 * ***********************************************************************

 */


package com.toyota.tmna.lexusdrivers.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Addressinput;
import com.toyota.tmna.lexusdrivers.core.models.Emailinput;
import com.toyota.tmna.lexusdrivers.core.models.Nameinput;
import com.toyota.tmna.lexusdrivers.core.models.Phonenumberinput;
import com.toyota.tmna.lexusdrivers.core.models.StateConfiguration;
import com.toyota.tmna.lexusdrivers.core.models.Updateprofile;
import com.toyota.tmna.lexusdrivers.core.models.Zipinput;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
    UpdateprofileImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/updateprofile")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class UpdateprofileImpl 
    implements Updateprofile,Zipinput,Phonenumberinput,Emailinput,StateConfiguration,Addressinput,Nameinput
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String componenttype;    
    
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String yourInformationLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String editLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String label;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String emailLabel;    
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String requiredMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String cancelLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String firstName;
      @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String lastName;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String lastNamerequiredMessage;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String businessUserName;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String businessUserNamerequiredMessage;        
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String address1Placeholder;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String address2Placeholder;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String submitReimbrusementLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String submitReimbrusementLink;
   
   
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String phoneNumberLabel;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String primaryPhoneNumberLabel;   
       
  
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String newPasswordLabel;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String reTypeNewPasswordLabel;
     
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String passwordHelpText;

     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String currentPasswordReqMessage;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String reTypePasswordReqMessage;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String currentPasswordLabel;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String emailUsedErrorMessage;

 @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String zipInputLabel;
    
 @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String submitLabel;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String hideLabel;

     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String showLabel;
 @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String addressLabel;
@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String cityLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String addressRequiredMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String cityRequiredMessage;
@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String changePasswordLabel;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String successMsg;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String socialErrorMsg;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String zipCityMismatch;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String zipStateMismatch;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String zipNotValid;


     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String closeIcon;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String unknownError;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String vinAssociatedError;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String disclaimerMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String orderHardCopyTitle;

   

    @SlingObject
    private Resource resource;
    
     @Override
    public String getSuccessMsg() {
        return successMsg;
    }
     @Override
    public String getZipNotValid() {
        return zipNotValid;
    }
     @Override
    public String getzipCityMismatch() {
        return zipCityMismatch;
    }

    @Override
    public String getSubmitReimbrusementLabel() {
        return submitReimbrusementLabel;
    }

    @Override
    public String getSubmitReimbrusementLink() {
        return submitReimbrusementLink;
    }


    @Override
    public String getZipStateMismatch() {
        return zipStateMismatch;
    }
     @Override
    public String getSocialErrorMsg() {
        return socialErrorMsg;
    }

    @Override
    public String getShowLabel() {
        return showLabel;
    }
    @Override
    public String getHideLabel() {
        return hideLabel;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public String getBusinessUserName() {
        return businessUserName;
    }
    @Override
    public String getBusinessUserNamerequiredMessage() {
        return businessUserNamerequiredMessage;
    }

    @Override
    public String getlastName() {
        return lastName;
    }
    @Override
    public String getLastNamerequiredMessage() {
        return lastNamerequiredMessage;
    }
    @Override
    public String getReTypeNewPasswordLabel() {
        return reTypeNewPasswordLabel;
    }
    @Override
    public String getNewPasswordLabel() {
        return newPasswordLabel;
    }
     
   @Override
	public String getComponenttype() {
		return componenttype;
	}

    @Override
    public String getCancelLabel() {
        return cancelLabel;
    }
    @Override
    public String getPrimaryPhoneNumberLabel() {
        return primaryPhoneNumberLabel;
    }
    @Override
    public String getPhoneNumberLabel() {
        return phoneNumberLabel;
    }
       
    @Override
    public String getAddress2Placeholder() {
        return address2Placeholder;
    }

    @Override
    public String getAddress1Placeholder() {
        return address1Placeholder;
    }
    @Override
    public String getPasswordHelpText() {
        return passwordHelpText;
    }
    @Override
    public String getCurrentPasswordLabel() {
        return currentPasswordLabel;
    }

    @Override
    public String getYourInformationLabel() {
        return yourInformationLabel;
    }

    @Override
    public String getEditLabel() {
        return editLabel;
    }

   
   @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	public Resource addressValidations;

	public Resource getAddressValidations() {
		return addressValidations;
    }

    @Override
    public String getCurrentPasswordReqMessage() {
        return currentPasswordReqMessage;
    }


@Override
    public String getReTypePasswordReqMessage() {
        return reTypePasswordReqMessage;
    }

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource passwordValidations;

	public Resource getPasswordValidations() {
		return passwordValidations;
	}

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource lastNameRules;

	public Resource getLastNameRules() {
		return lastNameRules;
	}
    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource userNameRules;

	public Resource getUserNameRules() {
		return userNameRules;
	}
    
	@ResourcePath(paths=ConstantsUtil.STATES_RESOURCE_PATH)
	private Resource stateList;
     
	public Resource getStateList() {
		return stateList;
	}

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	public Resource zipCodeValidations;

	public Resource getZipCodeValidations() {
		return zipCodeValidations;
    }

     @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	public Resource phoneNumberValidations;

	public Resource getPhoneNumberValidations() {
		return phoneNumberValidations;
    }
     @Override
    public String getZipInputLabel() {
        return zipInputLabel;
    }
@Override
    public String getEmailUsedErrorMessage() {
        return emailUsedErrorMessage;
    }
@Override
    public String getLabel() {
        return label;
    }
    @Override
    public String getEmailLabel() {
        return emailLabel;
    }   
    @Override
    public String getRequiredMessage() {
        return requiredMessage;
    }
    
    @Override
    public String getSubmitLabel() {
        return submitLabel;
    }
 @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	public Resource emailValidations;

	public Resource getEmailValidations() {
		return emailValidations;
	}
     @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	public Resource rules;

	public Resource getRules() {
		return rules;
	}
	@Override
    public String getAddressLabel() {
        return addressLabel;
    }
    @Override
    public String getCityLabel() {
        return cityLabel;
    }
    @Override
    public String getCityRequiredMessage() {
        return cityRequiredMessage;
    }
    @Override
    public String getAddressRequiredMessage() {
        return addressRequiredMessage;
    }
     @Override
    public String getChangePasswordLabel() {
        return changePasswordLabel;
    }

    @Override
    public String getOrderHardCopyTitle() {
        return orderHardCopyTitle;
    }

    @Override
    public String getDisclaimerMessage() {
        return disclaimerMessage;
    }

    @Override
    public String getVinAssociatedError() {
        return vinAssociatedError;
    }

    @Override
    public String getUnknownError() {
        return unknownError;
    }

    @Override
    public String getCloseIcon() {
        return closeIcon;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }
}
