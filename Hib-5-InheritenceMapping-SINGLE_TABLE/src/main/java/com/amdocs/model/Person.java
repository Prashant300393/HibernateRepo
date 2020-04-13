package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "pertab")
@Inheritance // default strategy is SINGLE_TABLE
// IF we don't Mention @DiscrmntrCol, the default COL NAME will be "DTYPE"
@DiscriminatorColumn(name = "info", discriminatorType = DiscriminatorType.STRING)
// If we don't Mention, the @DiscriminatorValue default is the ENTITY(Class) NAME.
@DiscriminatorValue(value = "PER")
public class Person {

	@Id
	@Column(name = "pid")
	private Integer perId;
	@Column(name = "pname")
	private String perName;
	
}
