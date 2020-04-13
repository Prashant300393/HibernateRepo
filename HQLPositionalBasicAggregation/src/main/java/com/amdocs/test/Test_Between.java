package com.amdocs.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class Test_Between {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		try {

			//1. String HQL 
			String hql = " select empName, empSal from "+Employee.class.getName()+" where empId between :a and :b ";

			// 2. Create Query Object
			Query q = ses.createQuery(hql);
			
			// 3. set Parameters
			q.setParameter("a", 103);
			q.setParameter("b", 150);
			
			// 4. call list() method
			List<Object[ ]> arr = q.list();
			for(Object[ ] ob : arr) {
				
				System.out.println(ob[0]+"-----"+ob[1]);
			}
			

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
