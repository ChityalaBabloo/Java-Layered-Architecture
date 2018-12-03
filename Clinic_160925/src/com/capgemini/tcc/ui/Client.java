package com.capgemini.tcc.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.ClinicApplicationException;
import com.capgemini.tcc.service.IPatientService;
import com.capgemini.tcc.service.PatientService;

public class Client {

	static Logger log = Logger.getLogger(Client.class);

	public static void main(String[] args) {

		PropertyConfigurator.configure("resources/log4j.properties");
		log.info("-- log4j loaded --");

		Scanner sc = new Scanner(System.in);

		IPatientService service = new PatientService();

		System.out.println("-------Clinic Software Application-------");
		System.out.println("1.Add Patient Information");
		System.out.println("2.Search Patient by Id");
		System.out.println("3.Exit");

		System.out.println("Select Your Option");

		int option = 0;
		try {
			option = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("enter only digits");
			System.exit(0);
		}
		switch (option) {
		case 1:
			sc.nextLine();
			System.out.println("Enter Patient name:");
			String patientName = sc.nextLine();
			System.out.println("Enter age");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Phone number:");
			long phone = 0;
			try {
				phone = sc.nextLong();
			} catch (InputMismatchException e) {
				System.err.println("phone number should contain only 10 digits");
				System.exit(0);
			}			
			sc.nextLine();
			System.out.println("Enter your Description");
			String description = sc.nextLine();
			
			PatientBean patient = new PatientBean();
			patient.setPatientName(patientName);
			patient.setAge(age);
			patient.setPhone(phone);
			patient.setDescription(description);
			
			try {
				//System.out.println(patient.getPatientName());
				boolean result = service.validateDetails(patient);
				
				if (result) {
					int patientId = service.addPatientDetails(patient);
					System.out.println("Your Details had Successfully Added with patientId: " + patientId);
				}
			} catch (ClinicApplicationException e) {
				System.err.println(e.getException());
			}
			break;
		case 2:
			sc.nextLine();
			System.out.println("Enter Patient Id to Search");
			int patientId = sc.nextInt();
			try {
				PatientBean patientDetails = service.getPatientDetails(patientId);
				System.out.println(patientDetails);
				
			} catch (ClinicApplicationException e) {
				System.err.println(e.getException());
			}
			
			break;
		default:
			break;
		}
	}

}
