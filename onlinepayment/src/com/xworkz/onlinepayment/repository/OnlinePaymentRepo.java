package com.xworkz.onlinepayment.repository;

import java.util.List;
import java.util.Optional;

import com.xworkz.onlinepayment.entity.OnlinePaymentEntity;

public interface OnlinePaymentRepo {
	
	boolean save(OnlinePaymentEntity entity);
	
	Optional<OnlinePaymentEntity> findById(int id);
	
	Optional<OnlinePaymentEntity> updateNameById(int id, String name);

	void save(List<OnlinePaymentEntity> list);
}