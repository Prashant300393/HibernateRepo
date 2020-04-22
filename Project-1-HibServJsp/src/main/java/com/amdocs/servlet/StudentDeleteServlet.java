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

@WebServlet("/delete")
public class StudentDeleteServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// read the Id coming from HyperLink
		int id = Integer.parseInt(req.getParameter("id"));
		
		// create Student obje and set the ID coming from hyperlink
		Student std = new Student();
		std.setStdId(id);
		
		// call the Dao method
		IStudentDao dao = new StudentDaoImpl();
		String msg = dao.deleteStudent(id);
		
		// Send msg to UI 
		req.setAttribute("msg", msg);
		
		// Fetch all the Data again to Display
		List<Student> list = dao.getAllStudents();
		req.setAttribute("list", list);
		
		// Goto UI Page : Data.jsp
		RequestDispatcher rd = req.getRequestDispatcher("Data.jsp");
		rd.forward(req, resp);
		
	}
	
}
