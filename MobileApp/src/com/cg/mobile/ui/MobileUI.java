package com.cg.mobile.ui;

import java.util.List;
import java.util.Scanner;

import com.cg.mobile.bean.Mobile;
import com.cg.mobile.service.IMobileService;
import com.cg.mobile.service.MobileServiceImpl;

public class MobileUI {

	public static void main(String[] args) {

		IMobileService service = new MobileServiceImpl();
		System.out.println(service.display());

		Scanner sc = new Scanner(System.in);
		List<Mobile> list = null;
		while (true) {
			System.out.println("--------------------");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.View");
			System.out.println("4.Delete");
			System.out.println("5.Search");
			System.out.println("6.Exit");

			System.out.println("\nEnter your choice");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter your name");
				String name = sc.nextLine();
				System.out.println("Enter mobileId to purchase");
				int id = sc.nextInt();
				
				break;
			case 2:
				break;
			case 3:
				list = service.getAllMobiles();
				for (Mobile m : list) {
					System.out.println("----------------------");
					System.out.println("id: " + m.getMobileId());
					System.out.println("name: " + m.getName());
					System.out.println("price: " + m.getPrice());
					System.out.println("quantity: " + m.getQuantity());
				}
				break;
			case 4:
				System.out.println("Enter mobileId to delete");
				int mobileId = sc.nextInt();
				String del = service.deleteMobile(mobileId);
				System.out.println(del);
				break;
			case 5:
				System.out.println("----------------Searches by Price-------------------");
				System.out.println("Enter Price");
				double n = sc.nextDouble();
				list = service.getMobileByPrice(n);
				for (Mobile m : list) {
					System.out.println("----------------------");
					System.out.println("id: " + m.getMobileId());
					System.out.println("name: " + m.getName());
					System.out.println("price: " + m.getPrice());
					System.out.println("quantity: " + m.getQuantity());
				}
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("--------Please Choose a Valid Option-----------");
			}

		}

	}
}
