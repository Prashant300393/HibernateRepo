package com.amdocs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.model.Employee;
import com.amdocs.model.Person;
import com.amdocs.model.Student;
import com.amdocs.util.HibernateUtil;

/**			TABLE_PER_CLASS_HIERARCHY
 * 	It is also called "SINGLE_TABLE". Hibernate creates only one TABLE for all classes
 * 	which are connected using IS-A relation.
 *
 *	No of Columns = Sum of all classes variables + 1 Extra Col (DiscriminatorColumn)
 *
 *  DiscriminatorColumn is used to indicate "Current row is related to which class".
 *  It is optional, Default column name is DTYPE of type STRING
 */
public class Test {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) {
			tx = ses.beginTransaction();
			
			Student s = new Student();
			s.setPerId(11);
			s.setPerName("Prashant");
			s.setStdFee(3.3);
			s.setStdGrd("A");
			
			Employee e = new Employee();
			e.setPerId(12);
			e.setPerName("Sagar");
			e.setEmpDept("QA");
			e.setEmpSal(4.4);
			
			Person p = new Person();
			p.setPerId(10);
			p.setPerName("Ashish");
			
			ses.save(p);
			ses.save(e);
			ses.save(s);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
