package com.amdocs.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Singleton class

public class HibernateUtil {

	// private Static memeber no one can access
	private static SessionFactory sf = null;
	
	// Instance crated at the Time of Class Loading
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	// Factory Method for Global Access
	public static SessionFactory getSf()
	{
		return sf;
	}
}