package com.amdocs.test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class TestFetchAll_Where {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		try(ses) {
//			System.out.println("Enter the salary");
//			Scanner sc = new Scanner(System.in);
//			double esal = sc.nextDouble();
			
// 1. In HQL Query Provide INPUTS that comes at Runtime using symbol ?0, ?1, ?2....
			
			String hql = "from "+Employee.class.getName()+" where empSal<=?0 "
								+ " or empName=?1 and empId=?2 ";
			
			// 2. Create Query Object
			Query q = ses.createQuery(hql);
			
			
			// 3. After query Object and Before list() method, SET THE PARAMETERS
			q.setParameter(0, 5.0);
			q.setParameter(1, "Prashant");
			q.setParameter(2, 103);
			
			// 4. Execute using list() method or if only ONE ROW use "uniqueResult()" method
			List<Employee> list = q.list();
			
			list.forEach(System.out::println);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
