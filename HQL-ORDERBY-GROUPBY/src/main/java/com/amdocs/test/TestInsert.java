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
			e1.setEmpId(121);
			e1.setEmpName("Rahul");
			e1.setEmpSal(25.42);
			e1.setEmpDept("DEV");

			Employee e2 = new Employee();
			e2.setEmpId(113);
			e2.setEmpName("Simran");
			e2.setEmpSal(43.55);
			e2.setEmpDept("HR");

			Employee e3 = new Employee();
			e3.setEmpId(131);
			e3.setEmpName("Raj");
			e3.setEmpSal(35.3);
			e3.setEmpDept("QA");
			
			ses.save(e1);
			ses.save(e2);
			ses.save(e3);
			
			tx.commit();
		} catch (Exception e) {
			// Standart way to rollback
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
}
