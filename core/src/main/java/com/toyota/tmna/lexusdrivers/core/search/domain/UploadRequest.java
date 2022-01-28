package com.toyota.tmna.lexusdrivers.core.search.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class UploadRequest<T> {
	private String type;
	private String id;
	private T fields;
	public UploadRequest(String action, String id){
		this.type = action;
		this.id = id;
	}
	public UploadRequest(String action, String id, T obj){
		this.type = action;
		this.id = id;
		this.fields = obj;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public T getFields() {
		return fields;
	}

	public void setFields(T fields) {
		this.fields = fields;
	}
}
