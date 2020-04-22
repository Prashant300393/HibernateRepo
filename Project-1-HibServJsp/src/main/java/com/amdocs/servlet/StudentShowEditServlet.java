package com.amdocs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.dao.IStudentDao;
import com.amdocs.dao.impl.StudentDaoImpl;
import com.amdocs.model.Student;

@WebServlet("/edit")
public class StudentShowEditServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// read the ID from the HyperLink
		int id = Integer.parseInt(req.getParameter("id"));
		
		// create Dao obj and call the Dao method
		IStudentDao dao = new StudentDaoImpl();
		Student std = dao.getOneStudent(id);
		
		// send Data to UI
		req.setAttribute("ob", std);
		
		// Dispatch to Edit Page
		RequestDispatcher rd = req.getRequestDispatcher("Edit.jsp");
		rd.forward(req, resp);
	}
	
}
