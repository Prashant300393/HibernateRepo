package com.amdocs.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "hibstdtab")
public class Student {

	@Id
	@Column(name = "sid")
	private Integer stdId;
	private String stdName;
//	@Transient
	private String stdFee;

	@ElementCollection
	@CollectionTable(name = "markstab", joinColumns = @JoinColumn(name="sid"))
	@OrderColumn(name = "pos")
	@Column(name = "marks")
	private List<Double> marks;
	
	@ElementCollection
	@CollectionTable(name = "gradetab" , joinColumns = @JoinColumn(name="sid"))
	@MapKeyColumn(name = "prj")
	@Column(name = "ver")
	private Map<String, String> grades;

	@ElementCollection
	@CollectionTable(name = "prjtab" , joinColumns = @JoinColumn(name = "sid"))
	@Column(name = "prj")
	private Set<String> prjs;
	
	public Student() {
		super();
	}

	public Student(Integer stdId, String stdName, String stdFee, List<Double> marks, Map<String, String> grades,
			Set<String> prjs) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdFee = stdFee;
		this.marks = marks;
		this.grades = grades;
		this.prjs = prjs;
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

	public String getStdFee() {
		return stdFee;
	}

	public void setStdFee(String stdFee) {
		this.stdFee = stdFee;
	}

	public List<Double> getMarks() {
		return marks;
	}

	public void setMarks(List<Double> marks) {
		this.marks = marks;
	}

	public Map<String, String> getGrades() {
		return grades;
	}

	public void setGrades(Map<String, String> grades) {
		this.grades = grades;
	}

	public Set<String> getPrjs() {
		return prjs;
	}

	public void setPrjs(Set<String> prjs) {
		this.prjs = prjs;
	}

	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdFee=" + stdFee + ", marks=" + marks
				+ ", grades=" + grades + ", prjs=" + prjs + "]";
	}
	
	
}
