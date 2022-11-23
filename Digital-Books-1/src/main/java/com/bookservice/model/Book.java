package com.bookservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	private String image;
	private String title;
	private String author;
	private String publisher;
	private double price;
	private String published_date;
	private String category;
	private boolean status;
	private String chapters;
	private int authorid;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPublished_date() {
		return published_date;
	}

	public void setPublished_date(String published_date) {
		this.published_date = published_date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getChapters() {
		return chapters;
	}

	public void setChapters(String chapters) {
		this.chapters = chapters;
	}

	public int getAuthorid() {
		return authorid;
	}

	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookId, String image, String title, String author, String publisher, double price,
			String published_date, String category, boolean status, String chapters, int authorid) {
		super();
		this.bookId = bookId;
		this.image = image;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.published_date = published_date;
		this.category = category;
		this.status = status;
		this.chapters = chapters;
		this.authorid = authorid;
	}

	public Book(String image, String title, String author, String publisher, double price, String published_date,
			String category, boolean status, String chapters, int authorid) {
		super();
		this.image = image;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.published_date = published_date;
		this.category = category;
		this.status = status;
		this.chapters = chapters;
		this.authorid = authorid;
	}

}
