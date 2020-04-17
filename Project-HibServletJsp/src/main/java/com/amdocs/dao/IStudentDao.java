package com.amdocs.dao;

import com.amdocs.model.Student;

public interface IStudentDao {

	/**
	 * This Method takes model class object as input
	 * and returns PrimaryKey(Integer as)Output
	 * 
	 */
	public Integer saveStudent(Student s);
}