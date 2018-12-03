package com.cg.helathcare.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.healthcare.model.Patient;
import com.cg.helathcare.exceptions.HealthCareException;
import com.cg.helathcare.service.patientService;
import com.cg.helathcare.service.patientServiceImpl;

public class UIClass {

	static Logger logger = Logger.getLogger(UIClass.class);

	public static void main(String[] args) {

		PropertyConfigurator.configure("resources/log4j.properties");
		logger.info("log4j file loaded...");

		Scanner scanner = new Scanner(System.in);

		patientService service = new patientServiceImpl();

		System.out.println("welcome to  Health carew Application");
		System.out.println("1.fix appoinment");
		System.out.println("2.search");
		System.out.println("3.exit");

		System.out.println("Select ur choice");
		int choice = 0;
		try {
			choice = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("enter only digits");
			System.exit(0);
		}
		switch (choice) {
		case 1:
			scanner.nextLine();
			System.out.println("Enter name:");
			String name = scanner.nextLine();
			System.out.println("Enter MobileNumber:");
			long phone = 0;
			try {
				phone = scanner.nextLong();
			} catch (InputMismatchException e) {
				System.err.println("phone number should contain only digits");
				System.exit(0);
			}
			scanner.nextLine();
			System.out.println("problem Name");
			String problemName = scanner.nextLine();

			Patient patient = new Patient();
			patient.setMobileNo(phone);
			patient.setName(name);
			patient.setProblem(problemName);

			try {
				boolean result = service.validateDetails(patient);

				if (result) {
					int patientId = service.fixAppointment(patient);
					System.out.println("ur appoiinment fixed with the id: " + patientId);
				}

			} catch (HealthCareException e) {
				System.err.println(e.getMessage());
			}

			break;

		default:
			break;
		}

	}

}
