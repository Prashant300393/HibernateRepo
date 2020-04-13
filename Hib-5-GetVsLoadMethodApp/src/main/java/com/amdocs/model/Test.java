package com.amdocs.model;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		Session ses = HibernateUtil.getSf().openSession();
		try(ses) // JDK 1.9 Enhanced try with Resources
		{
			/**
			 *  get(class, id), when called for First time, goto Session Cache search for 
			 *  the Object, not there, Make a n/w call, get the Persistent Object stores it
			 *  in Session Cache.and given back to the App
			 *  
			 *  from 2nd time onwards, it will return the Persistent Object from the Cache
			 *  Generate SQL QUERY only ONE Time if we call GET method FOR SAME OBJECT
			 *  
			 *  IF ROW NOT FOUND , Returns the NULL
			 */
			Employee e = ses.get(Employee.class, 3);
			Employee e2 = ses.get(Employee.class, 3);
			System.out.println(e);

			/**
			 * load(class, id) On calling this method, it creates Proxy(dummy) Object in 
			 * Session Cache and sets the PK(id) in Proxy and returns same back to App.
			 * 
			 *  it is try to save the N/w calls for Unused Persistent Object
			 *  
			 *  When we try to use the Persistent Object or any Property of that Object 
			 *  other than PK(id) then N/w call is made with SELECT SQL, fill the Data 
			 *  back to in Proxy, Return same to Hibernate App
			 *  
			 *  if we try to use PK(id) it will return the Same from the Proxy,
			 *  it will never execute any SELECT SQL
			 *  
			 *  THROWS ObjectNotFoundException IF Row not Found
			 */
						
//			Employee emp = ses.load(Employee.class, 5);
//			System.out.println("done");
//			System.out.println(emp.getEmpId());
//			System.out.println(emp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}