package com.amdocs.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class TestFetch {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		try(ses) {
			
			System.out.println("from Named Query");

			Query q1 = ses.createNamedQuery("oneemp");	
			
			q1.setParameter("empId", 202);
			
			Object ob = q1.uniqueResult();
			
			Employee e = (Employee)ob;
			System.out.println(e);

//			Query q2 = ses.createNamedQuery("allemps");
//			List<Employee> list = q.list();
//			for(Employee emps : list) {
//				System.out.println(emps);
//			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
