package com.amdocs.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NaturalId;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	private Integer empId;
	@NaturalId	// Acts as a PrimaryKey(but not Exactly PK)
	private String empCode;
	private String empName;
	private Double empSal;
}
