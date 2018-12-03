package com.capgemini.tcc.dao;

public class QueryConstants {
	
	public static final String insertQuery = "insert into Patient values(Patient_Id_Seq.nextval,?,?,?,?,sysdate)";
	public static final String getIdQuery = "select max(patient_id) from Patient";
	public static final String getPatientQuery = "select * from Patient where Patient_Id = ?";
	
}
