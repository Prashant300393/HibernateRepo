package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "emptab")
public class Employee {

	@Id
	@Column(name = "eid", nullable = false)	// nullable is TRUE by Default
	private Integer empId;
	@Column(name = "ename", nullable = false, length = 20, unique = true) // unique is FALSE By Default
	private String empName;
	@Column(name = "esal")
	private Double empSal;
}
