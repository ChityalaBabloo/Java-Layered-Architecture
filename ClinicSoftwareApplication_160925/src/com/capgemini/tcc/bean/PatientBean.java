package com.capgemini.tcc.bean;

import java.sql.Date;

public class PatientBean {
	
	private int patientId;
	private String patientName;
	private int age;
	private long phone;
	private String description;
	private Date consultationDate;

	public PatientBean() {
		// TODO Auto-generated constructor stub
	}

	public PatientBean(int patientId, String patientName, int age, long phone,
			String description, Date consultationDate) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.phone = phone;
		this.description = description;
		this.consultationDate = consultationDate;
	}

	public PatientBean(String patientName, int age, long phone,
			String description, Date consultationDate) {
		super();
		this.patientName = patientName;
		this.age = age;
		this.phone = phone;
		this.description = description;
		this.consultationDate = consultationDate;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getConsultationDate() {
		return consultationDate;
	}

	public void setConsultationDate(Date consultationDate) {
		this.consultationDate = consultationDate;
	}
	
	@Override
	public String toString() {	
		return "\nName of the Patient: "+patientName+"\nAge: "+age+
				"\nPhone Number: "+phone+"\nDescription: "+description+"\nConsultation Date: "+consultationDate;
	}
}
