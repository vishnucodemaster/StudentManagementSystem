package Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

import Pojo.Studentssi;
import Servicepack.*;
public class StudentDtabase {

	private static String url = "jdbc:mysql://localhost:3306/student";
	//table name studentdb
	String uname="root";
	String pword="tyxping";
	
		public void insert(Studentssi[] ob,int numberOfStudents,String createname) throws Exception{
			
			Connection con=DriverManager.getConnection(url,uname,pword);
			
			PreparedStatement	ins=con.prepareStatement("insert into StudentTab (ID, Name, age,created_by) values(?,?,?,?)");
			
//			Integer id=obj. getId();
//			String name=obj.getName();
//			Integer age=obj.getAge();
//			String createname=obj.getName();
//			System.out.println(name+" "+age);
//			ins.setInt(1,id );
//			ins.setString(2,name);
//			ins.setInt(3, age);
//			ins.setString(4,createname);
			
			for(int i=0;i<numberOfStudents;i++) {
				ins.setInt(1,ob[i].getId() );
				ins.setString(2,ob[i].getName());
				ins.setInt(3,ob[i].getAge());
			
				ins.setString(4, createname); // 
		
				ins.addBatch();
			}
			
			ins.executeBatch();
		//	ins.executeUpdate();
			
			
			
		}
		
		public int deleteStudentById(int id) throws SQLException {
			String sql = "delete from StudentTab where id = "+id;
			Statement statement;
			int rowsAffected = 0;
			try {
				Connection conn = DriverManager.getConnection(url,uname,pword );
				statement = conn.createStatement();
				rowsAffected = statement.executeUpdate (sql);

		        statement.close ();   
			}catch(SQLException e) {
				throw e;
			}
	        return rowsAffected;
		}
		
		public void updateStudent(Studentssi s,String updateName) throws SQLException {
			int updatedId = s.getId();
			String updatedName = s.getName();
			int updatedAge = s.getAge();
			
			
			String sql = "UPDATE  StudentTab set id="+updatedId+", name= '"+updatedName+"', age="+updatedAge+",updated_time= CURRENT_TIMESTAMP,updated_by='"+updateName+"' where id="+updatedId+";";
			Statement statement;
			int rowsAffected = 0;
			try {
				Connection conn = DriverManager.getConnection(url,uname,pword );
				statement = conn.createStatement();
				rowsAffected = statement.executeUpdate (sql);

		        statement.close ();   
			}catch(SQLException e) {
				throw e;
			}
			System.out.print("Executed");
		}
		
		public List<Studentssi> getStudentsWithPagination(int pageSize, int startRow) throws SQLException {
			String sql = "select * from StudentTab limit "+pageSize+"  OFFSET "+startRow+";";
			List<Studentssi> studentList = new ArrayList<Studentssi>();
			Statement statement;
			try {
				Connection conn = DriverManager.getConnection(url,uname,pword );
				statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);

				while(resultSet.next()) {
					studentList.add(new Studentssi(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));
					System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));}
		        statement.close ();   
			}catch(SQLException e) {
				throw e;
			}
			
			return studentList;
		}
		
		public List<Studentssi> searchByName(String name)throws SQLException{
			String sql = "select * from StudentTab where name='"+name+"';";
			List<Studentssi> studentList = new ArrayList<Studentssi>();
			Statement statement;
			try {
				Connection conn = DriverManager.getConnection(url,uname,pword );
				statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);

				while(resultSet.next()) {
					studentList.add(new Studentssi(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));
					System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
				}
		        statement.close ();   
			}catch(SQLException e) {
				throw e;
			}
			return studentList;
		}
		public List<Studentssi> readByName()throws SQLException{
			String sql = "select * from StudentTab order by name;";
			List<Studentssi>studentList = new ArrayList<Studentssi>();
			Statement statement;
			try {
				Connection conn = DriverManager.getConnection(url,uname,pword  );
				statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);

				while(resultSet.next()) {
					studentList.add(new Studentssi(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));
					System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
				}
		        statement.close ();   
			}catch(SQLException e) {
				throw e;
			}
			return studentList;
		}
		
		public List<Studentssi> display()throws SQLException{
			String sql = "select * from StudentTab  ;";
			List<Studentssi>studentList = new ArrayList<Studentssi>();
			Statement statement;
			try {
				Connection conn = DriverManager.getConnection(url,uname,pword  );
				statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);

				while(resultSet.next()) {
					studentList.add(new Studentssi(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));
					System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
				}
		        statement.close ();   
			}catch(SQLException e) {
				throw e;
			}
			return studentList;
		}
		

	public static void main(String[] args) {
		

	}

}