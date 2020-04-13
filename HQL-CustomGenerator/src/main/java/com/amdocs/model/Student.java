package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Student {

	@Id
	@GeneratedValue(generator = "stdgen")
	@GenericGenerator(name = "stdgen", strategy = "com.amdocs.gen.MyIdGen2")
	@Column(name = "sid")
	private String stdId;
	
	@Column(name = "sname")
	private String stdName;
	
	@Column(name = "sfee")
	private Double stdFee;
}
