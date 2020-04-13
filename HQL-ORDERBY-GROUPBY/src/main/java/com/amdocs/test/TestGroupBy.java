package com.amdocs.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class TestGroupBy {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		try(ses) {
			
		// SQL : select count(dept), dept from emptab group by dept;
	//	String hql = "SELECT COUNT(empSal), empSal FROM "+Employee.class.getName()+" GROUP BY empSal";
	//	String hql = "SELECT max(empSal), empDept FROM "+Employee.class.getName()+" GROUP BY empDept";
	//	String hql = "SELECT sum(empSal), empDept FROM "+Employee.class.getName()+" GROUP BY empDept";
		String hql = "SELECT avg(empSal), empDept FROM "+Employee.class.getName()+" GROUP BY empDept";
		
		Query q = ses.createQuery(hql);
		
		List<Object[ ]> arr = q.list();
		
		for(Object[ ] ob : arr) {
			System.out.println(ob[0]+"--------"+ob[1]);
		}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


