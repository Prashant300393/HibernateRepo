package com.amdocs.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.amdocs.model.Customer;

public class Test {

	public static void main(String[] args) {
		try 
		{
			Configuration cfg = new Configuration();
			cfg.configure();
			SessionFactory sf = cfg.buildSessionFactory();
			Session ses = sf.openSession();
			Transaction tx = ses.beginTransaction();
			
			Customer c = new Customer();
			c.setCustId(10);
			c.setCustName("Ashu");
			c.setCustAddr("Hyd");
			
			ses.save(c);
			tx.commit();
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
