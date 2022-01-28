package com.toyota.tmna.lexusdrivers.core.search.domain;

import java.util.ArrayList;
import java.util.List;

public class SearchResponse {
	private Long total_records;
	private List<?> data;
	public Long getTotal_records() {
		return total_records;
	}
	public void setTotal_records(Long total_records) {
		this.total_records = total_records;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = new ArrayList<>(data);
	}
}
