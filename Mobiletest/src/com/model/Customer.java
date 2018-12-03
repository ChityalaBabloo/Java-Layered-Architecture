package com.model;

public class Customer {

	private int id;
	private String name;
	private int mobileId;
	private int qunatity;

	public int getQunatity() {
		return qunatity;
	}

	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, int mobileId, int qunatity) {
		super();
		this.name = name;
		this.mobileId = mobileId;
		this.qunatity = qunatity;
	}

	public Customer(int id, String name, int mobileId, int qunatity) {
		super();
		this.id = id;
		this.name = name;
		this.mobileId = mobileId;
		this.qunatity = qunatity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMobileId() {
		return mobileId;
	}

	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}

}
