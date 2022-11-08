package com.xworkz.naanu.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "naanu")
public class NaanuEntity {
	@Id
	private int id;
	private String name;
	private String country;
	private String state;

}
