package com.aem.geeks.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.aem.geeks.core.models.Task2;
@Model(adaptables = SlingHttpServletRequest.class,
adapters =Task2.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL )

public abstract class Task2impl /*extends PaddingandMargin */implements Task2 {

	@ValueMapValue
	String name;
	
/*	@ValueMapValue
	String paddingtop;
	
	@ValueMapValue
	String paddingbottom;
	
	@ValueMapValue
	String paddingleft;
	
	@ValueMapValue
	String paddingright;*/
	
	@ValueMapValue
	String country;
	
	@ValueMapValue
	String image;
	
	@ValueMapValue
	String martialstatus;
	@Override
	public String getNameField() {
		return name;
	}

	@Override
	public String getCountryField() {
		return country ;
	}

	@Override
	public String getImageField() {
		return image;
	}

	@Override
	public String getMartialStatus() {
		return martialstatus;
	}
	
/*	@Override
	public String getPaddingLeft1() {
		return paddingleft;
	}

	@Override
	public String getPaddingRight() {
		return paddingright;
	}

	@Override
	public String getPaddingBottom() {
		return paddingbottom;
	}

	@Override
	public String getPaddingTop() {
		return paddingtop;
	}

	public String ZERO="0";
	
public String getPaddingStyleDesktop() {
	StringBuilder sb = new StringBuilder();
	
	    if(null!=getPaddingTop()){
		if (StringUtils.isNoneBlank(getPaddingTop()) && (!getPaddingTop().equals(ZERO))) {
			sb.append(PaddingandMargin.PADDING_TOP).append(PaddingandMargin.COLON_SEPERATOR).append(getPaddingTop())
					.append(PIXEL).append(PaddingandMargin.SEMICOLON_SEPERATOR);
		}
	    }
	    if(null!=getPaddingLeft1()){
		if (StringUtils.isNoneBlank(getPaddingLeft1()) && (!getPaddingLeft1().equals(ZERO))) {
			sb.append(PaddingandMargin.PADDING_LEFT).append(PaddingandMargin.COLON_SEPERATOR).append(getPaddingLeft1())
					.append(PIXEL).append(PaddingandMargin.SEMICOLON_SEPERATOR);
		}
		}
		if(null!=getPaddingBottom()){
		if (StringUtils.isNoneBlank(getPaddingBottom()) && (!getPaddingBottom().equals(ZERO))) {
			sb.append(PaddingandMargin.PADDING_BOTTOM).append(PaddingandMargin.COLON_SEPERATOR).append(getPaddingBottom())
					.append(PIXEL).append(PaddingandMargin.SEMICOLON_SEPERATOR);
		}
		}
		if(null!=getPaddingRight()){
		if (StringUtils.isNoneBlank(getPaddingRight()) && (!getPaddingRight().equals(ZERO))) {
			sb.append(PaddingandMargin.PADDING_RIGHT).append(PaddingandMargin.COLON_SEPERATOR).append(getPaddingRight())
					.append(PIXEL).append(PaddingandMargin.SEMICOLON_SEPERATOR);
		}
		}
		return sb.toString();

}*/

	

	
	}
