package com.amdocs.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Student {

	@Id
	private Integer stdId;
	private String stdName;
	private String stdMail;
	/**
	 *  Default FETCHTYPE is "LAZY", because Child Side is Many
	 *  IF we want to FETCH CHILD DATA then, we have to change it to "EAGER"
	 */
	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(
//			joinColumns = @JoinColumn(name = "sidFk"), 
//			inverseJoinColumns = @JoinColumn(name = "cidFk"),
//			name = "std_crs"
//			)
	private List<Course> cob;
}
/**
 * 	 JoinTable is OPTIONAL, if we dont mention it, it will take
 *  
 *   Table Name = ParentClass_ChildClass
 *   JoinColumn= ParentClass_ParentPkColName
 *   InverseJoinColumn = HasAVar_ChildPkColName
 */





