package com.amdocs.test;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.model.Course;
import com.amdocs.model.Student;
import com.amdocs.util.HibernateUtil;

public class Test {


	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) {

			tx = ses.beginTransaction();
			
			Course c1 = new Course();
			c1.setCrsId(10);
			c1.setCrsName("HIB");
			c1.setCrsFee(1200);
			
			Course c2 = new Course();
			c2.setCrsId(11);
			c2.setCrsName("BOOT");
			c2.setCrsFee(2000);

			Course c3 = new Course();
			c3.setCrsId(12);
			c3.setCrsName("SPRING");
			c3.setCrsFee(1500);

			Student s1 = new Student();
			s1.setStdId(101);
			s1.setStdName("Prashant");
			s1.setStdMail("pc@gmail.com");
			s1.setCob(Arrays.asList(c1,c2));


			Student s2 = new Student();
			s2.setStdId(102);
			s2.setStdName("Ashish");
			s2.setStdMail("ashu@gmail.com");
			s2.setCob(Arrays.asList(c2,c3));

			Student s3 = new Student();
			s3.setStdId(103);
			s3.setStdName("Aditi");
			s3.setStdMail("adi@gmail.com");
			s3.setCob(Arrays.asList(c1,c3));

			
//			ses.save(c1);
//			ses.save(c2);
//			ses.save(c3);
//			
//			ses.save(s1);
//			ses.save(s2);
//			ses.save(s3);
			
			
			/**
			 *  Default FETCHTYPE is "LAZY", because Child Side is Many
			 *	 
			 *  IF we want to FETCH CHILD DATA then, we have to change it to "EAGER"
			 */
			ses.get(Student.class, 101);	
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
