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
			c.setCustMail("ad3435r@gmail.com");
			c.setCustMob("79874647");
			c.setCustSource("Online");
			c.setCustSpouse("prinka");
			
			ses.save(c);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
