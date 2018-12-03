package com.cg.corejava.ui;

import java.util.Scanner;

public class ui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	}

}
