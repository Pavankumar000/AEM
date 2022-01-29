package com.aem.geeks.core.helper;

import java.util.Date;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Optional;

import com.aem.geeks.core.helper.MilestoneNestedHelper;
public class MilestoneMultifieldHelper {
	@Optional
	private Date enterYearandMonth;
	
	private List<MilestoneNestedHelper>dataField;
	private List<MilestoneNestedHelper>textandimageField;
	private List<MilestoneNestedHelper>textanddescriptionField;
	

	
	
	
	public List<MilestoneNestedHelper> getDataField() {
		return dataField;
	}
	public void setDataField(List<MilestoneNestedHelper> dataField) {
		this.dataField = dataField;
	}
	public List<MilestoneNestedHelper> getTextandimageField() {
		return textandimageField;
	}
	public void setTextandimageField(List<MilestoneNestedHelper> textandimageField) {
		this.textandimageField = textandimageField;
	}
	public List<MilestoneNestedHelper> getTextanddescriptionField() {
		return textanddescriptionField;
	}
	public void setTextanddescriptionField(List<MilestoneNestedHelper> textanddescriptionField) {
		this.textanddescriptionField = textanddescriptionField;
	}
	public MilestoneMultifieldHelper(Resource resource) {
	try {
	 if(resource.getValueMap().get("yearandmonth",Date.class)!=null) {
         this.enterYearandMonth=resource.getValueMap().get("yearandmonth",Date.class);
     }
	}catch(Exception e) {
		
	}
	}
	 public Date getYearandMonth() {
	        return enterYearandMonth;
	    }

}
	
