package com.amdocs.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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

	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name = "empId", column = @Column(name="eid")),
		@AttributeOverride(name = "deptId", column = @Column(name="did"))
	})
	private EmpIdType eit;
	
	@Column(name = "ecode")
	private String empCode;
	@Column(name = "ename")
	private String empName;
	@Column(name = "esal", unique = true)
	private Double empSal;
}
