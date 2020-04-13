package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;


@Data
@Entity
@DiscriminatorValue(value = "EMP")
public class Employee extends Person{

	@Column(name = "dept")
	private String empDept;
	@Column(name = "sal")
	private Double empSal;
}
