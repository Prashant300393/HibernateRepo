package com.amdocs.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table
public class Customer{

	@Id
	@Column(name = "cid")
	private Integer custId;
	@Column(name = "cname")
	private String custName;
	
	
	/*		// OPTIONAL
	 * @AttributeOverrides ({
	 * 
	 * @AttributeOverride(column = @Column(name = "chno"), name = "hno"),
	 * 
	 * @AttributeOverride(column = @Column(name = "cloc"), name = "loc") })
	 */	
	@Embedded
	private Address addr;
	
	public Customer() {
		super();
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", addr=" + addr + "]";
	}
	
}
