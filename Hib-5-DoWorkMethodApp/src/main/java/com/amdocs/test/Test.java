package com.amdocs.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;

import com.amdocs.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) {
			tx = ses.beginTransaction();
			
			int count = ses.doReturningWork(new ReturningWork<Integer>() {

				/**
				 *  doReruningWork method takes "ReturningWork<T>" similar as Work
				 *  but Return type is Generic Type <T>
				 */
				
				@Override
				public Integer execute(Connection con) throws SQLException {
					String sql = "UPDATE PRODTAB SET PCODE='WATCH', PCOST=99.99 WHERE PID=11 ";
					Statement st = con.createStatement();
					int count = st.executeUpdate(sql);
					return count;
				}
			});
			System.out.println(count);
			System.out.println("done updated");
		
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
	
	/**
	 * 	Work interface is also similar but Return Type is Void 
	 */
	
	public static void main1(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses){
			tx = ses.beginTransaction();
			ses.doWork(new Work() {
				
				@Override
				public void execute(Connection con) throws SQLException {
					String sql = "INSERT INTO PRODTAB VALUES (13, 'PENCIL', 8.9)";
					Statement st = con.createStatement();
					int count = st.executeUpdate(sql);
					System.out.println(count);
				}
			});
			System.out.println("done");
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
