package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;


@Data
@Entity
@PrimaryKeyJoinColumn(name = "eid")
public class Employee extends Person{

	@Column(name = "dept")
	private String empDept;
	@Column(name = "sal")
	private Double empSal;
}
