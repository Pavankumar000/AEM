package com.toyota.tmna.lexusdrivers.core.search.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Stories implements Serializable, Identifiable {

	private List<String> title;
	private List<String> id;
	private List<String> section_type;
	private List<String> category;
	private List<String> partner_name;
	private List<String> short_description;
	private List<String> is_featured;
	private List<String> global_featured;
	private List<String> long_description;
	private List<String> description;
	private List<String> desktop_hero_image;
	private List<String> mobile_hero_image;
	private List<String> tablet_hero_image;
	private List<String> desktop_thumbnail_image;
	private List<String> mobile_thumbnail_image;
	private List<String> tablet_thumbnail_image;
	private List<String> video_url;
	private List<String> rotational_banner_section;
	private List<String> secondary_description;
	private List<String> publish_date;
	private List<String> effective_start_date;
	private List<String> effective_end_date;
	private List<String> display_start_date;
	private List<String> meta_tags;
	private List<String> seo_title;
	private List<String> seo_description;
	private List<String> seo_key;
	private Long total_records;
	private Long category_count;
	private List<String> related_section_title;
	private List<String> class_name;
	
	public String getId() {
		return id.get(0);
	}

	public void setId(List<String> id) {
		this.id = Collections.unmodifiableList(id);
	}

	public String getTitle() {
		return checkStringInList(title);
	}

	public void setTitle(List<String> title) {
		this.title = Collections.unmodifiableList(title);
	}

	public String getPartner_name() {
		return checkStringInList(partner_name);
	}

	public void setPartner_name(List<String> partner_name) {
		this.partner_name = Collections.unmodifiableList(partner_name);
	}

	public String getShort_description() {
		return checkStringInList(short_description);
	}

	public void setShort_description(List<String> short_description) {
		this.short_description = Collections.unmodifiableList(short_description);
	}

	public String getLong_description() {
		return checkStringInList(long_description);
	}

	public void setLong_description(List<String> long_description) {
		this.long_description = Collections.unmodifiableList(long_description);
	}
	
	public String getPublish_date() {
		return checkStringInList(publish_date);
	}

	public void setPublish_date(List<String> publish_date) {
		this.publish_date = Collections.unmodifiableList(publish_date);
	}

	public String getEffective_start_date() {
		return checkStringInList(effective_start_date);
	}

	public void setEffective_start_date(List<String> effective_start_date) {
		this.effective_start_date = Collections.unmodifiableList(effective_start_date);
	}

	public String getEffective_end_date() {
		return checkStringInList(effective_end_date);
	}

	public void setEffective_end_date(List<String> effective_end_date) {
		this.effective_end_date = Collections.unmodifiableList(effective_end_date);
	}

	public String getDisplay_start_date() {
		return checkStringInList(display_start_date);
	}

	public void setDisplay_start_date(List<String> display_start_date) {
		this.display_start_date = Collections.unmodifiableList(display_start_date);
	}

	public String getIs_featured() {
		return checkStringInList(is_featured);
	}

	public void setIs_featured(List<String> is_featured) {
		this.is_featured = Collections.unmodifiableList(is_featured);
	}

	public String getGlobal_featured() {
		return checkStringInList(global_featured);
	}

	public void setGlobal_featured(List<String> global_featured) {
		this.global_featured = Collections.unmodifiableList(global_featured);
	}

	public String getMeta_tags() {
		return checkStringInList(meta_tags);
	}

	public void setMeta_tags(List<String> meta_tags) {
		this.meta_tags = Collections.unmodifiableList(meta_tags);
	}

	public String getSeo_title() {
		return checkStringInList(seo_title);
	}

	public void setSeo_title(List<String> seo_title) {
		this.seo_title = Collections.unmodifiableList(seo_title);
	}

	public String getSeo_description() {
		return checkStringInList(seo_description);
	}

	public void setSeo_description(List<String> seo_description) {
		this.seo_description = Collections.unmodifiableList(seo_description);
	}

	public String getSeo_key() {
		return checkStringInList(seo_key);
	}

	public void setSeo_key(List<String> seo_key) {
		this.seo_key = Collections.unmodifiableList(seo_key);
	}

	public String getSection_type() {
		return checkStringInList(section_type);
	}

	public void setSection_type(List<String> section_type) {
		 this.section_type = Collections.unmodifiableList(section_type);
	}

	public String getCategory() {
		return checkStringInList(category);
	}

	public void setCategory(List<String> category) {
		this.category = Collections.unmodifiableList(category);
	}

	public String getDescription() {
		return checkStringInList(description);
	}

	public void setDescription(List<String> description) {
		this.description = Collections.unmodifiableList(description);
	}

	public String getDesktop_hero_image() {
		return checkStringInList(desktop_hero_image);
	}

	public void setDesktop_hero_image(List<String> desktop_hero_image) {
		this.desktop_hero_image = Collections.unmodifiableList(desktop_hero_image);
	}

	public String getMobile_hero_image() {
		return checkStringInList(mobile_hero_image);
	}

	public void setMobile_hero_image(List<String> mobile_hero_image) {
		this.mobile_hero_image = Collections.unmodifiableList(mobile_hero_image);
	}

	public String getTablet_hero_image() {
		return checkStringInList(tablet_hero_image);
	}

	public void setTablet_hero_image(List<String> tablet_hero_image) {
		this.tablet_hero_image = Collections.unmodifiableList(tablet_hero_image);
	}

	public String getDesktop_thumbnail_image() {
		return checkStringInList(desktop_thumbnail_image);
	}

	public void setDesktop_thumbnail_image(List<String> desktop_thumbnail_image) {
		this.desktop_thumbnail_image = Collections.unmodifiableList(desktop_thumbnail_image);
	}

	public String getMobile_thumbnail_image() {
		return checkStringInList(mobile_thumbnail_image);
	}

	public void setMobile_thumbnail_image(List<String> mobile_thumbnail_image) {
		this.mobile_thumbnail_image = Collections.unmodifiableList(mobile_thumbnail_image);
	}

	public String getTablet_thumbnail_image() {
		return checkStringInList(tablet_thumbnail_image);
	}

	public void setTablet_thumbnail_image(List<String> tablet_thumbnail_image) {
		this.tablet_thumbnail_image = Collections.unmodifiableList(tablet_thumbnail_image);
	}

	public String getVideo_url() {
		return checkStringInList(video_url);
	}

	public void setVideo_url(List<String> video_url) {
		this.video_url = Collections.unmodifiableList(video_url);
	}

	public String getRotational_banner_section() {
		return checkStringInList(rotational_banner_section);
	}

	public void setRotational_banner_section(List<String> rotational_banner_section) {
		this.rotational_banner_section = Collections.unmodifiableList(rotational_banner_section);
	}

	private String checkStringInList(List<String> value) {
		return value != null && !value.isEmpty() ? value.get(0): null;
	}
	public Long getTotal_records() {
		return this.total_records;
	}

	public void setTotal_records(Long total_records) {
		this.total_records = total_records;
	}

	public Long getCategory_count() {
		return category_count;
	}

	public void setCategory_count(Long category_count) {
		this.category_count = category_count;
	}

	public String getSecondary_description() {
		return checkStringInList (secondary_description);
	}

	public void setSecondary_description(List<String> secondary_description) {
		this.secondary_description = Collections.unmodifiableList(secondary_description);
	}

	public String getRelated_section_title() {
		return checkStringInList(related_section_title);
	}

	public void setRelated_section_title(List<String> related_section_title) {
		this.related_section_title = Collections.unmodifiableList(related_section_title);
	}

	public String getClass_name() {
		return checkStringInList(class_name);
	}

	public void setClass_name(List<String> class_name) {
		this.class_name = Collections.unmodifiableList(class_name);
	}
}
