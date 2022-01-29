package com.aem.geeks.core.models.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.aem.geeks.core.helper.MilestoneMultifieldHelper;
import com.aem.geeks.core.helper.MilestoneNestedHelper;
import com.aem.geeks.core.models.Milestone;
@Model(adaptables = SlingHttpServletRequest.class,adapters = Milestone.class,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MilestoneImpl implements Milestone {

	
	@ValueMapValue
	String year;

	@Inject
	Resource resource;
	@Override
	public String getYearField() {
		return year;
	}

	@Override
	public List<MilestoneMultifieldHelper> getEachYearDetails() {
		List<MilestoneMultifieldHelper>object=new ArrayList<>();
		try {
			Resource resource2=resource.getChild("detailsofcertainyear");
			if(resource2!=null) {
				for(Resource adaptresource:resource2.getChildren()) {
					MilestoneMultifieldHelper multifieldHelper=new MilestoneMultifieldHelper(adaptresource);
					if(adaptresource.hasChildren()) {
						List<MilestoneNestedHelper>object2=new ArrayList<>();
						Resource resource3=adaptresource.getChild("data");
						for(Resource adaptresource2:resource3.getChildren()) {
							MilestoneNestedHelper milestonenestedhelper=new MilestoneNestedHelper(adaptresource2);
							object2.add(milestonenestedhelper);
							
						}
						List<MilestoneNestedHelper>object3=new ArrayList<>();
						Resource resource4=adaptresource.getChild("titleandimage");
						for(Resource adaptresource3:resource4.getChildren()) {
							MilestoneNestedHelper milestonenestedhelper2=new MilestoneNestedHelper(adaptresource3);
							object3.add(milestonenestedhelper2);
						}
						List<MilestoneNestedHelper>object4=new ArrayList<>();
						Resource resource5=adaptresource.getChild("titleanddescription");
						for(Resource adaptresource4:resource5.getChildren()) {
							MilestoneNestedHelper milestonenestedhelper3=new MilestoneNestedHelper(adaptresource4);
							object4.add(milestonenestedhelper3);
						}
						
						multifieldHelper.setDataField(object2);
						multifieldHelper.setTextandimageField(object3);
					  multifieldHelper.setTextanddescriptionField(object4);
					}
					object.add(multifieldHelper);
				}
			}
		}catch(Exception e) {
			
		}
		
		return object;

}
}
