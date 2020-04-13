package com.amdocs.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class TestOneColumn {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		try(ses){
			
			// 1. Define Hql
			String hql = "SELECT empName FROM "+Employee.class.getName();
			
			// 2. Create Query Object using ses
			Query<String> q = ses.createQuery(hql);
			
			// 3. call Query method to get the Data "list():List<T>"
			List<String> list = q.list();
			
			list.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
