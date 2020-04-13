package com.amdocs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.model.Product;
import com.amdocs.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) {
			tx = ses.beginTransaction();

//			@DynamicInsert will generate Query at Runtime using variable having NON-NULL VALUES
//			Product p1 = new Product();
//			p1.setProdId(10);
//			p.setProdCode("Pen");  // NULL DEFAULT VALUE
//			p1.setProdCost(4.4);
//			ses.save(p1);
			
//			@DynamicUpdate will generate "UPDATE" SQL for MODIFIED Values Only, not for all..
			Product p2 = ses.get(Product.class, 10);
			p2.setProdCode("BOX");
			
			ses.update(p2);
						
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
