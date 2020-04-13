package com.amdocs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) {
			tx = ses.beginTransaction();
			
			Employee e1 = new Employee();
			e1.setEmpName("Renuka");
			e1.setEmpSal(9.8);
			
			ses.save(e1);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
