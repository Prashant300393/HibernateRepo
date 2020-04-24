package com.amdocs.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity
@Table(name = "hibstdtab")
@GenericGenerator(name = "mygen", strategy = "increment")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sid")
	private Integer stdId;
	private String stdName;
	private Double stdFee;

	/**
	 * IdBag doesnt contains index column, instead of that CollectionId column will be there
	 * which behaves like PrimaryKey column for Faster execution, internally Generator is used
	 */
	
	@ElementCollection
	@CollectionTable(name = "markstab", joinColumns = @JoinColumn(name="sid"))
	@Column(name = "marks") // Element column
	@CollectionId(columns = { @Column(name = "unqId") }, generator = "mygen", type = @Type(type = "long"))
	private List<Integer> marks;

}
