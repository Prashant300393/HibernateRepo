package com.amdocs.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

/**
 * IF HIBERNATE FETCHES LARGE AMOUNT OF DATA (RECORDS) FROM THE DATABASE, 
 * IT CONSUMES LOT OF MEMORY. TO CONSUME LESS RAM MEMORY, THE DATA CAN BE 
 * OBTAINED IN INSTALLMENTS FROM THE DATABASE. ONE SOLUTION IS USING "PAGINATION"
 */


public class TestFetchPagination {

	/**
	 * The idea behind PAGINATION Hibernate is to DIVIDE the Large RESULT SET into a NUMBER of PAGES and 
	 * Fetching ONE PAGE at a TIME. We can programmatically declare how many records should contain 
	 * each page and from what record.
	 * 
	 * ADVANTAGE : 
	 * --------------------
	 * It SAVES TIME also (or INCREASES PERFORMANCE); 
	 * for a NUMBER OF RECORDS (ONE PAGE) only ONE DATABASE HIT is made.
	 */
	
	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		try(ses) {
			int pn = 1;	// here 1st Page means Page 0(zero) in Java
			int ps = 5;	// max Rows contains in One Page
			
			String hql = " from " + Employee.class.getName();
			
			Query q = ses.createQuery(hql);
			
			// This Fetching is According to Page Number(Starting from Zero in Java)
			q.setFirstResult((pn-1)*ps);
			q.setMaxResults(ps);
			
//			This Fetching is According to Index Number of DATA in DB(ie Starting from zero(0))
//			q.setFirstResult(9);
//			q.setMaxResults(2);
			
			List<Employee> emps = q.list();
			
			for(Employee e: emps) {
				System.out.println(e);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
