package com.amdocs.model;

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
@Table(name = "custtab")
@SecondaryTables
	({
		@SecondaryTable(name = "custa"), // here Pk JoinCol will set to default of PrimaryTable Pk
		@SecondaryTable(name = "custb" , 
/*optional JoinCol*/	 pkJoinColumns = @PrimaryKeyJoinColumn(name="aid") )
	})
public class Customer{

	@Id
	@Column(name = "cid")
	private Integer custId;
	@Column(name = "cname")
	private String custName;
	@Column(name = "cmob")
	private String custMob;
	@Column(name = "cmail")
	private String custMail;
	@Column(name = "source", table = "custa")
	private String custSource;

	@Column(name = "spouse", table = "custb")
	private String custSpouse;
	
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

	public String getCustMob() {
		return custMob;
	}

	public void setCustMob(String custMob) {
		this.custMob = custMob;
	}

	public String getCustMail() {
		return custMail;
	}

	public void setCustMail(String custMail) {
		this.custMail = custMail;
	}

	public String getCustSource() {
		return custSource;
	}

	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	public String getCustSpouse() {
		return custSpouse;
	}

	public void setCustSpouse(String custSpouse) {
		this.custSpouse = custSpouse;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custMob=" + custMob + ", custMail="
				+ custMail + ", custSource=" + custSource + ", custSpouse=" + custSpouse + "]";
	}
	
}
