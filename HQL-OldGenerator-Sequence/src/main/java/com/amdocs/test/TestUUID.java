package com.amdocs.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class TestUUID {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) {
			tx = ses.beginTransaction();
			
			Employee e1 = new Employee();
			e1.setEmpName("Renuka");
			e1.setEmpSal(9.8);
			
			Serializable s = ses.save(e1);
			String id = (String)s;
			tx.commit();

			System.out.println("Generated id " +id);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
