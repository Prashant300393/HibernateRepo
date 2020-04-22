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

@WebServlet("/update")
public class StudentUpdateServlet extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// read the form Data
		int stdId = Integer.parseInt(req.getParameter("sid"));
		String stdName = req.getParameter("sname");
		double stdFee = Double.parseDouble(req.getParameter("sfee"));
		
		// create Student obj and set the Data
		Student std = new Student();
		std.setStdId(stdId);
		std.setStdName(stdName);
		std.setStdFee(stdFee);
		
		// create Dao obj and call Dao method
		IStudentDao dao = new StudentDaoImpl();
		String msg = dao.updateStudent(std);
		
		// send Msg to UI
		req.setAttribute("msg", msg);
		
		// Fetch old all Data 
		List<Student> list = dao.getAllStudents();
		req.setAttribute("list", list);
		
		//Goto UI Page (Data.jsp)
		RequestDispatcher rd = req.getRequestDispatcher("Data.jsp");
		rd.forward(req, resp);
	}
	
}
