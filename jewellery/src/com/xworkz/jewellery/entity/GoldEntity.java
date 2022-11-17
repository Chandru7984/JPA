package com.xworkz.jewellery.entity;

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

import com.xworkz.jewellery.type.GoldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gold")
//select-alias name from-Entity class-alias name-where alias.parameter=:ref and alias.parameter=:ref
@NamedQuery(name = "findByShopNameAndId", query = "select nanu from GoldEntity nanu where nanu.shopName=:gd and nanu.id=:gr")
@NamedQuery(name = "findShopNameById", query = "select nanu.shopName from GoldEntity nanu where nanu.id=:dg")
@NamedQuery(name = "findMakingChargesByShopName", query = "select distinct nanu.makingCharges from GoldEntity nanu where nanu.shopName=:sc")
@NamedQuery(name = "findWastageChargesAndMakingChargesByShopName", query = "select nanu.wastageCharges,nanu.makingCharges from GoldEntity nanu where nanu.shopName=:dp")
@NamedQuery(name = "findTotalPriceByGramAndShopName", query = "select sum(goldPrice+gstPrice+makingCharges+wastageCharges)from GoldEntity nanu where nanu.grams=:ss and nanu.shopName=:cs")
public class GoldEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private GoldType type;
	private double goldPrice;
	private double gstPrice;
	private double grams;
	private double makingCharges;
	private double wastageCharges;
	private boolean copper;
	@NotNull
	@Length(min = 3, max = 50)
	private String shopName;

	public GoldEntity(GoldType type, double goldPrice, double gstPrice, double grams, double makingCharges,
			double wastageCharges, boolean copper, @NotNull @Length(min = 3, max = 50) String shopName) {
		super();
		this.type = type;
		this.goldPrice = goldPrice;
		this.gstPrice = gstPrice;
		this.grams = grams;
		this.makingCharges = makingCharges;
		this.wastageCharges = wastageCharges;
		this.copper = copper;
		this.shopName = shopName;
	}

}
