package com.capgemini.tcc.service;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.ClinicApplicationException;

public interface IPatientService {

	boolean validateDetails(PatientBean patient) throws ClinicApplicationException;

	int addPatientDetails(PatientBean patient) throws ClinicApplicationException;

	PatientBean getPatientDetails(int patientId) throws ClinicApplicationException;
	
}
