package com.amdocs.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class TestNative {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) {
			tx = ses.beginTransaction();
			
			Employee e1 = new Employee();
			e1.setEmpName("Rishu");
			e1.setEmpSal(9.5);
			
			Serializable s = ses.save(e1);
			Integer id = (Integer)s;
					
			tx.commit();
			System.out.println(id);
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}