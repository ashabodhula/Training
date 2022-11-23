package com.bookservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int authorId;

	private String userName;

	private String eMail;

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;

	public Author(int authorId, String userName, String eMail, String password) {
		super();
		this.authorId = authorId;
		this.userName = userName;
		this.eMail = eMail;
		this.password = password;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

}
