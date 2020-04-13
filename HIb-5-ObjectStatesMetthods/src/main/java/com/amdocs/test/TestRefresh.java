package com.amdocs.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;

import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class TestRefresh {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) {
			tx = ses.beginTransaction();

			Employee e = ses.get(Employee.class, 11);
			System.out.println(e);
			System.out.println("before updating");
			ses.doWork(new Work() {
				
				@Override
				public void execute(Connection con) throws SQLException {
					String sql = "UPDATE EMPLOYEE SET ENAME='Prakhar' WHERE EID=11 ";
					
					Statement st = con.createStatement();
					int count = st.executeUpdate(sql);
					System.out.println(count);
				}
			});
			/**
			 * 	Where a database trigger alters the object state upon insert or update
			 *  after executing direct SQL (eg. a mass update) in the same session
			 *  after inserting a Blob or Clob
			 */
			ses.refresh(e);
			
			System.out.println("after updating");
			System.out.println(e);
			
			
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}