package com.amodcs.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.amdocs.util.HibernateUtil;

public class TestRightJoin {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();		
		try(ses) {

/**		SELECT 	<PARENT.COLUMN-1> , <PARENT.COLUMN-2>, <CHILD.COLUMN-1>, <CHILD.COLUMN-2>
 * 		
 * 		FROM      <Full Parent Model Class Name>
 * 							<Join Type>
 * 						<PARENT.HAS-A-VARAIBLE>
 * 		
 * 		WHERE    <CONDITION>		
 */
//			Right(Child) side Table All Data and its Connected Data of Left(Parent) side Table will be Fetched			
			String hql = " SELECT pob.prodCode, pob.prodCost, m.modColor  "
							 + "  FROM com.amdocs.model.Product AS pob "
							 + "  RIGHT OUTER JOIN "	// RIGHT JOIN
							 + "   pob.mobs AS m";
			
			Query q = ses.createQuery(hql);
			
			List<Object[ ]> arr = q.list();
			
			for(Object[ ] ob : arr) {
				System.out.println(ob[0]+"------"+ob[1]+"-----"+ob[2]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
