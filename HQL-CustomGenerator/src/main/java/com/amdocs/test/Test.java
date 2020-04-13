package com.amdocs.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.amdocs.model.Student;
import com.amdocs.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) {
			tx = ses.beginTransaction();
			
			Student s = new Student();
			s.setStdName("Sagar");
			s.setStdFee(5.4);
			
			Serializable ser = ses.save(s);
			String id = (String)ser;
			tx.commit();
			
			System.out.println(id);
			
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
}