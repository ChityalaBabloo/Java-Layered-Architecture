package com.cg.helathcare.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.healthcare.model.Patient;
import com.cg.helathcare.dao.PatientDAO;
import com.cg.helathcare.dao.patientDAOImpl;
import com.cg.helathcare.exceptions.HealthCareException;

public class patientServiceImpl implements patientService {

	PatientDAO patientDao = new patientDAOImpl();

	@Override
	public boolean validateDetails(Patient patient) throws HealthCareException {

		List<String> list = new ArrayList<>();
		boolean result = false;

		if (!isNameValid(patient.getName())) {
			list.add("name should start with capital letter & length should be greater than 6 and less tah 20");
		}
		if (!isPhonevalid(patient.getMobileNo())) {
			list.add("phone number exactly 10 digits");
		}
		if (!isProblemValid(patient.getProblem())) {
			list.add("problem name should contain characters");
		}

		if (!list.isEmpty()) {
			result = false;
			throw new HealthCareException(list + "");
		} else {
			result = true;
		}
		return result;
	}

	public boolean isNameValid(String name) {

		String nameRegEx = "[A-Z]{1}[a-zA-Z]{5,20}";
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}

	public boolean isPhonevalid(long mobileNo) {

		String phoneregEx = "[0-9]{10}";
		Pattern pattern = Pattern.compile(phoneregEx);
		Matcher matcher = pattern.matcher(String.valueOf(mobileNo));
		return matcher.matches();
	}

	public boolean isProblemValid(String problemName) {

		String nameRegEx = "[a-zA-Z]{3,}";
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(problemName);
		return matcher.matches();
	}

	@Override
	public int fixAppointment(Patient patient) throws HealthCareException {

		return patientDao.fixAppointment(patient);

	}

}
