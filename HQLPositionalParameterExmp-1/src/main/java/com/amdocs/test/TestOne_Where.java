package com.amdocs.test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class TestOne_Where {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		try(ses){
			System.out.println("Enter eid to get the Data");
			Scanner sc = new Scanner(System.in);
			int eid = sc.nextInt();
			
			
			// 1. Define Hql based on WHERE Condition
			String hql = "FROM "+Employee.class.getName()+" WHERE empId=?0 ";
			
			// 2. Create Query Object using ses
			Query q = ses.createQuery(hql);
			
			// 3. Set the Parameter (Input) to HQL
			q.setParameter(0, eid);
			
			// 4. if One Row Data is there call method "uniqueResult(): Object"
			Object ob = q.uniqueResult();
			System.out.println(ob); // compileTime objClass runtime IMPLclass toString is called ...[ dynamicPolymorphism ]

			/**
			 * before DownCasting make sure that HOW MANY COLUMNS YOU WANT 
			 * i.e. 1. If u want All Columns then Downcast to ModelClass<T>
			 * 		  2. If u want ONE Column then Downcast to Particuler DATATYPE (Integer , String, ..)
			 * 		  3. If u want <1 Column but not All Columns then Downcast to Object[ ] 
			 */
			
//			Employee e = (Employee)ob;
//			System.out.println(e);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
