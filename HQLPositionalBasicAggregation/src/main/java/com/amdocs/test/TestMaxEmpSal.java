package com.amdocs.test;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.amdocs.util.HibernateUtil;

public class TestMaxEmpSal {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		try {

			//1. String HQL 
//			String hql = "select max(empSal) from com.amdocs.model.Employee ";
//			String hql = "select min(empSal) from com.amdocs.model.Employee ";
			String hql = "select avg(empSal) from com.amdocs.model.Employee ";

			// 2. Create Query Object
			Query q = ses.createQuery(hql);

			//3. call method list()
			Object ob = q.uniqueResult();
			//	Integer i = (Integer)ob; [ClassCastException:java.lang.Long cannot be cast to class java.lang.Integer  ] 
			double l = (double)ob;		// Result of "count" is always "Long" Type in DB
			System.out.println("MAX SAL is : "+l);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}

