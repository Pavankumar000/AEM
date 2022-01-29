package com.aem.geeks.core.services;

import com.day.cq.wcm.api.Page;

import java.util.Iterator;
//when we want to write a code which can be reused in different place u will write in the service
	//but this is not a plain class and methods, it has a additional annotations which let
	//aem manupulate the osgi service as per the bundle life cycle
	//whenever u writing the service always have interface and we have implements the interface
	//MANDATORY ANNOTATION IS"@component(service=Osgiservice2.class)"
	//for a service we have to write model class i am writing the sling model file as Osgiservice2
public interface DemoService {
    public Iterator<Page> getPages();
}
