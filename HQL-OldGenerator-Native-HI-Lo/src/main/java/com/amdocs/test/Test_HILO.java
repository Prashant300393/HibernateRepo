package com.amdocs.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

/**UnsupportedOperationException: Support for 'hilo' generator has been removed
	
	Removed in 5.2 version
	
	1st row => 2 pow 0   = 1
	2nd row=> 2 pow 15  = 32768
	3rd row onwards = 2pow15 + last row value
	
	3rd row => 32768 + 32768 = 65536
	4th row => 32768 + 65536 = 98304

 */

public class Test_HILO {

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