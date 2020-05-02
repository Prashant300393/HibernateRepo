package com.amdocs.test;

import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.amdocs.model.Student;
import com.amdocs.util.HibernateUtil;

public class TestBetweenAndIn{
	
	//************************************IN Operator****************************************\\
	
	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		try(ses) {

			/**
			 *   select sname,course from stdtabs where course in (?,?,?,?)
			 */
			// 1. create CriteriaBuilder using ses.getCriteriaBuilder()
			CriteriaBuilder builder = ses.getCriteriaBuilder();

			// 2. Define Output Type using builder.createQuery()
			CriteriaQuery<Object[ ]> query = builder.createQuery(Object[ ].class);

			// 3. From which table using query.from() which returns Root object
			Root<Student> root = query.from(Student.class);

			// 4. Provide Required columns =>select sname
			query.multiselect(root.get("stdName"), root.get("stdCourse"));

			// 5. Provide where condition	=> where sfee between 10 and 20
			query.where(root.get("stdCourse").in(Arrays.asList("Boot","Spring", "Php",".Net")));
			
			
			// 6. Execute Query using ses.createQuery which returns Query object
			Query<Object[ ]> qry = ses.createQuery(query);

			// 7. Call list() methiod of Query
			List<Object[ ]> list = qry.list();

			// 8 . Print the Data
			for(Object[ ] ob : list) {
				System.out.println(ob[0]+"--"+ob[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		//*************************Between Operator****************************************************\\
	
	public static void main1(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		try(ses) {

			/**
			 *   select sname,sfee from stdtabs where sfee between ? and ?
			 */
			// 1. create CriteriaBuilder using ses.getCriteriaBuilder()
			CriteriaBuilder builder = ses.getCriteriaBuilder();

			// 2. Define Output Type using builder.createQuery()
			CriteriaQuery<Object[ ]> query = builder.createQuery(Object[ ].class);

			// 3. From which table using query.from() which returns Root object
			Root<Student> root = query.from(Student.class);

			// 4. Provide Required columns =>select sname
			query.multiselect(root.get("stdName"), root.get("stdFee"));

			// 5. Provide where condition	=> where sfee between 10 and 20
			query.where(builder.between(root.get("stdFee"), 10, 20));
			
			
			// 6. Execute Query using ses.createQuery which returns Query object
			Query<Object[ ]> qry = ses.createQuery(query);

			// 7. Call list() methiod of Query
			List<Object[ ]> list = qry.list();

			// 8 . Print the Data
			for(Object[ ] ob : list) {
				System.out.println(ob[0]+"--"+ob[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}// class
