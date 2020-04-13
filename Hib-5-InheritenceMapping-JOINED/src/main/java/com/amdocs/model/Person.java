package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "pertab")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

	@Id
	@Column(name = "pid")
	private Integer perId;
	@Column(name = "pname")
	private String perName;
	
}
