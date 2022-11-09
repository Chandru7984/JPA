package com.xworkz.onlinepayment.service;

import java.util.List;
import java.util.Optional;

import com.xworkz.onlinepayment.entity.OnlinePaymentEntity;
import com.xworkz.onlinepayment.repository.OnlinePaymentRepo;
import com.xworkz.onlinepayment.repository.OnlinePaymentRepoImpl;

public class OnlinePaymentServiceImpl implements OnlinePaymentService {

	private OnlinePaymentRepo repo = new OnlinePaymentRepoImpl();

	@Override
	public boolean validateAndSave(OnlinePaymentEntity entity) {
		int id = entity.getId();
		String name = entity.getName();
		int creditAmt = entity.getCreditAmt();
		double debitAmt = entity.getDebitAmt();
		double balance = entity.getBalance();
		if (id > 0) {
			System.out.println("id is valid");
		} else {
			System.out.println("id is invalid");
		}
		if (name != null && name.length() > 3 && name.length() < 50) {
			System.out.println("name is valid");
		} else {
			System.out.println("nam,e is invalid");
		}
		if (creditAmt > 0) {
			System.out.println("it is valid");
		} else {
			System.out.println("it is invlaid");
		}
		if (debitAmt > 0) {
			System.out.println("it is valid");
		} else {
			System.out.println("it is invalid");
		}
		if (balance > 0) {
			System.out.println("it is valid");
			this.repo.save(entity);
		} else {
			System.out.println("it is invalid");
		}
		return false;
	}

	@Override
	public Optional<OnlinePaymentEntity> validateAndFindById(int id) {
		
		return this.repo.findById(id);
	}

	@Override
	public Optional<OnlinePaymentEntity> updatenameById(int id, String name) {
		return this.repo.updateNameById(id, name);
		
	}
	
	@Override
	public void validateAndSave(List<OnlinePaymentEntity> list) {
		
		this.repo.save(list);
		
	}

}
