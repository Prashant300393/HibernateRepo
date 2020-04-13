package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "custtab")
public class Customer {

	@Id
	@Column(name = "cid")
	private Integer custId;
	@Column(name = "cname")
	private String custName;
	@Column(name = "camt")
	private Double custAmt;
}
