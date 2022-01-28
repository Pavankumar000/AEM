package com.toyota.tmna.lexusdrivers.core.search.services;

import java.io.IOException;
import java.io.Serializable;


public interface WaldoService extends Serializable {
	String getLatlang(String param) throws IOException;
	String getZip(String paramOne, String paramTwo)throws IOException;
	String getState(String zip) throws IOException;

}
