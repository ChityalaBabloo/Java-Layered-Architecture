package com.capgemini.tcc.dao;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.ClinicApplicationException;

public interface IPatientDAO {

	int addPatientDetails(PatientBean patient) throws ClinicApplicationException;

	PatientBean getPatientDetails(int patientId) throws ClinicApplicationException;	
}
