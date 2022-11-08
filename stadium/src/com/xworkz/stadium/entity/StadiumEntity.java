package com.xworkz.stadium.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xworkz.stadium.type.StadiumType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stadium")
public class StadiumEntity {

	@Id
	private int id;
	private String name;
	private int foundedYear;
	private int capacity;
	private int entryFees;
	private StadiumType type;

}
