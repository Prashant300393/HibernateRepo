package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Legacy Generators are 6 Types [ assigned(default), increment, uuid, sequence, native, hi-lo ]
 * 
 * NOTE : For "uuid" Change Model class Variable DataType for PK to String type.
 *
 */

@Entity
@Data
@Table(name = "emptab")
public class Employee {

	@Id
	@GeneratedValue(generator = "emp")
	@GenericGenerator(name = "emp", strategy = "sequence")
//	@GenericGenerator(name = "emp", strategy = "uuid")
	@Column(name = "eid")
//	private String empId;		// [ For strategy = "UUID" ==> DataType of PK must be String ] 		
	private Integer empId;		
	
	@Column(name = "ename", unique = true)
	private String empName;
	
	@Column(name = "esal")
	private Double empSal;
}
