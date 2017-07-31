package com.abc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.abc.Student;

public class StudentDao {
	
	public static Connection getCon(){
		Connection con = null;
		
		try{
			 Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			 
		}catch(Exception e){
			System.out.println(e);
		}
		return con;
	}
	
	public static int save(Student s){
		
		int status=0;
		try{
			Connection con = getCon();
			PreparedStatement ps = con.prepareStatement("insert into student(fname,lname,gender) values (?,?,?)" );
		
			ps.setString(1, s.getFname());
			ps.setString(2, s.getLname());
			ps.setString(3, s.getGender());
			
			status=ps.executeUpdate();
			con.close();
		
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}
