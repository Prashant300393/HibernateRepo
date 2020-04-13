package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
@DiscriminatorValue(value = "STD")
public class Student extends Person{

	@Column(name = "sfee")
	private Double stdFee;
	@Column(name = "grad")
	private String stdGrd;
}
