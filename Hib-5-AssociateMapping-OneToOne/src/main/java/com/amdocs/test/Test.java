package com.amdocs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.model.Employee;
import com.amdocs.model.Pancard;
import com.amdocs.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) {
			tx = ses.beginTransaction();
			
			Pancard p1 = new Pancard();
			p1.setPandId(201);
			p1.setPanNum("BPCPC8354R");
			p1.setPerName("Prashant");
			
			Pancard p2 = new Pancard();
			p2.setPandId(301);
			p2.setPanNum("DGPES5649P");
			p2.setPerName("Ashish");
			
			Employee e1 = new Employee();
			e1.setEmpId(10);
			e1.setEmpName("Prashant");
			e1.setEmpSal(3.3);
			e1.setPan(p1);
			
			Employee e2 = new Employee();
			e2.setEmpId(11);
			e2.setEmpName("Ashish");
			e2.setEmpSal(9.9);
			e2.setPan(p2);

//			ses.save(p1);
//			ses.save(p2);
//			ses.save(e1);
//			ses.save(e2);
			
			/**
			 * 	Child Data also Fetched coz 
			 * Default FETCHTYPE FOR @ManyToOne is "EAGER"
			 * 
			 * if we want Only Parent details then change it to "LAZY"
			 */
			ses.get(Employee.class, 11);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
