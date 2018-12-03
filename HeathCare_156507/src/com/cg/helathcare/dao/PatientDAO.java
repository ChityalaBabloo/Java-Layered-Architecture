package com.cg.helathcare.dao;

import com.cg.healthcare.model.Patient;
import com.cg.helathcare.exceptions.HealthCareException;

public interface PatientDAO {

	int fixAppointment(Patient patient) throws HealthCareException;
	public String getDoctorName(String problemName) throws HealthCareException;

}
