package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 	IDENTITY : It uses Database Specific Increment concept.
    ie also called as "AutoIncrement" (max+1 done at DB side)
    AutoIncrement concept should be supported by DB.
    If DB is not supporting AutoIncrement then it is not going to work.
        
    Legacy Increment (max+1) is done at Hibernat App (So,works for all DB)
     -> Hibernate App executing select max(*) from table SQL
     -> Hibernate adding +1 to max value
     -> Hibernate providing that value to DB
 	---------------------------------------------------------------------------------------------------------
 	
 	TABLE : In this case, one table is created at Database that hold NEXT
    			   Primary Key value should be given to save() operation.
 	
   Default Table Name    	 :  hibernate_sequences
   Default Column Name  :  next_val
   Default Initial Value 		 :  0
   Default Step Value    	 :  +1
   
    @TableGenerator(name="xyz", table = "sample_data", valueColumnName = "next_data", initialValue = 0,
								  allocationSize = 1)
 	
 */

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "emp")
	@TableGenerator(name = "emp", table = "tab_data" ,valueColumnName = "next_data", 
								 initialValue = 2, allocationSize = 1)
	@Column(name = "eid")
	private Integer empId;		
	
	@Column(name = "ename", unique = true)
	private String empName;
	
	@Column(name = "esal")
	private Double empSal;
}
