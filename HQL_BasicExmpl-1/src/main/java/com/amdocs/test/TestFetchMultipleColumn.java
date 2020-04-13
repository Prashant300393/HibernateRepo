package com.amdocs.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class TestFetchMultipleColumn {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();		
		try(ses) {
			
			// 1. Define HQL String
			String hql = "SELECT empId, empName FROM "+Employee.class.getName();
			
			// 2. Create Query Object
			Query q = ses.createQuery(hql);
			
			// 3. Call Query method 
			List<Object [ ]> arr = q.list();
			
			for(Object[ ] ob : arr) {
				System.out.println(ob[0]+"-----"+ob[1]);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
