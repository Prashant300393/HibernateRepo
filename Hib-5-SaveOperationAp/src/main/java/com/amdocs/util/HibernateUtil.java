package com.amdocs.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

	private static SessionFactory sf;
	
	static {
		sf = new Configuration().configure("myconfigure.xml").buildSessionFactory();
	}

	public static SessionFactory getSf() {
		return sf;
	}

}
