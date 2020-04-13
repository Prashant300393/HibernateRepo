package com.amdocs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class TestEvictMethod {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();		
		Transaction tx = null;
		try(ses) {
			
			tx = ses.beginTransaction();
			
			Employee e = ses.get(Employee.class, 11);
			System.out.println(e);
			
			boolean exist1 = ses.contains(e);// Returns TRUE if Obj EXIST in Session Cache
			System.out.println(exist1);
			
			/** evict(Object ob)
			 *  Remove this instance from the session cache. Changes to the instance will
			 *  not be synchronized with the database.
			 */
			ses.evict(e);		// Removes the Object from SessionCache
			boolean exist2 = ses.contains(e); 
			System.out.println(exist2);
						
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
