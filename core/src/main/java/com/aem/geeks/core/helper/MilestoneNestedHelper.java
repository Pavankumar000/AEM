package com.aem.geeks.core.helper;

import java.util.Date;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Optional;
public class MilestoneNestedHelper {
	@Optional
	private String milestoneData;
	@Optional
	private String milestoneTitle1;
	@Optional
	private String milestoneDescription;
	@Optional
	private String milestoneTitle2;
	@Optional
	private String milestoneImage; 
	public MilestoneNestedHelper(Resource resource) {
		
		 if(resource.getValueMap().get("text", String.class)!=null) {
             this.milestoneData = resource.getValueMap().get("text", String.class);
         }
		 if(resource.getValueMap().get("title", String.class)!=null) {
             this.milestoneTitle1 = resource.getValueMap().get("title", String.class);
         }
		 if(resource.getValueMap().get("description", String.class)!=null) {
             this.milestoneDescription = resource.getValueMap().get("description", String.class);
         }
		 if(resource.getValueMap().get("title2", String.class)!=null) {
             this.milestoneTitle2 = resource.getValueMap().get("title2", String.class);
         }
		 if(resource.getValueMap().get("image", String.class)!=null) {
             this.milestoneImage = resource.getValueMap().get("image", String.class);
         }
		
	}
	public String getMilestoneData() {
		return milestoneData;
	}
	public String getMilestoneTitle1() {
		return milestoneTitle1;
	}
	public String getMilestoneDescription() {
		return milestoneDescription;
	}
	public String getMilestoneTitle2() {
		return milestoneTitle2;
	}
	public String getMilestoneImage() {
		return milestoneImage;
	}
	

}
