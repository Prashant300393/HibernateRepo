package com.amdocs.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Quote {

	@Id
	private Integer qteId;
	private String qteCode;
	private Double qteAmt;
}
