package com.amdocs.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Course {

	@Id
	private Integer crsId;
	private String crsName;
	private Integer crsFee;
}
