package com.amdocs.model;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) // JDK 1.9 Enhanced try with Resources
		{
			tx=ses.beginTransaction();
			
			Employee e = new Employee();
			e.setEmpId(1);
			e.setEmpName("Ashish");
			e.setEmpSal(3.3);
			
			Employee e1 = new Employee();
			e1.setEmpId(2);
			e1.setEmpName("Sagar");
			e1.setEmpSal(3.5);
			
			/**
			 * First it will Generate SELECT SQL based on that it will execute the Query, 
			 * if PK is present execute "ses.update(ob)", if PK is not Present "ses.save(ob)" 
			 */
			
//			ses.saveOrUpdate(e1); 
			
			/**
			 *  It will Execute the Update Query and Update the Data based on PK 
			 */
			
			ses.update(e);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}