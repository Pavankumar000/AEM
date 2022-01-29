package com.aem.geeks.core.helper;

import com.aem.geeks.core.models.impl.AuthorBooksImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class MultifieldHelper {
    private static final Logger LOG = LoggerFactory.getLogger(MultifieldHelper.class);
  
    private String enterStudentYear;
    private List<NastedHalper>studentSemester;
    
    
    private String enterStudentAdress;
  
    
    public String getEnterStudentAdress() {
		return enterStudentAdress;
	}
	public String getEnterBachelorsProjects() {
		return enterBachelorsProjects;
	}
	public String getEnterMastersProject() {
		return enterMastersProject;
	}



	private String enterBachelorsProjects;
    private String enterMastersProject;
    
 






	private String zillaparisathMember;
    private  List<NastedHalper> mandalParisath;
    
    private String employeeName;
    
    
    private String bookName;
    private String bookSubject;
    private Date publishDate;
   
    
    private int copies;
    private List<NastedHalper> countrieS;
    private List<NastedHalper> bookEditons;
    public MultifieldHelper(Resource resource){
        try {
        	
        	//showHideTab
        	if(StringUtils.isNotBlank(resource.getValueMap().get("address", String.class))) {
                this.enterStudentAdress = resource.getValueMap().get("address", String.class);
        	}
        	if(StringUtils.isNotBlank(resource.getValueMap().get("bachelorsprojectname", String.class))) {
                this.enterBachelorsProjects = resource.getValueMap().get("bachelorsprojectname", String.class);
        	}
        	if(StringUtils.isNotBlank(resource.getValueMap().get("mastersprojectname", String.class))) {
                this.enterMastersProject = resource.getValueMap().get("mastersprojectname", String.class);
        	}
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	//nestedmultifield
        	if(StringUtils.isNotBlank(resource.getValueMap().get("enteryear", String.class))) {
                this.enterStudentYear = resource.getValueMap().get("enteryear", String.class);
        	}
        	//
        	
        	//nestedmultifield2
        	if(StringUtils.isNotBlank(resource.getValueMap().get("zillaparisathmember", String.class))) {
                this.zillaparisathMember = resource.getValueMap().get("zillaparisathmember", String.class);
        	}
        	
        	
        	
        	
        	//multifield
        	if(StringUtils.isNotBlank(resource.getValueMap().get("employeename", String.class))) {
                this.employeeName = resource.getValueMap().get("employeename", String.class);
        	}
        	//
        	
        	
        	//aemgeeks
            if(StringUtils.isNotBlank(resource.getValueMap().get("bookname", String.class))) {
                this.bookName = resource.getValueMap().get("bookname", String.class);
            }
            if(StringUtils.isNotBlank(resource.getValueMap().get("booksubject", String.class))) {
                this.bookSubject=resource.getValueMap().get("booksubject",String.class);
            }
            if(resource.getValueMap().get("publishdate",Date.class)!=null) {
                this.publishDate=resource.getValueMap().get("publishdate",Date.class);
            }
            if(resource.getValueMap().get("copies",Integer.class)!=null) {
                this.copies=resource.getValueMap().get("copies",Integer.class);
            }
            //

        }catch (Exception e){
            LOG.info("\n BEAN ERROR : {}",e.getMessage());
        }

    }
    
    
    
    
  
    public String getEnterStudentYear() {
        return enterStudentYear;
    }
    
    
    
    
    public String getZillaparisathMember() {
        return zillaparisathMember;
    }

    
   
    
    public String getEmployeeName() {
        return employeeName;
    }
    
    public String getBookName() {
        return bookName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public int getCopies() {
        return copies;
    }

    public String getBookSubject() {
        return bookSubject;
    }
    
    
  //get methods 
    
    
    public List<NastedHalper> getStudentSemester() {
 		return studentSemester;
 	}

    
    
    
    public List<NastedHalper> getMandalParisath() {
  		return mandalParisath;
  	}
 

    public List<NastedHalper> getBookEditons() {
        return bookEditons;
    }
    
    
    
  //set methods  
    
    
	public void setStudentSemester(List<NastedHalper> studentSemester) {
		this.studentSemester = studentSemester;
	}
    
    public void setMandalParisath(List<NastedHalper> mandalParisath) {
		this.mandalParisath = mandalParisath;
	}
    
    
  
    public void setBookEditons(List<NastedHalper> bookEditons) {
        this.bookEditons = bookEditons;
    }
}
