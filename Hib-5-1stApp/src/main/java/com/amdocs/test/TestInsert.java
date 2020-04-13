package com.amdocs.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.amdocs.model.Student;

public class TestInsert {

	public static void main(String[] args) {
		try 
		{
			// 1. Create Configuration class Object
			Configuration cfg = new Configuration();
			// 2.  load cfg.xml
			cfg.configure();
			// 3. Build SessionFactory
			SessionFactory sf = cfg.buildSessionFactory();
			// 4. Open One Session using SessionFactory
			Session ses = sf.openSession();
			// 5. Begin Transaction if is NON-SELECT operation
			Transaction tx = ses.beginTransaction();
			// 6.  Perform save() operation
			Student s = new Student();
			s.setStdId(10);
			s.setStdName("Prashant");
			s.setStdFee(3.3);
			
			ses.save(s);
			
			// 7. commit
			tx.commit();
			
			// close the Session
			ses.close();
			
			System.out.println("done");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
