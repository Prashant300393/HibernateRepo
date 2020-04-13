package com.amdocs.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class Test_In_Operator {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		try {

			//1. String HQL 
			String hql = " from com.amdocs.model.Employee where empId in(:a)";

			// 2. Create Query Object
			Query q = ses.createQuery(hql);

			// 3. Set Parameter as List because we are using "in" operator it takes { Object [ ] or List } as INPUT
			
//			q.setParameterList("a", new Object[ ] {101,102,10, 11, 12});
//			q.setParameterList("a", Arrays.asList(101,102,103,150,200));
			q.setParameterList("a", List.of(101,102,103,150,200));
			
			//4. call method list()
			List<Employee> emps = q.list();
			
			emps.forEach(System.out::println);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}

