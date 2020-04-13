package com.amdocs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.model.Product;
import com.amdocs.model.Student;
import com.amdocs.util.HibernateUtil;

public class TestSave {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		// JDK 9(AutoClosebale) passing the reference in try Enhanced try-with-resource
		try(ses) {

			tx = ses.beginTransaction();
			
			Product p = new Product(10, "Pen", 2.34);
			Student s = new Student(1, "Prashant", 44.3);
			Student s1 = new Student(2, "Prashant", 44.3); // same key inserting for failing the save() operation
			
			/**
			 * 1. On Calling "save()" method Object will be Stored in Session Cache
			 * 2. Only on "commit()" it will store into DB
			 * 3. Session Cache generally used to reduce the Network calls
			 */
			ses.save(p);
			ses.save(s);
			ses.save(s1); // But if one Object is Failed to INSERT,then complete BATCH is CANCELLED

			/**
			 *  1. At this line INSERT query will be generated and DATA is stored into DB.
			 *  2. For NON-SELECT operations, NO. of Commits = NO. of Network Calls.
			 *  3. Hibernate by Default support BATCH OPERATIONS.
			 *  4. Multiple Objects can be saved in BATCH in 1 "commit()". 
			 */
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}