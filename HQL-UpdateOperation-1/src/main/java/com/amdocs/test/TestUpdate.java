package com.amdocs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class TestUpdate {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) {
			tx = ses.beginTransaction();
			// Define HQL 
			String hql = " UPDATE "+Employee.class.getName()+" SET empName=:empName, empDept=:empDept "
									+" WHERE empId=:empId ";
					
			// create Query Object
			Query q = ses.createQuery(hql);			
			
			q.setParameter("empName", "Daada");
			q.setParameter("empDept", "OPR");
			q.setParameter("empId", 101);
						
			// call Query method [ int executeUpdate() ] 
			int count = q.executeUpdate();
			
			tx.commit();
			System.out.println(count);
			
			Employee emp = ses.get(Employee.class, 101);
			System.out.println(emp);
			
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
}
