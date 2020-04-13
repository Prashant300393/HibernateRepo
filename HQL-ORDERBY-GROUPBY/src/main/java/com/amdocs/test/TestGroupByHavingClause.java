package com.amdocs.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class TestGroupByHavingClause {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		try(ses) {
			
			/**
			 *  If we are using GROUP BY concept then we can not
			 *  use WHERE clause, go for HAVING which behaves like
			 *  WHERE condition.
			 */
// SQL : SELECT COUNT(eid),ename,dept FROM emptab GROUP BY dept,ename HAVING ename IS NULL;

//			String hql = " select count(empId), empName, empDept from "+Employee.class.getName()+" group by empDept, empName having empName is null";
			String hql = " select count(empId), empName, empDept from "+Employee.class.getName()+" group by empDept, empName having empName is not null";
			
			Query<Object[ ]>  q = ses.createQuery(hql);
			
			List<Object[ ]> arr = q.list();
			
			for(Object[ ] ob : arr) {
				System.out.println(ob[0]+"-----"+ob[1]+"-----"+ob[2]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
