package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(generator = "empgen")
	@GenericGenerator(name = "empgen", strategy = "increment")
	@Column(name = "eid")
	private Integer empId;
	
	@Column(name = "ename")
	private String empName;
	
	@Column(name = "esal", unique = true)
	private Double empSal;
}
