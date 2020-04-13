package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "modeltab")
@NoArgsConstructor
@AllArgsConstructor
public class Model {
	
	@Id
	@Column(name = "mid")
	private Integer modId;
	@Column(name = "mcolor")
	private String modColor;

}
