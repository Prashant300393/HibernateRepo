package com.amdocs.model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.amdocs.util.HibernateUtil;

public class TestDelete {

	public static void main(String[ ] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;	
		try(ses) {
			tx = ses.beginTransaction();
			// 1. Define HQL String
			// SQL : DELETE FROM EMPTAB WHERE ENAME IS NULL
//			String hql = " DELETE FROM "+Employee.class.getName()+" WHERE empName IS NULL";
			String hql = " DELETE FROM "+Employee.class.getName()+" WHERE empId between :a and :b";
			
			// Create Query Object
			Query q = ses.createQuery(hql);
			
			// Set Parameters
			q.setParameter("a", 115);
			q.setParameter("b", 120);
			
			// Call executeUpdate() method of Query
			int count = q.executeUpdate();
						
			tx.commit();
			System.out.println("done "+count);
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
}
