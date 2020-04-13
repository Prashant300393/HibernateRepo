package com.amdocs.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Product {

	@Id
	private Integer prodId;
	private String prodName;
	@Transient	// Ignored mapping
	private Double prodMrp;
	@Temporal(TemporalType.DATE)
	private Date mfgDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date expDate;
	@Temporal(TemporalType.TIME)
	private Date testSlot;
	
	public Product() {
		super();
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Double getProdMrp() {
		return prodMrp;
	}

	public void setProdMrp(Double prodMrp) {
		this.prodMrp = prodMrp;
	}

	public Date getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public Date getTestSlot() {
		return testSlot;
	}

	public void setTestSlot(Date testSlot) {
		this.testSlot = testSlot;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodMrp=" + prodMrp + ", mfgDate=" + mfgDate
				+ ", expDate=" + expDate + ", testSlot=" + testSlot + "]";
	}
	
	
}
