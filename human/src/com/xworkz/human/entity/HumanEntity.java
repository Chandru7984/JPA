package com.xworkz.human.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "human")
@NamedQuery(name = "findAgeByName", query  = "select s from HumanEntity s where s.age=:cs")
public class HumanEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Length(min = 3, max = 50)
	@NotEmpty
	private String name;

	private int age;
	@NotNull
	@Length(min = 3, max = 50)
	@NotEmpty
	private String city;
	@NotNull
	@Length(min = 3, max = 50)
	@NotEmpty
	private String company;
	@DecimalMin(value = "3")
	@DecimalMax(value = "5")
	private double experience;

	private double salary;
	@NotNull
	@Length(min = 3, max = 50)
	@NotEmpty
	private String role;

	public HumanEntity(@NotNull @Length(min = 3, max = 50) @NotEmpty String name, int age,
			@NotNull @Length(min = 3, max = 50) @NotEmpty String city,
			@NotNull @Length(min = 3, max = 50) @NotEmpty String company, double experience, double salary,
			@NotNull @Length(min = 3, max = 50) @NotEmpty String role) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.company = company;
		this.experience = experience;
		this.salary = salary;
		this.role = role;
	}

}
