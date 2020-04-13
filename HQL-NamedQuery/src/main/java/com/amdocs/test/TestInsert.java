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
			
			Employee e = new Employee();
			e.setEmpId(202);
			e.setEmpName("Sagar");
			e.setEmpSal(7.8);
			
			ses.save(e);
			
			
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
