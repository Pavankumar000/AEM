package com.aem.geeks.core.helper;

import org.apache.sling.api.resource.Resource;

public class NastedHalper2 {

	private String enterStudentSubject;
	
	 public String getEnterStudentSubject() {
		return enterStudentSubject;
	}

	
	public NastedHalper2(Resource resource){
	    	

	 if(resource.getValueMap().get("entersubject", String.class)!=null) {
        this.enterStudentSubject = resource.getValueMap().get("entersubject", String.class);
    }

	 }
}
