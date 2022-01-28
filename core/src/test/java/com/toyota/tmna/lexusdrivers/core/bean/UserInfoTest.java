package com.toyota.tmna.lexusdrivers.core.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserInfoTest {
	private UserInfo userInfo;

	@BeforeEach
	public void setUp() throws Exception {
		userInfo = new UserInfo();
		userInfo.setIdToken("tokenid");
		userInfo.setFirstName("John");
		userInfo.setLastName("Doe");
		userInfo.setSigninType("social");

	}

	@Test
	void getIdToken() {
		String expected = "tokenid";
		String actual = userInfo.getIdToken();
		assertEquals(expected, actual);
	}
	
	@Test
	void getFirstName() {
		String expected = "John";
		String actual = userInfo.getFirstName();
		assertEquals(expected, actual);
	}
	
	@Test
	void getLastName() {
		String expected = "Doe";
		String actual = userInfo.getLastName();
		assertEquals(expected, actual);
	}
	
	@Test
	void getSigninType() {
		String expected = "social";
		String actual = userInfo.getSigninType();
		assertEquals(expected, actual);
	}

}
