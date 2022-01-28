package com.toyota.tmna.lexusdrivers.core.search.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Videos implements Comparable<Videos>, Serializable, Identifiable {

	private List<String> title;
	private List<String> id;
	private List<String> section_type;
	private List<String> video_title;
	private List<String> description;
	private List<String> resource_type;
	private List<String> model_year;
	private List<String> type_tag;
	private List<String> topic_tag;
	private List<Integer> rank;
	private List<Integer> start_time;
	private Long total_records;
	private List<String> class_name;
	private List<String> sub_title_link;
	private List<String> related_section_title;

	public String getId() {
		return id.get(0);
	}

	public void setId(List<String> id) {
		this.id = Collections.unmodifiableList(id);
	}

	public String getTitle() {
		return title != null ? title.get(0) : null;
	}

	public void setTitle(List<String> title) {
		this.title = Collections.unmodifiableList(title);
	}

	public String getSection_type() {
		return checkStringInList(section_type);
	}

	public void setSection_type(List<String> section_type) {
		this.section_type = Collections.unmodifiableList(section_type);
	}

	public String getVideo_title() {
		return checkStringInList(video_title);
	}

	public void setVideo_title(List<String> video_title) {
		this.video_title = Collections.unmodifiableList(video_title);
	}

	public String getDescription() {
		return checkStringInList(description);
	}

	public void setDescription(List<String> description) {
		this.description = Collections.unmodifiableList(description);
	}

	public String getModel_year() {
		return checkStringInList(model_year);
	}

	public void setModel_year(List<String> model_year) {
		this.model_year = Collections.unmodifiableList(model_year);
	}

	public String getType_tag() {
		return checkStringInList(type_tag);
	}

	public void setType_tag(List<String> type_tag) {
		this.type_tag = Collections.unmodifiableList(type_tag);
	}

	public String getTopic_tag() {
		return checkStringInList(topic_tag);
	}

	public void setTopic_tag(List<String> topic_tag) {
		this.topic_tag = Collections.unmodifiableList(topic_tag);
	}

	public Integer getRank() {
		return checkIntegerInList(rank);
	}

	public void setRank(List<Integer> rank) {
		this.rank = Collections.unmodifiableList(rank);
	}
	private String checkStringInList(List<String> value) {
		return value != null ? value.get(0): null;
	}
	private Integer checkIntegerInList(List<Integer> value) {
		return value != null ? value.get(0): null;
	}

	public Integer getStart_time() {
		return checkIntegerInList(start_time);
	}

	public void setStart_time(List<Integer> start_time) {
		this.start_time = Collections.unmodifiableList(start_time);
	}

	public String getResource_type() {
		return checkStringInList(resource_type);
	}

	public void setResource_type(List<String> resource_type) {
		this.resource_type = Collections.unmodifiableList(resource_type);
	}
	public Long getTotal_records() {
		return this.total_records;
	}

	public void setTotal_records(Long total_records) {
		this.total_records = total_records;
	}

	public String getClass_name() {
		return checkStringInList(class_name);
	}

	public void setClass_name(List<String> class_name) {
		this.class_name = Collections.unmodifiableList(class_name);
	}

	public String getSub_title_link() {
		return checkStringInList(sub_title_link);
	}

	public void setSub_title_link(List<String> sub_title_link) {
		this.sub_title_link = Collections.unmodifiableList(sub_title_link);
	}

	public String getRelated_section_title() {
		return checkStringInList(related_section_title);
	}

	public void setRelated_section_title(List<String> related_section_title) {
		this.related_section_title = Collections.unmodifiableList(related_section_title);
	}

	@Override
	public int compareTo(Videos videos) {
		return (this.getRank() < videos.getRank())
				? -1
				: ((this.getRank() > videos.getRank())
						? 1 : 0);
	}
	/**
	 * @return the equals status.
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	/**
	 * @return the hashcode.
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
