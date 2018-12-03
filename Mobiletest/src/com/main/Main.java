package com.main;

import java.util.Scanner;

import com.exceptions.MobileException;
import com.model.Customer;

public class Main {

	public static void main(String[] args) {

		MService service = new MserviceImpl();

		Scanner scanner = new Scanner(System.in);
		System.out.println("1:purchase");
		System.out.println("2.exit");

		System.out.println("select ur choice:");
		int option = 0;

		try {
			option = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Enter only digits:");
			System.exit(0);
		}

		switch (option) {
		case 1:

			scanner.nextLine();
			System.out.println("Name:");
			String name = scanner.nextLine();

			System.out.println("mobile id:");
			int mobile = 0;

			try {
				mobile = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Enter only digits:");
				System.exit(0);
			}

			System.out.println("Quantity:");
			int quantitty = 0;

			try {
				quantitty = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Enter only digits:");
			}

			Customer customer = new Customer(name, mobile, quantitty);

			try {
				boolean resut = service.validateFileds(customer);

				if (resut) {
					int id;
					try {
						id = service.storeDetails(customer);
						System.out.println("id is: " + id);

					} catch (MobileException e) {
						System.out.println(e.getMessage());
					}
				}

			} catch (MobileException e1) {
				System.err.println(e1.getMessage());
			}

			break;

		case 2:
			System.exit(0);

			break;

		default:
			System.out.println("invalid input");
			break;
		}

	}

}
