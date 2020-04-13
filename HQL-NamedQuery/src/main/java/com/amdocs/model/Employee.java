package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Data;
/**		Global Queries/Named Queries :-
		-------------------------------
		-> A Query is identified with a unique name
		-> It can be re-usable/access any where(In any Test class).
		-> Faster in compile/Execution query. Single time Query compile.
		-> Supports even Parameters.
		** In Simple compared to Normal String HQL, it is bit faster. 
 */
@Data
@NamedQueries({
	@NamedQuery(name = "allemps", query = " from com.amdocs.model.Employee "),
	@NamedQuery(name = "oneemp", query = " from com.amdocs.model.Employee where empId=:empId "),
	
})
@Entity
public class Employee{

	@Id
	@Column(name = "eid")
	private Integer empId;
	@Column(name = "ename")
	private String empName;
	@Column(name = "esal")
	private Double empSal;
	
}
