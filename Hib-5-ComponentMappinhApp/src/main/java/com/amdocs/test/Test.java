package com.amdocs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.model.Address;
import com.amdocs.model.Customer;
import com.amdocs.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses)	// JDK  
		{
			tx = ses.beginTransaction();
			
			Customer c = new Customer();
			c.setCustId(101);
			c.setCustName("Sagar");
			
			Address add = new Address();
			add.setHno("BL-123");
			add.setLoc("ind");
			
			c.setAddr(add);
			ses.save(c);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
