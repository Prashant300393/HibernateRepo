package com.amdocs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class TestInsert {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) {
			tx = ses.beginTransaction();
			
			Employee e1 = new Employee();
			e1.setEmpId(101);
			e1.setEmpName("Prashant");
			e1.setEmpSal(3.3);
			

			Employee e2 = new Employee();
			e2.setEmpId(102);
			e2.setEmpName("Ashish");
			e2.setEmpSal(4.3);
			

			Employee e3 = new Employee();
			e3.setEmpId(103);
			e3.setEmpName("Sagar");
			e3.setEmpSal(5.3);
			
			ses.save(e1);
			ses.save(e2);
			ses.save(e3);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
