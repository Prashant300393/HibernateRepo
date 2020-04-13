package com.amodcs.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.amdocs.util.HibernateUtil;

public class TestInnerJoin {

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
			
//			Only Connected Data From Both Table will be Fetched			
			String hql = " SELECT pob.prodCode, pob.prodCost, mobs.modColor  "
							 + "  FROM com.amdocs.model.Product AS pob "
							 + "  INNER JOIN "
							 + "   pob.mobs AS mobs";
			
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
