package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prodtab")
public class Product {

	@Id
	@Column(name = "pid")
	private Integer prdoId;
	@Column(name = "pcode")
	private String prodCode;
	@Column(name = "pcost")
	private Double prodCost;
	
	public Product() {
		super();
	}

	public Product(Integer prdoId, String prodCode, Double prodCost) {
		super();
		this.prdoId = prdoId;
		this.prodCode = prodCode;
		this.prodCost = prodCost;
	}



	public Integer getPrdoId() {
		return prdoId;
	}
	public void setPrdoId(Integer prdoId) {
		this.prdoId = prdoId;
	}
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public Double getProdCost() {
		return prodCost;
	}
	public void setProdCost(Double prodCost) {
		this.prodCost = prodCost;
	}
	@Override
	public String toString() {
		return "Product [prdoId=" + prdoId + ", prodCode=" + prodCode + ", prodCost=" + prodCost + "]";
	}
}
