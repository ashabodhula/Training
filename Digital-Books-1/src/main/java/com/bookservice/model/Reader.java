package com.bookservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Reader {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer readerId;

	private String userName;
	private String password;
	private String eMail;
	public Integer getReaderId() {
		return readerId;
	}
	public void setReaderId(Integer readerId) {
		this.readerId = readerId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public Reader(Integer readerId, String userName, String password, String eMail) {
		super();
		this.readerId = readerId;
		this.userName = userName;
		this.password = password;
		this.eMail = eMail;
	}
	public Reader() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
