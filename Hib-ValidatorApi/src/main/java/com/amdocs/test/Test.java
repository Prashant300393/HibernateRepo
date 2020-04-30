package com.amdocs.test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.model.Person;
import com.amdocs.util.HibernateUtil;

public class Test {

		public static void main(String[] args) {
			Session ses = HibernateUtil.getSf().openSession();
			Transaction tx = null;
			try(ses) {
				
				tx = ses.beginTransaction();
				
				Person per = new Person();
//				per.setPname("PRAS");		// Name must be 2 to 5 chars
//				per.setPname("    ");			// 2 to 5 empty spaces are  also allowed
//				per.setPname("Pras24AA");	// min=1 char, max=n chars only Upper/lower and digits allowed
	
//				per.setStatus(false);
				
//				per.setVoterAge(170);
				
/*				Date date = new Date( 100, 11, 30);
				Date date = new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
				System.out.println(date.toLocaleString());
				per.setDob(date);
*/				
				
/*//			Date date = new Date( 600, 11, 30);
				Date date = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(365));
				System.out.println(date.toLocaleString());
				per.setDateOfExp(date);
*/				
				
//				per.setPname("   ");
				ses.save(per);
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			}
		}
}
