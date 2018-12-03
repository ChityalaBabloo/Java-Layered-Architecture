package com.cg.helathcare.dao;

public interface QueryConstants {

	public static final String insertQuery = "insert into patients_table values(patient_sequence.nextval,?,?,?,?,sysdate+1)";
	public static final String selectDoctorNameQuery = "select name from doctors_table where SPECALIZATION = ?";
	public static final String getIdQuery = "select max(id) from patients_table";
}
