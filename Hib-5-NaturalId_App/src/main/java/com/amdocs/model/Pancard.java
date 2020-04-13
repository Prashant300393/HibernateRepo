package com.amdocs.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Pancard {

	@Id
	private Integer pandId;
	private String panNum;
	private String perName;
}
