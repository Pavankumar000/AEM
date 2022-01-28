package com.toyota.tmna.lexusdrivers.core.search.domain;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.bean.UserInfo;

@ExtendWith(MockitoExtension.class)
public class DisclaimerTest {
	private Disclaimer disclaimer;
	
	
	 List<String> id=new ArrayList<String>();
	 List<String> heading=new ArrayList<String>();
	 List<String> shortDescription=new ArrayList<String>();
	 List<String> name=new ArrayList<String>();
	@BeforeEach
	public void setUp() throws Exception {
		disclaimer = new Disclaimer();
	}
	
	
	@Test
	void getDescription() {
		List<String> expected=new ArrayList<String>();
		expected.add("description");
		disclaimer.setDescription(expected); 
		String actual = disclaimer.getDescription();
		assertEquals(expected.get(0), actual);
		assertNotNull(actual);
	}

	@Test
	void getId() {
		List<String> expected=new ArrayList<String>();
		expected.add("id");
		disclaimer.setId(expected);
		String  actual = disclaimer.getId();
		assertEquals(expected.get(0), actual);
	}

	@Test
	void getTotalRecords() {
		Long expected= 1L;
		disclaimer.setTotal_records(expected);
		Long  actual = disclaimer.getTotal_records();
		assertEquals(expected, actual);
	}
	
	@Test
	void TString() {
		List<String> idlist=new ArrayList<String>();
		idlist.add("id");
		disclaimer.setId(idlist);
		disclaimer.setDescription(idlist);
		String  expected = "{Description: id,Id: id}";
		String actual = disclaimer.toString();
		assertEquals(expected,actual);
	}

}
