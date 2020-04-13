package com.amdocs.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Project {

	@Id
	private Integer prjId;
	private String prjName;
	/**
	 *  Default FETCHTYPE is "LAZY", because Child Side is Many
	 *  IF we want to FETCH CHILD DATA then, we have to change it to "EAGER"
	 */
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "prjIdFk")
	private List<Module> mod;
}
/**
 * 	 if we dont mention JoinColumn in @OneToMany, in this case Hibernate create one 
 *   Extra Table like ==>  ParentClass_ChildClass
 *   For Example     ==>  "Project_Module" TABLE is created having TWO FK COLUMNS
 */	 

