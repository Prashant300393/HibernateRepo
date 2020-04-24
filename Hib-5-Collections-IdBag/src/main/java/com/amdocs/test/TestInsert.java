package com.amdocs.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.amdocs.model.Student;
import com.amdocs.util.HibernateUtil;

public class TestInsert {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx  = null;
		try(ses) {
			
			tx = ses.beginTransaction();
			
			Student s = new Student();
			s.setStdName("Prashant");
			s.setStdFee(4.5);
			s.setMarks(Arrays.asList(40,50,60));
			
			ses.save(s); // Data will be stored in Session Cache first after committing it will Store the Data
			tx.commit(); // Data Will not be stored until we Commit
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}