package com.amdocs.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class TestOrderBy {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		try(ses) {
			
			
			// SQL : select * from emptab order by esal;       [ DEFAULT : Ascending Order ] 
			// HQL 
//			String hql = " FROM "+Employee.class.getName()+" ORDER BY empSal";   // Asc Order
			String hql = " FROM "+Employee.class.getName()+" ORDER BY empSal DESC";	 // Desc Order
			
			Query q = ses.createQuery(hql);
			
			List<Employee> emps = q.list();
			
			emps.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
