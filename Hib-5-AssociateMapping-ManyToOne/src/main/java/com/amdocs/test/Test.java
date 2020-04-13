package com.amdocs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.model.Contract;
import com.amdocs.model.Quote;
import com.amdocs.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) {
			tx = ses.beginTransaction();
			
			Quote q = new Quote();
			q.setQteId(499);
			q.setQteCode("Q3");
			q.setQteAmt(555.55);
			
			Contract c1 = new Contract();
			c1.setCntId(87);
			c1.setVendor("nit");
			c1.setRegCode("Con43");
			c1.setQob(q);
			
			Contract c2 = new Contract();
			c2.setCntId(88);
			c2.setVendor("hcl");
			c2.setRegCode("Con44");
			c2.setQob(q);

			Contract c3 = new Contract();
			c3.setCntId(89);
			c3.setVendor("hp");
			c3.setRegCode("Con45");
			c3.setQob(q);
			
//			ses.save(q);
//			ses.save(c1);
//			ses.save(c2);
//			ses.save(c3);
						
			/**
			 * 	Child Data also Fetched coz 
			 * Default FETCHTYPE FOR @ManyToOne is "EAGER"
			 * 
			 * if we want Only Parent details then change it to "LAZY"
			 */
			ses.get(Contract.class, 88);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
