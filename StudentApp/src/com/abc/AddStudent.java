package com.abc;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	PrintWriter out = response.getWriter();
	
	String fname= request.getParameter("afirstname");
	String lname= request.getParameter("alastname");
	String gender= request.getParameter("agender");
	
	Student s=new Student();
	s.setFname(fname);
	s.setLname(lname);
	s.setGender(gender);
	
	
	int status=StudentDao.save(s);
	if(status>0){
		
		response.sendRedirect("Added.html");  
	}
	else{
		out.print("Unable to add Student!");
	}
	
	out.close();
}
	
}
