package com.aem.geeks.core.models;

import java.util.List;

import com.aem.geeks.core.helper.MultifieldHelper;

public interface Showhidetab {
	
	public String getStudentName();
	public String getImageField();
	public String getBachelorsCollegeName();
	public String getBachelorsCerificate();
	public String getMastersCollegeName();
	public String getMastersCertificate();
	public String getRequestAttribute();
	List<MultifieldHelper>getStudentAddress();
	List<MultifieldHelper>getBachelorsProjects();
	List<MultifieldHelper>getMastersProjects();

}
