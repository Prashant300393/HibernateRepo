package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "stdtabs")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "sid")
	private Integer stdId;
	
	@Column(name = "sname")
	private String stdName;
	
	@Column(name = "sfee")
	private Double stdFee;
	
	@Column(name = "course")
	private String stdCourse;
	
}
