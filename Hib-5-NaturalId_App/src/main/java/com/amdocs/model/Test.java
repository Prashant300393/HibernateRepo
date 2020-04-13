package com.amdocs.model;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) {
			
			tx = ses.beginTransaction();
			
			Employee e = new Employee();
			e.setEmpId(10);
			e.setEmpCode("E123");
			e.setEmpName("Prashant");
			e.setEmpSal(3.3);
			
//			ses.save(e);
			/**
			 *   bySimpleNaturalId(class).load(naturalId) is a method to fetch Data based on
			 *   NATURAL ID
			 *   
			 *   First Hibernate Checks for "NaturalId" means Generate SELECT SQL 
			 *   for checking NaturalId is exist or not ? 
			 *   
			 * 	 If Exist then It gets The Pk(id) based on Natural Id and then generate
			 *   SELECT SQL to get the Employee based on Id;
			 */
				
			Employee emp = ses.bySimpleNaturalId(Employee.class).load("E123");
			
			System.out.println(emp);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
