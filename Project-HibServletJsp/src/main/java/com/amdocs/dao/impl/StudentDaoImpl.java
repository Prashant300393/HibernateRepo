package com.amdocs.dao.impl;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.dao.IStudentDao;
import com.amdocs.model.Student;
import com.amdocs.util.HibernateUtil;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public Integer saveStudent(Student s) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		Integer id=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			//operations
			id=(Integer) ses.save(s);
			
			tx.commit();
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return id;
	}

}