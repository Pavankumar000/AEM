package com.toyota.tmna.lexusdrivers.core.search.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.amazonaws.services.cloudsearchdomain.AmazonCloudSearchDomainClient;
import com.toyota.tmna.lexusdrivers.core.search.domain.Disclaimer;

@ExtendWith(MockitoExtension.class)
class DisclaimerDaoImplTest {

	
	@InjectMocks
	DisclaimerDaoImpl disclaimerDaoImpl;
	
	  @Mock 
	  AmazonCloudSearchDomainClient amazonCloudSearchUploadDomainClient;
	 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		disclaimerDaoImpl.init("https://search-hcc-disclaimers-4zyhcch7dp6cs7y7ulonmvoybi.us-east-1.cloudsearch.amazonaws.com/", "https://doc-hcc-disclaimers-4zyhcch7dp6cs7y7ulonmvoybi.us-east-1.cloudsearch.amazonaws.com/");
	}
	@Test
	void testgetDisclaimerById() throws Exception {
		disclaimerDaoImpl.getDisclaimerById("123");
	}
	@Test
	void testuploadDisclaimer() throws Exception{
		Disclaimer disclaimer=new Disclaimer();
		List<String> ids=new ArrayList<String>();
		List<String> desc=new ArrayList<String>();
		ids.add("testDisc");
		desc.add("short desc");
		disclaimer.setId(ids);
		disclaimer.setDescription(desc);
			 disclaimerDaoImpl.uploadDisclaimer(disclaimer);
		
	}
	@Test
	void testdeleteById() throws Exception{
		  disclaimerDaoImpl.deleteDisclaimer("testDisc");
	}

}
