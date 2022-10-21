package Controller;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Pojo.Studentssi;

import Servicepack.Studentservices;

public class Controller{
	
	static void insertStudents()  throws Exception{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Number of Students to add");
	int numberofstudents=sc.nextInt();
	
	sc.nextLine();
	System.out.println("Enter name of creator");
	String createname=sc.nextLine();
	
	
			
			
	
			
			
			 
			  Studentservices.insertdata(numberofstudents,createname);
		}
		
	
	static void deleteStudent()  throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id to be deleted");
		
		int id = sc.nextInt();
		
		Studentservices studentservice =new Studentservices();
		studentservice.deletedata(id);
		}
	
	static void getAllStudentsWithPagination()  throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Page Size");
		int pageSize = sc.nextInt();
		Studentservices studentservice =new Studentservices();
		studentservice.Pagination(pageSize);
		
	
	}
	static void updateStudent()  throws Exception{
		System.out.println("Enter student id to update");
		Scanner sc=new Scanner(System.in);
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name to be updated");
		String name=sc.nextLine();
		
		System.out.println("Enter age to be updated");
		int age=sc.nextInt();
		
		sc.nextLine();
		System.out.println("Enter name of updater");
		String createname=sc.nextLine();
		
		Studentservices studentservice =new Studentservices();
		studentservice.updatedata(id,name,age,createname);
	}
	static void searchStudentsByName()  throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter student name");
		String searchName = sc.nextLine();
		Studentservices studentservice =new Studentservices();
		studentservice.Search(searchName);
		
	}
	static void readStudentsByName()  throws Exception {
		Studentservices studentservice =new Studentservices();
		studentservice.Readby();
	}
	static void displayall()  throws Exception{
		Studentservices studentservice =new Studentservices();
		studentservice.display();
	}
	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int choice = 0;
		while(true) {
			System.out.println("Enter Your Choice");
			System.out.println("1. Insert students");
			System.out.println("2. Delete student by id");
			System.out.println("3. Print all student information with pagination");
			System.out.println("4. Update student information");
			System.out.println("5. Search by name");
			System.out.println("6. Read by name");
			System.out.println("7. Display");
			System.out.println("8. Exit");
			choice = s.nextInt();
			boolean exit = false;
			switch(choice) {
				case 1: insertStudents();break;
				case 2: deleteStudent();break;
				case 3: getAllStudentsWithPagination();break;
				case 4: updateStudent();break;
				case 5: searchStudentsByName();break;
				case 6: readStudentsByName();break;
				case 7:displayall();break;
				case 8: exit = true; break;
				default: System.out.println("Invalid Input");
			}
			if(exit) {
				break;
			}
		}
		 System.out.println("Program Terminated");
	}
}