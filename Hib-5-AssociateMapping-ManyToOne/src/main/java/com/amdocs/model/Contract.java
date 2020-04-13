package com.amdocs.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Contract {

	@Id
	private Integer cntId;
	private String vendor;
	private String regCode;
	/**
	 * 	Child Data also Fetched coz 
	 * Default FETCHTYPE FOR @ManyToOne is "EAGER"
	 * 
	 * if we want Only Parent details then change it to "LAZY"
	 */
	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "qidFk")
	private Quote qob;
}
// JoinColumn is OPTIONAL, It will take "HasAVariable_ChildPkVariable" by default
// Exmple for Above Table ==> Fk Column looks like -->  qob_qteId