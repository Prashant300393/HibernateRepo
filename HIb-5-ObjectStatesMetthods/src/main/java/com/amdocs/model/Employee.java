package com.amdocs.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee {

	@Id
	private Integer eid;
	private String ename;
	private Double esal;
}
