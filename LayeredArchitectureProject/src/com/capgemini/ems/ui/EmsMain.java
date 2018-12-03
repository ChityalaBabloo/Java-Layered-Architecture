package com.capgemini.ems.ui;

import java.util.Scanner;

import com.capgemini.ems.dto.Employee;
import com.capgemini.ems.service.EmployeeService;
import com.capgemini.ems.service.EmployeeSeviceImpl;

public class EmsMain {
	public static void main(String[] args) {
		
		EmployeeService service = new EmployeeSeviceImpl();
		
		System.out.println("Employee Management");
		System.out.println("1.Add Employee");
		System.out.println("2.Exit");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("select your choice");
		int option = 0;
		try
		{
			option = sc.nextInt();
		}
		catch(Exception e) {
			System.out.println("input should conatin only digits");
			System.exit(0);//if not written it will go for default case
		}
		switch(option) {
		case 1:
			System.out.println("Enter id:");
			int id = sc.nextInt();
			System.out.println("Enter name");
			String name = sc.nextLine();
			System.out.println("Enter salary");
			double salary = sc.nextDouble();
			
			//creating an employee object
			Employee employee = new Employee(id,name,salary);
			break;
		case 2:
			System.out.println("Thank you, Visit Again");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option..Please enter again");
			break;
		}
		
	}
}
