package com.amdocs.test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.amdocs.model.Employee;
import com.amdocs.util.HibernateUtil;

public class TestStandartUpdate {

	public static void main(String[] args) {
		Session ses = HibernateUtil.getSf().openSession();
		Transaction tx = null;
		Scanner sc = new Scanner(System.in);

		try(ses ; sc) {
			tx = ses.beginTransaction();

			System.out.println("Enter Employee Details");
			// Inputs
			System.out.print("Enter Employee Id:");
			int empId = sc.nextInt();

			System.out.print("Enter Employee Name: ");
			String empName = sc.next();

			System.out.print("Enter Employee Dept: ");
			String empDept= sc.next();

			// Shortest Format for Better Performance
			int count = ses.createQuery(new StringBuilder(" UPDATE ")
									.append(Employee.class.getName())
									.append(" SET empName=:empName, empDept=:empDept ")
									.append(" WHERE empId=:empId ")
									.toString())
									.setParameter("empId", empId)
									.setParameter("empName", empName)
									.setParameter("empDept", empDept)
									.executeUpdate();					;

					if(count!=0) {
						System.out.println("Employee Update successfully");
					}
					else {
						System.out.println("Employee id not found");
					}

					tx.commit();
					
					Employee emp = ses.get(Employee.class, empId);
					System.out.println(emp);
					
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

}
