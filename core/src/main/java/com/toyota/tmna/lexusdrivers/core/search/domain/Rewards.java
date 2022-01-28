package com.toyota.tmna.lexusdrivers.core.search.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Rewards implements Serializable, Identifiable {
	private List<String> title;
	private List<String> id;
	private List<String> heading;
	private List<String> category_type;
	private List<String> category_list;
	private List<String> partner_name;
	private List<String> partner_logo;
	private List<String> short_description;
	private List<String> detail_description;
	private List<String> address_line_one;
	private List<String> address_line_two;
	private List<String> city;
	private List<String> state;
	private List<String> zip_code;
	private List<String> phone;
	private List<String> website;
	private List<String> email;
	private List<String> desktop_hero_img;
	private List<String> mobile_hero_img;
	private List<String> tab_hero_img;
	private List<String> alt_text;
	private List<String> desktop_thumb_img;
	private List<String> mobile_thumb_img;
	private List<String> tab_thumb_img;
	private List<String> thumbnail_video;
	private List<String> rotational_banner_section;
	private List<String> secondary_description;
	private List<String> publish_date;
	private List<String> effective_start_date;
	private List<String> effective_end_date;
	private List<String> display_start_date;
	private List<String> rewards_redemption;
	private List<String> is_featured;
	private List<String> global_featured;
	private List<String> meta_tags;
	private List<String> seo_title;
	private List<String> seo_description;
	private List<String> seo_key;
	private List<String> lat_lan;
	private List<String> benefit_type;
	private List<String> claim_title;
	private List<String> claims_icon;
	private List<String> claim_link;
	private List<String> related_section_title;
	private List<String> claim_cta;
	private List<String> claim_msg;
	private List<String> class_name;
	private Long total_records;
	private Double distance;
	
	public void setId(List<String> id) {
		this.id =  Collections.unmodifiableList(id);
	}

	public String getTitle() {
		return checkStringInList(title);
	}

	public void setTitle(List<String> title) {
		this.title = Collections.unmodifiableList(title);
	}

	public String getHeading() {
		return checkStringInList(heading);
	}

	public void setHeading(List<String> heading) {
		this.heading = Collections.unmodifiableList(heading);
	}

	public String getCategory_type() {
		return checkStringInList(category_type);
	}

	public void setCategory_type(List<String> category_type) {
		this.category_type =  Collections.unmodifiableList(category_type);
	}

	public String getCategory_list() {
		return checkStringInList(category_list);
	}

	public void setCategory_list(List<String> category_list) {
		this.category_list =  Collections.unmodifiableList(category_list);
	}

	public String getPartner_name() {
		return checkStringInList(partner_name);
	}

	public void setPartner_name(List<String> partner_name) {
		this.partner_name =  Collections.unmodifiableList(partner_name);
	}

	public String getPartner_logo() {
		return checkStringInList(partner_logo);
	}

	public void setPartner_logo(List<String> partner_logo) {
		this.partner_logo =  Collections.unmodifiableList(partner_logo);
	}

	public String getShort_description() {
		return checkStringInList(short_description);
	}

	public void setShort_description(List<String> short_description) {
		this.short_description =  Collections.unmodifiableList(short_description);
	}

	public String getDetail_description() {
		return checkStringInList(detail_description);
	}

	public void setDetail_description(List<String> detail_description) {
		this.detail_description =  Collections.unmodifiableList(detail_description);
	}

	public String getDesktop_hero_img() {
		return checkStringInList(desktop_hero_img);
	}

	public void setDesktop_hero_img(List<String> desktop_hero_img) {
		this.desktop_hero_img =  Collections.unmodifiableList(desktop_hero_img);
	}

	public String getMobile_hero_img() {
		return checkStringInList(mobile_hero_img);
	}

	public void setMobile_hero_img(List<String> mobile_hero_img) {
		this.mobile_hero_img =  Collections.unmodifiableList(mobile_hero_img);
	}

	public String getTab_hero_img() {
		return checkStringInList(tab_hero_img);
	}

	public void setTab_hero_img(List<String> tab_hero_img) {
		this.tab_hero_img =  Collections.unmodifiableList(tab_hero_img);
	}

	public String getDesktop_thumb_img() {
		return checkStringInList(desktop_thumb_img);
	}

	public void setDesktop_thumb_img(List<String> desktop_thumb_img) {
		this.desktop_thumb_img =  Collections.unmodifiableList(desktop_thumb_img);
	}

	public String getMobile_thumb_img() {
		return checkStringInList(mobile_thumb_img);
	}

	public void setMobile_thumb_img(List<String> mobile_thumb_img) {
		this.mobile_thumb_img =  Collections.unmodifiableList(mobile_thumb_img);
	}

	public String getTab_thumb_img() {
		return checkStringInList(tab_thumb_img);
	}

	public void setTab_thumb_img(List<String> tab_thumb_img) {
		this.tab_thumb_img =  Collections.unmodifiableList(tab_thumb_img);
	}

	public String getThumbnail_video() {
		return checkStringInList(thumbnail_video);
	}

	public void setThumbnail_video(List<String> thumbnail_video) {
		this.thumbnail_video =  Collections.unmodifiableList(thumbnail_video);
	}

	

	public String getAlt_text() {
		return checkStringInList(alt_text);
	}

	public void setAlt_text(List<String> alt_text) {
		this.alt_text =  Collections.unmodifiableList(alt_text);
	}

	
	public String getPublish_date() {
		return checkStringInList(publish_date);
	}

	public void setPublish_date(List<String> publish_date) {
		this.publish_date =  Collections.unmodifiableList(publish_date);
	}

	public String getEffective_start_date() {
		return checkStringInList(effective_start_date);
	}

	public void setEffective_start_date(List<String> effective_start_date) {
		this.effective_start_date =  Collections.unmodifiableList(effective_start_date);
	}

	public String getEffective_end_date() {
		return checkStringInList(effective_end_date);
	}

	public void setEffective_end_date(List<String> effective_end_date) {
		this.effective_end_date =  Collections.unmodifiableList(effective_end_date);
	}

	public String getDisplay_start_date() {
		return checkStringInList(display_start_date);
	}

	public void setDisplay_start_date(List<String> display_start_date) {
		this.display_start_date =  Collections.unmodifiableList(display_start_date);
	}

	public String getIs_featured() {
		return checkStringInList(is_featured);
	}

	public void setIs_featured(List<String> is_featured) {
		this.is_featured =  Collections.unmodifiableList(is_featured);
	}

	public String getGlobal_featured() {
		return checkStringInList(global_featured);
	}

	public void setGlobal_featured(List<String> global_featured) {
		this.global_featured =  Collections.unmodifiableList(global_featured);
	}

	public String getMeta_tags() {
		return checkStringInList(meta_tags);
	}

	public void setMeta_tags(List<String> meta_tags) {
		this.meta_tags =  Collections.unmodifiableList(meta_tags);
	}

	public String getSeo_title() {
		return checkStringInList(seo_title);
	}

	public void setSeo_title(List<String> seo_title) {
		this.seo_title =  Collections.unmodifiableList(seo_title);
	}

	public String getSeo_description() {
		return checkStringInList(seo_description);
	}

	public void setSeo_description(List<String> seo_description) {
		this.seo_description =  Collections.unmodifiableList(seo_description);
	}

	public String getSeo_key() {
		return checkStringInList(seo_key);
	}

	public void setSeo_key(List<String> seo_key) {
		this.seo_key =  Collections.unmodifiableList(seo_key);
	}

	public String getAddress_line_one() {
		return checkStringInList(address_line_one);
	}

	public void setAddress_line_one(List<String> address_line_one) {
		this.address_line_one =  Collections.unmodifiableList(address_line_one);
	}

	public String getCity() {
		return checkStringInList(city);
	}

	public void setCity(List<String> city) {
		this.city =  Collections.unmodifiableList(city);
	}

	public String getState() {
		return checkStringInList(state);
	}

	public void setState(List<String> state) {
		this.state =  Collections.unmodifiableList(state);
	}

	public String getZip_code() {
		return checkStringInList(zip_code);
	}

	public void setZip_code(List<String> zip_code) {
		this.zip_code =  Collections.unmodifiableList(zip_code);
	}

	public String getPhone() {
		return checkStringInList(phone);
	}

	public void setPhone(List<String> phone) {
		this.phone =  Collections.unmodifiableList(phone);
	}

	public String getWebsite() {
		return checkStringInList(website);
	}

	public void setWebsite(List<String> website) {
		this.website =  Collections.unmodifiableList(website);
	}

	public String getRewards_redemption() {
		return checkStringInList(rewards_redemption);
	}

	public void setRewards_redemption(List<String> rewards_redemption) {
		this.rewards_redemption =  Collections.unmodifiableList(rewards_redemption);
	}

	
	private String checkStringInList(List<String> value) {
		return value != null && !value.isEmpty() ? value.get(0): null;
	}

	@Override
	public String getId() {
		return id.get(0);
	}

	public String getLat_lan() {
		return checkStringInList(lat_lan);
	}

	public void setLat_lan(List<String> lat_lan) {
		this.lat_lan =  Collections.unmodifiableList(lat_lan);
	}

	public String getAddress_line_two() {
		return checkStringInList(address_line_two);
	}

	public void setAddress_line_two(List<String> address_line_two) {
		this.address_line_two =  Collections.unmodifiableList(address_line_two);
	}

	public String getEmail() {
		return checkStringInList(email);
	}

	public void setEmail(List<String> email) {
		this.email =  Collections.unmodifiableList(email);
	}

	public String getRotational_banner_section() {
		return checkStringInList(rotational_banner_section);
	}

	public void setRotational_banner_section(List<String> rotational_banner_section) {
		this.rotational_banner_section =  Collections.unmodifiableList(rotational_banner_section);
	}

	public String getSecondary_description() {
		return checkStringInList(secondary_description);
	}

	public void setSecondary_description(List<String> secondary_description) {
		this.secondary_description =  Collections.unmodifiableList(secondary_description);
	}

	public Long getTotal_records() {
		return this.total_records;
	}

	public void setTotal_records(Long total_records) {
		this.total_records = total_records;
	}

	public String getBenefit_type() {
		return checkStringInList(benefit_type);
	}

	public void setBenefit_type(List<String> benefit_type) {
		this.benefit_type =  Collections.unmodifiableList(benefit_type);
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getClaim_title() {
		return checkStringInList(claim_title);
	}

	public void setClaim_title(List<String> claim_title) {
		this.claim_title =  Collections.unmodifiableList(claim_title);
	}

	public String getClaims_icon() {
		return checkStringInList(claims_icon);
	}

	public void setClaims_icon(List<String> claims_icon) {
		this.claims_icon =  Collections.unmodifiableList(claims_icon);
	}

	public String getClaim_link() {
		return checkStringInList(claim_link);
	}

	public void setClaim_link(List<String> claim_link) {
		this.claim_link =  Collections.unmodifiableList(claim_link);
	}

	public String getRelated_section_title() {
		return checkStringInList(related_section_title);
	}

	public void setRelated_section_title(List<String> related_section_title) {
		this.related_section_title =  Collections.unmodifiableList(related_section_title);
	}

	public String getClaim_cta() {
		return checkStringInList(claim_cta);
	}

	public void setClaim_cta(List<String> claim_cta) {
		this.claim_cta =  Collections.unmodifiableList(claim_cta);
	}

	public String getClaim_msg() {
		return checkStringInList(claim_msg);
	}

	public void setClaim_msg(List<String> claim_msg) {
		this.claim_msg =  Collections.unmodifiableList(claim_msg);
	}

	public String getClass_name() {
		return checkStringInList(class_name);
	}

	public void setClass_name(List<String> class_name) {
		this.class_name =  Collections.unmodifiableList(class_name);
	}
}
