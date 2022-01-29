package com.aem.geeks.core.models.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.aem.geeks.core.helper.MultifieldHelper;
import com.aem.geeks.core.helper.NastedHalper;
import com.aem.geeks.core.helper.NastedHalper2;
import com.aem.geeks.core.models.Samplecomponent4;

@Model(adaptables =SlingHttpServletRequest.class,adapters = Samplecomponent4.class,
defaultInjectionStrategy =DefaultInjectionStrategy.OPTIONAL  )

public class Samplecomponent4impl implements Samplecomponent4 {

	
	 @Inject
	    Resource resource;
	
	 @ValueMapValue
		String name;
	 
	@Override
	public String getStudentName() {
		return name;
	}

	@Override
	public List<MultifieldHelper> getAllSubjects() {
		List<MultifieldHelper> object = new ArrayList<>();
		try {
			Resource resource2 = resource.getChild("year");
			if(resource2!=null) {
				for(Resource adaptresource:resource2.getChildren()) {
					MultifieldHelper multifieldHelper = new MultifieldHelper(adaptresource);
					if(adaptresource.hasChildren()) {
						ArrayList<NastedHalper> object2 = new ArrayList<>();
						Resource resource3 = adaptresource.getChild("semester");
						for(Resource adaptresource2:resource3.getChildren()) {
							NastedHalper nastedHalper = new NastedHalper(adaptresource2);
							if(adaptresource2.hasChildren()) {
								ArrayList<NastedHalper2> object3 = new ArrayList<>();
								Resource resource4 = adaptresource2.getChild("subject");
								for(Resource adaptresource3:resource4.getChildren()) {
									NastedHalper2 nastedHalper2 = new NastedHalper2(adaptresource3);
									object3.add(nastedHalper2);
								}
								nastedHalper.setStudentSubject(object3);
							}
						object2.add(nastedHalper);
						}
					multifieldHelper.setStudentSemester(object2);
					}
					object.add(multifieldHelper);
				}
			}
		}catch(Exception e) {
			
		}
	
		return object;
	}

}
