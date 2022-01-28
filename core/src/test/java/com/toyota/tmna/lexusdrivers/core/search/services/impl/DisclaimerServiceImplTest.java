package com.toyota.tmna.lexusdrivers.core.search.services.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.toyota.tmna.lexusdrivers.core.search.services.DisclaimerConfigs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.search.dao.DisclaimerDao;
import com.toyota.tmna.lexusdrivers.core.search.domain.Disclaimer;

@ExtendWith({MockitoExtension.class})
class DisclaimerServiceImplTest {
	
	@InjectMocks
	DisclaimerServiceImpl disclaimerServiceImpl;
	@Mock
	DisclaimerDao disclaimerDao;
	@Mock
	DisclaimerConfigs config;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		when(config.disclaimersSearchEndpointURL()).thenReturn("https://search-hcc-disclaimers-4zyhcch7dp6cs7y7ulonmvoybi.us-east-1.cloudsearch.amazonaws.com/");
		when(config.disclaimersUploadDocEndpointURL()).thenReturn("https://doc-hcc-disclaimers-4zyhcch7dp6cs7y7ulonmvoybi.us-east-1.cloudsearch.amazonaws.com/");
		disclaimerServiceImpl.activate(config);
	}

	@Test
	void testGetDisclaimerById() {
		assertNull(disclaimerServiceImpl.getDisclaimerById("test"));
	}

	@Test
	void testGetDisclaimerByIdException() throws IOException {
		when(disclaimerDao.getDisclaimerById("test")).thenThrow(new IOException());
		assertNull(disclaimerServiceImpl.getDisclaimerById("test"));
	}

	@Test
	void testUploadDisclaimer() {
		Disclaimer disclaimer=new Disclaimer();
		List<String> ids=new ArrayList<String>();
		List<String> desc=new ArrayList<String>();
		List<String> heading=new ArrayList<String>();
		ids.add("testDisc");
		desc.add("short desc");
		heading.add("ESCOMPARISON");
		disclaimer.setId(ids);
		disclaimer.setDescription(desc);
		assertFalse(disclaimerServiceImpl.uploadDisclaimer(disclaimer));
	}

	@Test
	void testUploadDisclaimerException() throws JsonProcessingException {
		Disclaimer disclaimer=new Disclaimer();
		List<String> ids=new ArrayList<String>();
		List<String> desc=new ArrayList<String>();
		List<String> heading=new ArrayList<String>();
		ids.add("testDisc");
		desc.add("short desc");
		heading.add("ESCOMPARISON");
		disclaimer.setId(ids);
		disclaimer.setDescription(desc);
		when(disclaimerDao.uploadDisclaimer(disclaimer)).thenThrow(new JsonProcessingException(""){});
		assertFalse(disclaimerServiceImpl.uploadDisclaimer(disclaimer));
	}

	@Test
	void testDeleteDisclaimerById() {

		assertFalse(disclaimerServiceImpl.deleteDisclaimerById("test"));
	}

	@Test
	void testDeleteDisclaimerByIdException() throws IOException {
		when(disclaimerDao.deleteDisclaimer("test")).thenThrow(new IOException());
		assertFalse(disclaimerServiceImpl.deleteDisclaimerById("test"));
	}

}
