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
		log.info("---log4j.properties loaded---");
		
		Scanner sc =  new Scanner(System.in);
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
			System.out.println("Please Enter Only Digits");
			System.exit(0);
		}
		switch (option) {
		case 1:
			sc.nextLine();
			System.out.print("Enter the name of the Patient: ");
			String patientName = sc.nextLine();
			System.out.print("Enter Patient Age: ");
			int age = 0;
			try {
				age = sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Age Should Contain Digits: ");
				System.exit(0);
			}
			sc.nextLine();
			System.out.print("Enter Patient Phone number: ");
			long phone = 0;
			try {
				phone = sc.nextLong();
			} catch (InputMismatchException e) {
				System.err.println("Phone Number Should Contain Only 10 Digits: ");
				System.exit(0);
			}
			sc.nextLine();
			System.out.print("Enter Description: ");
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
			System.out.print("Enter Patient Id to Search: ");
			int patientId = sc.nextInt();
			try {
				PatientBean patientDetails = service.getPatientDetails(patientId);
				if(patientDetails!=null)
				{
					System.out.println(patientDetails);
				}
				else
					System.err.println("There is no patient with this Id");	
			} catch (ClinicApplicationException e) {
				System.err.println(e.getException());
			}
			
			break;
		case 3:
			System.out.println("-----Thank You-------");
			System.out.println("You had successfully exited");
			System.exit(0);
		default:
			break;
		}
		sc.close();
	}

}
