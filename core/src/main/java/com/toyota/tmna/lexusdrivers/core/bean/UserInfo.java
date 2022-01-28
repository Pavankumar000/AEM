package com.toyota.tmna.lexusdrivers.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7814356717900760062L;
	private String firstName;
	private String lastName;
	private List<String> email = new ArrayList<>();
	private String signinType;
	private String idToken;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public List<String> getEmail() {
		return
				new ArrayList<>(email);
	}

	/**
	 * @return the signinType
	 */
	public String getSigninType() {
		return signinType;
	}

	/**
	 * @param signinType the signinType to set
	 */
	public void setSigninType(String signinType) {
		this.signinType = signinType;
	}

	/**
	 * @return the idToken
	 */
	public String getIdToken() {
		return idToken;
	}

	/**
	 * @param idToken the idToken to set
	 */
	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}
}
