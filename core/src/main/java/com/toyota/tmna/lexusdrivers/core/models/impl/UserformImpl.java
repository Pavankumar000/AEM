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

import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Userform;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
    UserformImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/userform")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class UserformImpl extends PasswordinputImpl
    implements Userform
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String accountTypeBusinessLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String accountTypeIndividualLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String accountTypeLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String description;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String emailField;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String phoneNumberLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String businessNameLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String businessNameLengthPattern;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String businessNameLengthMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String businessNameRequiredMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String firstNameLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String firstNameLengthPattern;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String firstNameLengthMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String firstNameRequiredMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String lastNameLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String lastNameLengthPattern;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String lastNameLengthMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String lastNameRequiredMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String agreementText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String forgotPasswordText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String submitButtonLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String successPageUrl;

     

    @SlingObject
    private Resource resource;

    @Override
    public String getSuccessPageUrl() {
        return successPageUrl;
    }

    @Override
    public String getAccountTypeBusinessLabel() {
        return accountTypeBusinessLabel;
    }

    @Override
    public String getSubmitButtonLabel() {
        return submitButtonLabel;
    }

    @Override
    public String getAccountTypeIndividualLabel() {
        return accountTypeIndividualLabel;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getForgotPasswordText() {
        return forgotPasswordText;
    }

    @Override
    public String getAccountTypeLabel() {
        return accountTypeLabel;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getEmailField() {
        return emailField;
    }

    @Override
    public String getPhoneNumberLabel() {
        return phoneNumberLabel;
    }

    @Override
    public String getBusinessNameLabel() {
        return businessNameLabel;
    }

    @Override
    public String getBusinessNameLengthPattern() {
        return businessNameLengthPattern;
    }

    @Override
    public String getBusinessNameLengthMessage() {
        return businessNameLengthMessage;
    }

    @Override
    public String getBusinessNameRequiredMessage() {
        return businessNameRequiredMessage;
    }

    @Override
    public String getFirstNameLabel() {
        return firstNameLabel;
    }

    @Override
    public String getFirstNameLengthPattern() {
        return firstNameLengthPattern;
    }

    @Override
    public String getFirstNameLengthMessage() {
        return firstNameLengthMessage;
    }

    @Override
    public String getFirstNameRequiredMessage() {
        return firstNameRequiredMessage;
    }

    @Override
    public String getLastNameLabel() {
        return lastNameLabel;
    }

    @Override
    public String getLastNameLengthPattern() {
        return lastNameLengthPattern;
    }

    @Override
    public String getLastNameLengthMessage() {
        return lastNameLengthMessage;
    }

    @Override
    public String getLastNameRequiredMessage() {
        return lastNameRequiredMessage;
    }



    @Override
    public String getAgreementText() {
        return agreementText;
    }


    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource firstNameValidations;

	public Resource getFirstNameValidations() {
		return firstNameValidations;
    }
    
    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource lastNameValidations;

	public Resource getLastNameValidations() {
		return lastNameValidations;
    }
    
    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource businessNameValidations;

	public Resource getBusinessNameValidations() {
		return businessNameValidations;
    }
    
    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource passwordValidations;

	public Resource getPasswordValidations() {
		return passwordValidations;
    }

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource emailValidations;

	public Resource getEmailValidations() {
		return emailValidations;
    }

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource phoneNumberValidations;

	public Resource getPhoneNumberValidations() {
		return phoneNumberValidations;
    }
    
    // @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	// private Resource appColumns;

	// public Resource getAppColumns() {
	// 	return appColumns;
    // }

}
