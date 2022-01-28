package com.toyota.tmna.lexusdrivers.core.search.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Disclaimer implements Serializable, Identifiable {

	private List<String> description;
	private List<String> id;
	private Long total_records;

	public String getDescription() {
		return description.get(0);
	}

	public void setDescription(List<String> description) {
		this.description = Collections.unmodifiableList(description);
	}

	public String getId() {
		return id.get(0);
	}

	public void setId(List<String> id) {
		this.id = Collections.unmodifiableList(id);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		if (getId() != null)
			sb.append("Description: ").append(getDescription()).append(",");
		if (getId() != null)
			sb.append("Id: ").append(getId());
		sb.append("}");
		return sb.toString();
	}

	public Long getTotal_records() {
		return total_records;
	}

	public void setTotal_records(Long total_records) {
		this.total_records = total_records;
	}
}
