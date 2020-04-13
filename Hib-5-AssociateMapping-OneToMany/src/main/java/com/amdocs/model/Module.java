package com.amdocs.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Module {

	@Id
	private Integer modId;
	private String modCode;
	
}

