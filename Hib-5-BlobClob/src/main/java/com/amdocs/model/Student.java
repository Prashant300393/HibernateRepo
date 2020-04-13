package com.amdocs.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class Student {

	@Id
	private Integer stdId;
	private String stdName;
	private Double stdFee;
	@Lob
	private byte[ ] stdImg;
	@Lob
	private char[ ]	stdCv;
	
	public Student() {
		super();
	}

	public Integer getStdId() {
		return stdId;
	}

	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public Double getStdFee() {
		return stdFee;
	}

	public void setStdFee(Double stdFee) {
		this.stdFee = stdFee;
	}

	public byte[] getStdImg() {
		return stdImg;
	}

	public void setStdImg(byte[] stdImg) {
		this.stdImg = stdImg;
	}

	public char[] getStdCv() {
		return stdCv;
	}

	public void setStdCv(char[] stdCv) {
		this.stdCv = stdCv;
	}

	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdFee=" + stdFee + ", stdImg="
				+ Arrays.toString(stdImg) + ", stdCv=" + Arrays.toString(stdCv) + "]";
	}
	
	
}
