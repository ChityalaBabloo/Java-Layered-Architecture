package com.cg.helathcare.service;

import com.cg.healthcare.model.Patient;
import com.cg.helathcare.exceptions.HealthCareException;

public interface patientService {

	boolean validateDetails(Patient patient) throws HealthCareException;

	int fixAppointment(Patient patient) throws HealthCareException;

}
