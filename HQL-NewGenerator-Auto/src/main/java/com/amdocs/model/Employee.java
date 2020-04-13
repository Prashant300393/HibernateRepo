package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
		 AUTO : Hibernate will auto-detect one of below Generation Types
		     
	    Selection order =>  Sequence (if not)  Table (if not)  then Identity
		
		=> if Database supports Sequence then it is selected internally
		=> Else if Selects Table  internally
		=> Else if selects Identity  internally 
*/

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "eid")
	private Integer empId;		
	
	@Column(name = "ename", unique = true)
	private String empName;
	
	@Column(name = "esal")
	private Double empSal;
}
