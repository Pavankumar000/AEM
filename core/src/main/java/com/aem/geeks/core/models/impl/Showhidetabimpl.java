package com.aem.geeks.core.models.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.aem.geeks.core.helper.MultifieldHelper;
import com.aem.geeks.core.models.Showhidetab;

@Model(adaptables = SlingHttpServletRequest.class,adapters = Showhidetab.class,
					defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Showhidetabimpl implements Showhidetab {

	@Inject
	Resource resource;
	
	@ValueMapValue
	String studentname;
	
	@ValueMapValue
	String studentimage;
	
	@ValueMapValue
	String btechcollege;
	
	@ValueMapValue
	String bacherlorscertificate;
	
	@ValueMapValue
	String masterscollege;
	
	@ValueMapValue
	String masterscertificate;
	
	@RequestAttribute(name="rAttribute")
	private String reqAttribute;
	
	public String getRequestAttribute() {
		return reqAttribute;
	}

	
	@Override
	public String getStudentName() {
		return studentname;
	}

	@Override
	public String getImageField() {
		return studentimage;
	}

	@Override
	public String getBachelorsCollegeName() {
		return btechcollege;
	}

	@Override
	public String getBachelorsCerificate() {
		return bacherlorscertificate;
	}

	@Override
	public String getMastersCollegeName() {
		return masterscollege;
	}

	@Override
	public String getMastersCertificate() {
		return masterscertificate;
	}

	@Override
	public List<MultifieldHelper> getStudentAddress() {
		List<MultifieldHelper> object = new ArrayList<>();
		try {
			Resource resource2 = resource.getChild("addressfield");
			if(resource2!=null) {
							for(Resource adaptresource :resource2.getChildren()) {
								MultifieldHelper multifieldHelper=	new MultifieldHelper(adaptresource);
							object.add(multifieldHelper);
						}
						}

            }catch(Exception e) {

		}
		
		return object;
	}

	@Override
	public List<MultifieldHelper> getBachelorsProjects() {
		List<MultifieldHelper> object2 = new ArrayList<>();
		try {
			Resource resource2 = resource.getChild("bachelorproject");
			if(resource2!=null) {
							for(Resource adaptresource :resource2.getChildren()) {
								MultifieldHelper multifieldHelper=	new MultifieldHelper(adaptresource);
							object2.add(multifieldHelper);
						}
						}

            }catch(Exception e) {

		}

		return object2;
	}

	@Override
	public List<MultifieldHelper> getMastersProjects() {
		List<MultifieldHelper> object3 = new ArrayList<>();
		try {
			Resource resource2 = resource.getChild("mastersproject");
			if(resource2!=null) {
							for(Resource adaptresource :resource2.getChildren()) {
								MultifieldHelper multifieldHelper=	new MultifieldHelper(adaptresource);
							object3.add(multifieldHelper);
						}
						}

            }catch(Exception e) {

		}
		return object3;
	}

}
