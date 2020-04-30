package com.amdocs.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import lombok.Data;

@Data
@Entity
@Table(name = "pertab")
public class Person {
	
	@Id
	@GeneratedValue
	private Integer pid;
	
	/*		@NotNull(message = "Name must not be NULL")
			@Size(min = 2,max = 5,message = "Name must be 2 to 5 Chars")
			private String pname;
	*/
		
	/*	@NotNull(message = "Name must not be NULL")
		@Pattern(regexp = "[A-Z]{2,4}",message = "Name must be 2-4 Uppercase Letter only..!!!")
		private String pname;
	*/
	
	/*	@NotNull(message = "Name must not be NULL")
	//	@Pattern(regexp = "[A-Z]{2,4}",message = "Name must be 2-4 Uppercase Letter only..!!!")
	//	+ means min=1 char, max=n chars only Upper/lower and digits allowed
	//	[A-Z\\s] => Upper case and space char are <allowed></allowed>	
	//	[A-Z\\+\\_\\-] => Upper case and symbols + _ - are allowed
	//	@Pattern(regexp = "[A-Za-z0-9]+",message = "Invalid Name..!!!")
		private String pname;
	*/	 
	
	/**
	 * While inserting boolean type if expected value always is true then
	 * write @AssertTrue else write @AssertFalse.
	 */
	/*//	@AssertTrue(message = "Status Must be True")
		@AssertFalse(message = "Status Must be False")
		private boolean status;
	*/	
	
	/*	@Min(value = 18, message = "Min Age must be 18 for Voting")
		@Max(value = 120, message = "Limit Exceed..!!Goto Hell and Enjoy")
		private int voterAge;
	*/	
	
	/*	@Past(message = "Date must be Past")
		private Date dob;
	*/	
	
	@Future(message = "Date must be in Future")
	private Date dateOfExp;
	
}
