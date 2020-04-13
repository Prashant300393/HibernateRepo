package com.amdocs.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee {

	@Id
	private Integer empId;
	private String empName;
	private Double empSal;
}
