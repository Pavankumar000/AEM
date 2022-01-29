package com.aem.geeks.core.models;

import java.util.List;

import com.aem.geeks.core.helper.MilestoneMultifieldHelper;


public interface Milestone {
	String getYearField();
	List<MilestoneMultifieldHelper> getEachYearDetails();

}
