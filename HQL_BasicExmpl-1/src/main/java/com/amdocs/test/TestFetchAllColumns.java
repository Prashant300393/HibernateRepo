package com.amdocs.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class TestFetchAllColumns {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		
		try(ses) {
				// 1. Define HQL Stringj
			//	String hql = "select e from "+Employee.class.getName()+" e";
				String hql = "from "+Employee.class.getName();
			
			// 2. Create Query Object using ses object
			@SuppressWarnings("unchecked")
			Query<Employee> q = ses.createQuery(hql);
			
			// 3. execute query using method "list(): List<T>"
			List<Employee> list = q.list();
			
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
