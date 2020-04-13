package com.amdocs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.model.EmpIdType;
import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) {
			tx = ses.beginTransaction();

			EmpIdType eit = new EmpIdType();
			eit.setEmpId(103);
			eit.setDeptId(11);
			
			Employee e1 = new Employee();
			e1.setEit(eit);
			e1.setEmpCode("QA");
			e1.setEmpName("Sagar");
			e1.setEmpSal(9.8);
			
			ses.save(e1);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
