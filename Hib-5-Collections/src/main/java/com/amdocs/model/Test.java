package com.amdocs.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		try {
			Configuration cfg = new Configuration().configure();
			SessionFactory sf = cfg.buildSessionFactory();
			Session ses = sf.openSession();
			Transaction tx = ses.beginTransaction();
			
			
			List<Double> marks = List.of(80.0, 55.0, 46.0);
			Map<String, String>grades=  Map.of("P1", "nit", "P2", "htc");
			Set<String> prjs = Set.of("Proj1", "Proj2");
			
			Student s = new  Student();
			s.setGrades(grades);
			s.setMarks(marks);
			s.setPrjs(prjs);
			s.setStdId(1);
			s.setStdName("a");

			ses.save(s); // Data will be stored in Session Cache first after committing it will Store the Data
			tx.commit(); // Data Will not be stored until we Commit
			ses.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}