package com.amdocs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.model.Customer;
import com.amdocs.util.HibernateUtil;

public class TestJpaMethods {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) {
			tx = ses.beginTransaction();
			
			Customer c = new Customer();
			c.setCustId(101);
			c.setCustName("Prashant");
			c.setCustAmt(40.45);
			
//			ses.persist(c);
	
//			Customer cust = ses.find(Customer.class, 104);
//			System.out.println(cust); // Return NULL if ID dosnt EXIST
			
//			Customer c1 = ses.find(Customer.class, 101);
//			c1.setCustName("Ashu");
			
//			ses.merge(c1); // like UPDATE
			
			Customer c2 = new Customer();
			c2.setCustId(101);
			ses.remove(c2);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
