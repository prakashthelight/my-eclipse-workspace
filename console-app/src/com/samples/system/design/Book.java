package com.samples.system.design;

public class Book {
	
	String id;
	int rating;	
	
	public Book(String id, int rating) {
		this.id = id;
		this.rating = rating;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
