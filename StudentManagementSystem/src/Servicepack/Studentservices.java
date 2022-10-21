package Servicepack;


import java.io.*;
import java.util.*;

import Pojo.*;
import Dao.*;
public class Studentservices {
	
	public static void insertdata(int numberOfStudents,String createname) throws Exception {
	
		
		//Studentssi obj=new Studentssi();
		Scanner sc =new Scanner(System.in);
		
		
		
        //obj.setId(ob);
		/*obj.setName(name);
		obj.setAge(age);
		obj.setName(createname);*/
		//String createname;
		//int numberOfStudents = sc.nextInt();
		/*for(int i=1;i<=numberOfStudents;i++) {
			System.out.println("Enter id to be inserted");
			int id=sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("Enter name to be inserted");
			String name=sc.nextLine();
			
			System.out.println("Enter age to be inserted");
			int age=sc.nextInt();
			
			sc.nextLine();
			System.out.println("Enter name of creator");
			String createname=sc.nextLine();
			*/
			Studentssi[] ob=new Studentssi[ numberOfStudents];
			
			
			for(int i=0;i< numberOfStudents;i++) {
				System.out.println("ID");
		
				int id_=sc.nextInt();
				
				sc.nextLine();
				
				
				System.out.println("Name");
			String	name_=sc.nextLine();
				
				
				System.out.println("Age");
			int age_=sc.nextInt();
			
			sc.nextLine();
			System.out.println("Enter name of creator");
			createname=sc.nextLine();
				//id_=Integer.parseInt(ids);
				ob[i]=new Studentssi(id_,name_,age_);
				
				
		
		
	
	}	

			StudentDtabase o=new StudentDtabase();
			o.insert(ob,numberOfStudents,createname);
	}
		
		
	public static void deletedata(int id)  throws Exception {
		StudentDtabase o=new StudentDtabase();
		o. deleteStudentById(id);
		}
	
	
	public static void Pagination(int pageSize) throws Exception{
		StudentDtabase o=new StudentDtabase();
	o. getStudentsWithPagination(pageSize,0);
	}
	
	
		
	public static void updatedata(int id,String name,int age,String createname)  throws Exception {
			Studentssi student=new Studentssi();
			
			student.setId(id);
			
			
			student.setName(name);
			
			
			
			student.setAge(age);
	//		student.setName(createname);
			StudentDtabase o=new StudentDtabase();
			o.updateStudent(student,createname);
			
			
		}
		
		
		
	public static void Search(String name)   throws Exception  {
		
		String w=name;
		StudentDtabase o=new StudentDtabase();
		o.searchByName(w);
		}
		
	
	public static void Readby()  throws Exception {
		
		StudentDtabase o=new StudentDtabase();
		o.readByName();
		}	
	
public static void display()  throws Exception {
		
		StudentDtabase o=new StudentDtabase();
		o.display();
		}
	
	

	public static void main(String[] args) throws Exception {
		
		
		

	}
}