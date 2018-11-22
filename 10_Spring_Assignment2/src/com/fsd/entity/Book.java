package com.fsd.entity;

import java.io.Serializable;
import java.util.Date;
import java.time.LocalDate;

public class Book implements Serializable{

	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Variables
	 */
	private long bookId;
	private String title;
	private double price;
	private Integer volume;
	private Date publishDate;
	private long subjectId;
	
	

	
	
	public Book() {
		
	}
	
	/**
	 * Methods
	 */
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	


	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price + ", volume=" + volume
				+ ", publishdDate=" + publishDate + ", subjectId=" + subjectId + "]";
	}

	
	
	
	

	
}
