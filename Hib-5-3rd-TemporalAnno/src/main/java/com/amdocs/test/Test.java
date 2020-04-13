package com.amdocs.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.amdocs.model.Product;

public class Test {

	public static void main(String[] args) {
		try {
			
			Configuration cfg = new Configuration();
			cfg.configure("myconfig.xml");
			SessionFactory sf = cfg.buildSessionFactory();
			Session ses = sf.openSession();
			Transaction tx = ses.beginTransaction();
			
			Product p = new Product();
			p.setProdId(10);
			p.setProdName("A");
			p.setProdMrp(50.3);
			
			Date date = new Date(System.currentTimeMillis());
			
			p.setMfgDate(date);
			p.setExpDate(date);
			p.setTestSlot(date);
			
			ses.save(p);
			tx.commit();
			
			ses.close();
			
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
