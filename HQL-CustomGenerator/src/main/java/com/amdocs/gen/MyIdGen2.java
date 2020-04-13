package com.amdocs.gen;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyIdGen2 implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, 
												   Object object) throws HibernateException 
	{
		String prefix = "NIT-HIB";
		String fmt = new SimpleDateFormat("MMyyyyhhmmssSSS").format(new Date());
		int num = new Random().nextInt(10000);
		
		return prefix+"-"+fmt+"-"+num;
	}
}
