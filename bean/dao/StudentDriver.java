package com.ty.Activity.bean.dao;

import java.util.Scanner;

import com.ty.Activity.Student;

public class StudentDriver {

	public static void main(String[] args) {
		Student student=new Student();
		StudentImplementation studentImplementation=new StudentImplementation();
		boolean exit=false;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("1.to see all data");
			System.out.println("2. to see the particular data");
			System.out.println("3.to update any particular data");
			System.out.println("4.to delete data");
			System.out.println("5.to exit from program");
			System.out.println("Enter your choice");
			switch(sc.nextInt()) {
			case 1:
			
				studentImplementation.displayAll();
			
			break;
			case 2:
				studentImplementation.getById();
			
			break;
			case 3:
				studentImplementation.getUpdate();
				break;// close switch case
			case 4:{
				studentImplementation.getDelete();
				}
				break;
			case 5:
				System.out.println("Thank You");
					exit=true;
			
			
			}
			
		
			
			
			
			
		}//close of while loop
		while(!exit);
		

		
		
	}

}
