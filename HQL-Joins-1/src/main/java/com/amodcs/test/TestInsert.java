package com.amodcs.test;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.model.Model;
import com.amdocs.model.Product;
import com.amdocs.util.HibernateUtil;

public class TestInsert {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();		
		Transaction tx = null;
		try(ses) {
			tx = ses.beginTransaction();
			
			Model m1 = new Model(101, "Red");
			Model m2 = new Model(102, "Blue");
			Model m3 = new Model(103, "Green");
			Model m4 = new Model(104, "Yellow");
			Model m5 = new Model(105, "Cyan");
			
			Product p1 = new Product(10, "A", 3.3, Arrays.asList(m5));
			Product p2 = new Product(11, "B", 4.5, null);
			Product p3 = new Product(12, "C", 9.5, Arrays.asList(m2));
			Product p4 = new Product(13, "D", 8.2, null);
			Product p5 = new Product(14, "E", 6.6, Arrays.asList(m2,m3));
			
			ses.save(m1);
			ses.save(m2);
			ses.save(m3);
			ses.save(m4);
			ses.save(m5);
				
			ses.save(p1);
			ses.save(p2);
			ses.save(p3);
			ses.save(p4);
			ses.save(p5);
			
			tx.commit();
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
}