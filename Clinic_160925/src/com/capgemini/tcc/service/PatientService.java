package com.capgemini.tcc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.dao.IPatientDAO;
import com.capgemini.tcc.dao.PatientDAO;
import com.capgemini.tcc.exception.ClinicApplicationException;

public class PatientService implements IPatientService {

	IPatientDAO patientDao = new PatientDAO();
	
	@Override
	public boolean validateDetails(PatientBean patient) throws ClinicApplicationException {
		List<String> list = new ArrayList();
		boolean result = false;
		
		//System.out.println(list);
		//System.out.println(patient.getPatientName());
		
		if(!isNameValid(patient.getPatientName())) {
			list.add("patientNmae should start with capital letter and it should be greater than 6 letters and less than 20 letters");
		}
		
		if(!isAgeValid(patient.getAge())) {
			list.add("age should be less than 100");
		}
		
		if(!isPhonevalid(patient.getPhone())) {
			list.add("phone number exactly 10 digits");
		}
		
		if(!isDescriptionValid(patient.getDescription())) {
			list.add("Description should contain characters");
		}
		
		if (!list.isEmpty()) {
			result = false;
			System.out.println(list);
			throw new ClinicApplicationException(list+ " ");
		} else {
			result = true;
		}
		
		return result;
	}
	
	public boolean isNameValid(String patientName) {
		//System.out.println("WJHGRFW");
		String nameRegEx = "[A-Z]{1}[a-zA-Z]{5,19}";
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(patientName);
		//System.out.println("JKDHQWEI");
		return matcher.matches();
	}
	
	public boolean isAgeValid(int age) {

		String ageRegEx = "[1-9]{1}[0-9]{1}";
		Pattern pattern = Pattern.compile(ageRegEx);
		Matcher matcher = pattern.matcher(String.valueOf(age));
		return matcher.matches();
	}
	public boolean isPhonevalid(long phone) {

		String phoneRegEx = "[0-9]{10}";
		Pattern pattern = Pattern.compile(phoneRegEx);
		Matcher matcher = pattern.matcher(String.valueOf(phone));
		return matcher.matches();
	}

	public boolean isDescriptionValid(String description) {

		String descriptionRegEx = "[a-zA-Z]{3,}";
		Pattern pattern = Pattern.compile(descriptionRegEx);
		Matcher matcher = pattern.matcher(description);
		return matcher.matches();
	}

	@Override
	public int addPatientDetails(PatientBean patient) throws ClinicApplicationException {
		return patientDao.addPatientDetails(patient);
	}

	@Override
	public PatientBean getPatientDetails(int patientId) throws ClinicApplicationException{
		
		return patientDao.getPatientDetails(patientId);
	}
}
