package com.amdocs.test;

import java.io.FileInputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.amdocs.model.Student;

public class Test {

	public static void main(String[] args) {
		try {
			Configuration cfg = new Configuration().configure();
			SessionFactory sf = cfg.buildSessionFactory();
			Session ses = sf.openSession();
			Transaction tx = ses.beginTransaction();

			FileInputStream fis = new FileInputStream("C:/Users/Prashant/Desktop/warehouse_img/1.jpg");
			byte[ ] arr = new byte[ fis.available()];
			fis.read(arr); // load file into byte[ ]
			
			String longtxt = "Hi, How are you idsjsdhhjgdshhgdhlllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllldg";
			char [ ] carr = longtxt.toCharArray();
			
			Student s = new Student();
			s.setStdId(101);
			s.setStdName("prashant");
			s.setStdFee(3.3);
			s.setStdImg(arr);
			s.setStdCv(carr);
			
			ses.save(s);
			tx.commit();
			ses.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
