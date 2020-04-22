package com.amdocs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.dao.IStudentDao;
import com.amdocs.dao.impl.StudentDaoImpl;
import com.amdocs.model.Student;

@WebServlet("/all")
public class StudentDataServlet extends HttpServlet{

	@Override
	protected void doGet(
			HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException 
	{
	
		//1. create object to DAO
		IStudentDao dao=new StudentDaoImpl();
		
		//2. call method: getAllStudents
		List<Student> list=dao.getAllStudents();
		
		//3. Send data to UI as attribute
		req.setAttribute("list", list);
		
		//4. Goto UI Page : Data.jsp
		RequestDispatcher rd=req.getRequestDispatcher("Data.jsp");
		rd.forward(req, resp);
		
	}
}