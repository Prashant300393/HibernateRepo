package com.amdocs.gen;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
	---Steps--
	#1. Define one public class 
	#2. Implement one interface IdentifierGenerator (I) [org.hibernate.id]
	#3. Override method: generate(..)  which returns Serializable(java.io)
	#4. Define Logic for Generating one Number and return same.
 */

public class MyIdGen1 implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, 
													Object object) throws HibernateException 
	{
		String prefix = "NIT-HIB";
		String fmt = new SimpleDateFormat("MMyyyy").format(new Date());
		int num = new Random().nextInt(10000);
		return prefix+"-"+fmt+"-"+num;
	}
}
