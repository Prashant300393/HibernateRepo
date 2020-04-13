package com.amdocs.model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.amdocs.util.HibernateUtil;

public class TestDeleteShortestFormat {

	public static void main(String[ ] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;	
		try(ses) {
			tx = ses.beginTransaction();
			// 1. Define HQL String
			String hql = " DELETE FROM "+Employee.class.getName()+" WHERE empId>=:empId";
			
			
			int count = ses.createQuery(hql)
									.setParameter("empId", 105)
									.executeUpdate()	;
			
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
