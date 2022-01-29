package com.aem.geeks.core.helper;

import org.apache.sling.api.resource.Resource;

import java.util.Date;
import java.util.List;

public class NastedHalper {
	
	private String enterStudentSemester;
	  private List<NastedHalper2>studentSubject;	

	public List<NastedHalper2> getStudentSubject() {
		return studentSubject;
	}



	public void setStudentSubject(List<NastedHalper2> studentSubject) {
		this.studentSubject = studentSubject;
	}

	private String mandalparisathMember;
	
    private int bookEditon;
    private Date editonDate;
    public NastedHalper(Resource resource){
    	
    	
    	 if(resource.getValueMap().get("entersemester", String.class)!=null) {
             this.enterStudentSemester = resource.getValueMap().get("entersemester", String.class);
         }
    	
    	
    	
    	
    	
    	
    	
    	
    	 if(resource.getValueMap().get("mandalparisathmember", String.class)!=null) {
             this.mandalparisathMember = resource.getValueMap().get("mandalparisathmember", String.class);
         }
    	 
        if(resource.getValueMap().get("bookediton", Integer.class)!=null) {
            this.bookEditon = resource.getValueMap().get("bookediton", Integer.class);
        }
        if(resource.getValueMap().get("editondate",Date.class)!=null){
            this.editonDate=resource.getValueMap().get("editondate",Date.class);
        }
        


    }
    
    
    
    public String getEnterStudentSemester() {
		return enterStudentSemester;
	}

    
    
    
    public String getMandalParisathMember() {
        return mandalparisathMember;
    }

    
   

    public int getBookEditon() {
        return bookEditon;
    }

    public Date getEditonDate() {
        return editonDate;
    }
    
  
}
