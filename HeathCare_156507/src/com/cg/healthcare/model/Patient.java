package com.cg.healthcare.model;

import java.sql.Date;

public class Patient {

	private int id;
	private String name;
	private long mobileNo;
	private String problem;
	private String doctorName;
	private Date date;

	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(int id, String name, long mobileNo, String problem, String doctorName, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.problem = problem;
		this.doctorName = doctorName;
		this.date = date;
	}

	public Patient(String name, long mobileNo, String problem, String doctorName, Date date) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.problem = problem;
		this.doctorName = doctorName;
		this.date = date;
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

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
