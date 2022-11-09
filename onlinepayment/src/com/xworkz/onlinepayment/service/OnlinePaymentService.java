package com.xworkz.onlinepayment.service;

import java.util.List;
import java.util.Optional;

import com.xworkz.onlinepayment.entity.OnlinePaymentEntity;

public interface OnlinePaymentService {

	boolean validateAndSave(OnlinePaymentEntity entity);

	Optional<OnlinePaymentEntity> validateAndFindById(int id);

	Optional<OnlinePaymentEntity> updatenameById(int id, String name);
	
	void validateAndSave(List<OnlinePaymentEntity> list);

}
