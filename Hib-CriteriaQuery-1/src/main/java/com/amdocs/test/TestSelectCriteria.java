package com.amdocs.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.amdocs.model.Student;
import com.amdocs.util.HibernateUtil;

public class TestSelectCriteria {


	public static void main(String[] args) {

		Session ses = HibernateUtil.getSf().openSession();
		try(ses) {

			/** Multiple Columns, bt not all (Object[ ].class)
			 * SELECT * FROM STDTABS;
			 */

			// 1. Create CriteriaBuilder obj using Session
			CriteriaBuilder builder = ses.getCriteriaBuilder();

			// 2. Define Output type using CriteriaBuilder which returns CriteriaQuery
			CriteriaQuery<Student> query = builder.createQuery(Student.class);

			// 3. from() which table using CriteriaQuery which returns Root<T>
			Root<Student> root = query.from(Student.class);

			// 4. Select the required columns using [ query.multiselect(root.get(-,-)) ] for Object[ ] 
			query.select(root);

			// 5. Execute the query using createQuery() method of Session returns Query<T> object
			Query<Student> qry = ses.createQuery(query);
			
			//6 Call list() method of Query obj
			List<Student> list = qry.list();
			
			// 7 Print the Data
			list.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	public static void main2(String[] args) {

		Session ses = HibernateUtil.getSf().openSession();
		try(ses) {

			/** Multiple Columns, bt not all (Object[ ].class)
			 * SELECT SNAME, COURSE, SFEE FROM STDTABS;
			 */

			// 1. Create CriteriaBuilder obj using Session 
			CriteriaBuilder builder = ses.getCriteriaBuilder();

			// 2. Define Output type using CriteriaBuilder which returns CriteriaQuery
			CriteriaQuery<Object[ ]> query = builder.createQuery(Object[ ].class);

			// 3. from() which table using CriteriaQuery which returns Root<T>
			Root<Student> root = query.from(Student.class);

			// 4. Select the required columns using [ query.multiselect(root.get(-,-)) ] for Object[ ] 
			query.multiselect(root.get("stdName"), root.get("stdCourse"), root.get("stdFee"));


			// 5. Execute the query using createQuery() method of Session returns Query<T> object
			Query<Object[ ]> qry = ses.createQuery(query);

			//6 Call list() method of Query obj
			List<Object[ ]> list = qry.list();

			// 7 Print the Data
			for(Object[ ] ob : list) {
				System.out.println(ob[0]+"--"+ob[1]+"--"+ob[2]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main1(String[] args) {

		Session ses = HibernateUtil.getSf().openSession();
		try(ses) {

			/**		Only 1 column [ String.class ]
			 * SELECT SNAME FROM STDTABS;
			 */

			// 1. Create CriteriaBuilder obj using Session 
			CriteriaBuilder builder = ses.getCriteriaBuilder();

			// 2. Define Output type using CriteriaBuilder which returns CriteriaQuery
			CriteriaQuery<String> query = builder.createQuery(String.class);

			// 3. from which table using CriteriaQuery which returns Root<T>
			Root<Student> root = query.from(Student.class);

			// 4. Select the required columns using query.select(root.get(-)) for one column
			query.select(root.get("stdName"));

			// 5. Execute the query using createQuery() method of Session returns Query<T> object
			Query<String> qry = ses.createQuery(query);
			//6 Call list() method of Query obj
			List<String> list = qry.list();
			// 7 Print the Data
			list.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
