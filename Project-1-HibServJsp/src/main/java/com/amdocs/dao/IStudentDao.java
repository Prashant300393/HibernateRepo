package com.amdocs.dao;

import java.util.List;

import com.amdocs.model.Student;

public interface IStudentDao {

		/**
		 * This Method takes model class object as input
		 * and returns PrimaryKey(Integer as)Output
		 * 
		 */
		public Integer saveStudent(Student s);
		
		/**
		 *  This Method Fetch all the Rows from DB as List<Student>
		 */
		public List<Student> getAllStudents();
		
		/**
		 *  This Method Delete a Row from DB
		 */
		public String deleteStudent(Integer id);
	
		/**
		 *  This Method Fetch one Row Data from DB based on PK value
		 */
		public Student getOneStudent(Integer id);
		
		/**
		 * This Method Update one Row based on the Student obj
		 */
		public String updateStudent(Student s);
}

