package com.amdocs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.model.Student;
import com.amdocs.util.HibernateUtil;

public class TestDelete {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) {
			
			tx = ses.beginTransaction();
/*
			Student s1 = new Student(10, "Prashant", 3.3);
			Student s2 = new Student(11, "Ashish", 5.3);
			Student s3 = new Student(12, "Sagar", 8.3);

			ses.save(s1);
			ses.save(s2);
			ses.save(s3);
*/
			Student s = new Student();
			s.setSid(11);
			/**
			 *	 It will take (OBJECT having PRIMARYKEY) as Parameter
			 *  OBJECT to identify TABLE & PK to identify ROW
			 *  It will Generate first SELECT SQL, then Generate DELETE QUERY
			 *  coz it will search for PK first if exist then delete otherwise wont
			 */
			ses.delete(s);
			
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
