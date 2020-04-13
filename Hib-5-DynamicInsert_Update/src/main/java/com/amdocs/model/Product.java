package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
/**
 *	@DynamicInsert will generate Query at Runtime using variable having NON-NULL VALUES 
 *
 *	
 */
@DynamicInsert
@DynamicUpdate
@Entity
@Data
@Table(name = "prodtab")
public class Product {

	@Id
	@Column(name = "pid")
	private Integer prodId;
	@Column(name = "pcode")
	private String prodCode;
	@Column(name = "pcost")
	private Double prodCost;
	
}
