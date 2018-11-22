package com.fsd.entity;

import java.io.Serializable;
import java.util.Set;

public class Subject implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Variables
	 */
	private long subjectId;
	private String subTitle;
	private int durationInHours;
	private Set<Book> references;
	
	public Subject() {
		
	}
	
	/**
	 * Methods
	 * 
	 */
	public long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	
	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public int getDurationInHours() {
		return durationInHours;
	}
	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}
	public Set<Book> getReferences() {
		return references;
	}
	public void setReferences(Set<Book> references) {
		this.references = references;
	}
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subTitile=" + subTitle + ", durationInHours=" + durationInHours
				+ ", references=" + references + "]";
	}
	
	
}
