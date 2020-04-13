package com.amdocs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.model.Employee;
import com.amdocs.model.Person;
import com.amdocs.model.Student;
import com.amdocs.util.HibernateUtil;

/**			TABLE_PER_SUB_CLASS (JOINED)
 * 
 * 	It means ONE Table is created for "PARENT CLASS" and for every "SUB CLASS"
 * 	ONE CHILD TABLE is created.
 * 
 * Every CHILD TABLE is connected to its PARENT TABLE using one Extra Column
 * 	"PrimaryKeyJoinColumn".
 * 
 * If we take SUB-CLASS OBJECT which Holds SUPERCLASS Data & SUBCLASS Data
 * then , Hibernate INSERT SUPERCLASS Data at "Parent Table" and SUBCLASS Data
 * at "CHILD TABLE"
 */
public class Test {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try(ses) {
			tx = ses.beginTransaction();

			Person p = new Person();
			p.setPerId(10);
			p.setPerName("Ashu");
			
			Student s = new Student();
			s.setPerId(11);
			s.setPerName("Prashu");
			s.setStdFee(3.3);
			s.setStdGrd("A");
			
			Employee e = new Employee();
			e.setPerId(12);
			e.setPerName("Aditi");
			e.setEmpDept("HR");
			e.setEmpSal(5.5);
			
			ses.save(p);
			ses.save(s);
			ses.save(e);
	
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
