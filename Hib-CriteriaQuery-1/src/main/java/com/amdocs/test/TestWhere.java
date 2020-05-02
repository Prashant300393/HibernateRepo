package com.amdocs.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.amdocs.model.Student;
import com.amdocs.util.HibernateUtil;

public class TestWhere {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		try(ses) {

			/**
			 *   select sname,course from stdtabs where sname like %h or sfee<>16.7
			 */
			// 1. create CriteriaBuilder using ses.getCriteriaBuilder()
			CriteriaBuilder builder = ses.getCriteriaBuilder();

			// 2. Define Output Type using builder.createQuery()
			CriteriaQuery<Object[ ]> query = builder.createQuery(Object[ ].class);

			// 3. From which table using query.from() which returns Root object
			Root<Student> root = query.from(Student.class);

			// 4. Provide Required columns =>select sname
			query.multiselect(root.get("stdName"), root.get("stdCourse"));

			// 5. Provide where condition	=> where course='Boot'
			query.where
			(
					builder.or
						(
							builder.like(root.get("stdName"), "%h"),
							builder.notEqual
							(
									root.get("stdCourse"),
									"Boot"
							)
						)
			);

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

	public static void main2(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		try(ses) {

			/**
			 *   select sname,course from stdtabs where sname is not null and sfee>8.5
			 */
			// 1. create CriteriaBuilder using ses.getCriteriaBuilder()
			CriteriaBuilder builder = ses.getCriteriaBuilder();

			// 2. Define Output Type using builder.createQuery()
			CriteriaQuery<Object[ ]> query = builder.createQuery(Object[ ].class);

			// 3. From which table using query.from() which returns Root object
			Root<Student> root = query.from(Student.class);

			// 4. Provide Required columns =>select sname
			query.multiselect(root.get("stdName"), root.get("stdCourse"));

			// 5. Provide where condition	=> where course='Boot'
			query.where
			(builder.and
					(
							builder.isNotNull(root.get("stdName")), 
							builder.greaterThan
							(
									root.get("stdFee"), 
									8.5
									)
							)
					);

			/*			query.where(builder.and(
								root.get("stdName").isNotNull(), 
								builder.greaterThan(
											root.get("stdFee"), 
											8.0)
								));
			 */

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

	//***********************************************************************************************\\
	public static void main1(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		try(ses) {

			/**
			 *   select sname from stdtabs where course=?
			 */
			// 1. create CriteriaBuilder using ses.getCriteriaBuilder()
			CriteriaBuilder builder = ses.getCriteriaBuilder();

			// 2. Define Output Type using builder.createQuery()
			CriteriaQuery<String> query = builder.createQuery(String.class);

			// 3. From which table using query.from()
			Root<Student> root = query.from(Student.class);

			// 4. Provide Required columns =>select sname
			query.select(root.get("stdName"));

			// 5. Provide where condition	=> where course='Boot'
			query.where(builder.equal(root.get("stdCourse"), "Boot"));

			// 6. Execute Query using ses.createQuery which returns Query object
			Query<String> qry = ses.createQuery(query);

			// 7. Call list() methiod of Query
			List<String> list = qry.list();

			// 8 . Print the Data
			list.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
