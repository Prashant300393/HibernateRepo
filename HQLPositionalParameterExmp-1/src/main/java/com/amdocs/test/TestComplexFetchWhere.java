package com.amdocs.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class TestComplexFetchWhere {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		try {
			
			// 1. Define HQL based on where
			String hql = "select empName, empSal from "+Employee.class.getName()+" where empId=?0 and empSal>?1 or empName=?2";
			
			// 2. create Query object
			Query q = ses.createQuery(hql);
			
			// 3. set the Parameters
			q.setParameter(0, 103);
			q.setParameter(1, 5.0);
			q.setParameter(2, "Priyanka");
			// 4. get the Data using Method list()
			List<Object[ ]> arr = q.list();
			
			for(Object[ ] ob : arr) {
				System.out.println(ob[0]+"---------"+ob[1]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
