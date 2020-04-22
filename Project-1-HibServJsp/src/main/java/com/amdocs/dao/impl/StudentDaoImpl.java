package com.amdocs.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
	
	@Override
	public List<Student> getAllStudents() {
		String HQL=" from "+Student.class.getName();
		//String HQL=" from in.nit.model.Student ";
		Session ses=HibernateUtil.getSf().openSession();
		List<Student> list=null;
		try(ses) {
			Query q=ses.createQuery(HQL);
			list=q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public String deleteStudent(Integer id) {
		String msg = null;
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) {
			
			tx = ses.beginTransaction();
			
			Student std = new Student();
			std.setStdId(id);
			
			ses.delete(std);	// delete method takes object having PK
			
			msg = "Student '"+id+"' deleted successfully ";
			
			tx.commit();
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			msg = "Student '"+id+"' not Exist";
			e.printStackTrace();
		}
		return msg;
	}
	
	@Override
	public Student getOneStudent(Integer id) {
		Session ses = HibernateUtil.getSf().openSession();
		Student s = null;
		try {
			
			s = ses.get(Student.class, id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	@Override
	public String updateStudent(Student s) {
		String msg = null;
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
				
		try(ses) {
			
			tx = ses.beginTransaction();
			
			ses.update(s);
			
			tx.commit();
			msg = "Student '"+s.getStdId()+"' Updated";
			
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			msg = "Student '"+s.getStdId()+"' Updated";
			e.printStackTrace();
		}
		
		return msg;
	}
}