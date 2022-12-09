package com.xworkz.jewels.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.xworkz.jewels.type.SilverType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "silver")
//@NamedQuery(name = "findByShopNameAndId", query = "select nanu from GoldEntity nanu where nanu.shopName=:gd and nanu.id=:gr")
@NamedQuery(name = "findByShopNameAndId", query = "select old from SilverEntity old where old.shopName=:cs and old.id:sc")
public class SilverEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private SilverType type;
	private double silverPrice;
	private double gstPrice;
	private double grams;
	private double makingCharges;
	private double wastageCharges;
	@NotNull
	@Length(min = 3, max = 50)
	private String shopName;

	public SilverEntity(SilverType type, double silverPrice, double gstPrice, double grams,
			double makingCharges, double wastageCharges, @NotNull @Length(min = 3, max = 50) String shopName) {
		super();
		this.type = type;
		this.silverPrice = silverPrice;
		this.gstPrice = gstPrice;
		this.grams = grams;
		this.makingCharges = makingCharges;
		this.wastageCharges = wastageCharges;
		this.shopName = shopName;
	}

}
