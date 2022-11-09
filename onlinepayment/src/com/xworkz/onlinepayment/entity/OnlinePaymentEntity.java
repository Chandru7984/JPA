package com.xworkz.onlinepayment.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment")
@Entity
public class OnlinePaymentEntity {
	
	@Id
	private int id;
	private String name;
	private int creditAmt;
	private double debitAmt;
	private double balance;

}
