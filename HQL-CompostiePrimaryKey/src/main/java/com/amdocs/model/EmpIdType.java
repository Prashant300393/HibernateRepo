package com.amdocs.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
// This class behaver as PK Data Type. i.e it has to implements Serializable interface
public class EmpIdType implements Serializable{

	private Integer empId;
	private Integer deptId;
}
