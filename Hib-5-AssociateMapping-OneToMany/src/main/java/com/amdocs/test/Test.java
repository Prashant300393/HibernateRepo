package com.amdocs.test;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.util.HibernateUtil;
import com.amdocs.model.Module;
import com.amdocs.model.Project;;
public class Test {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try {
			
			tx = ses.beginTransaction();
			
			Module m1 = new Module();
			m1.setModId(11);
			m1.setModCode("Mod1");

			Module m2 = new Module();
			m2.setModId(12);
			m2.setModCode("Mod2");

			Module m3 = new Module();
			m3.setModId(13);
			m3.setModCode("Mod3");
			
			Project p = new Project();
			p.setPrjId(101);
			p.setPrjName("NIT");
			p.setMod(Arrays.asList(m1,m2,m3));
			
//			ses.save(p);
//			ses.save(m1);
//			ses.save(m2);
//			ses.save(m3);
			
			/**
			 *  Default FETCHTYPE is "LAZY", because Child Side is Many
			 *  IF we want to FETCH CHILD DATA then, we have to change it to "EAGER"
			 */
			Project prj = ses.get(Project.class, 101);
			System.out.println(prj);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
