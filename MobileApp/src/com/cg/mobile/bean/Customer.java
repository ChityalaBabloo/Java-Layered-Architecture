package com.cg.mobile.bean;

import java.sql.Date;

public class Customer {
	private String name;
	private String mailId;
	private long phone;
	private Date purchaseDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
}
/*
 * 1.create bean class in bean package and generate setters and getters
 * 
 * 2.In dao package
 * 	2.1.create Interface IMobileDao
 * 	--->public sString display();
 * 	2.2.create class MobileDaoImpl implements IMobileDao
 * 	--->override String display()
 * 
 * 3.In Service package
 * 	3.1.create Interface IMobileService
 * 	3.2.create class IMobileServiceImpl implements IMobileService
 * 	
 * */
 