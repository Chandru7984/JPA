package com.xworkz.onlinepayment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.xworkz.onlinepayment.entity.OnlinePaymentEntity;
import com.xworkz.onlinepayment.service.OnlinePaymentService;
import com.xworkz.onlinepayment.service.OnlinePaymentServiceImpl;

public class OnlinePaymentAchiever {

	public static void main(String[] args) {
		
		OnlinePaymentEntity entity1 = new OnlinePaymentEntity(1, "Paytm", 10000, 6000.0, 4000.0);
		OnlinePaymentEntity entity2 = new OnlinePaymentEntity(2, "GooglePay", 15000, 6000.0, 9000.0);
		OnlinePaymentEntity entity3 = new OnlinePaymentEntity(3, "Paytm", 10000, 6000.0, 4000.0);
		OnlinePaymentEntity entity4 = new OnlinePaymentEntity(4, "Phonepay", 20000, 4000.0, 14000.0);
		OnlinePaymentEntity entity5 = new OnlinePaymentEntity(5, "Phonepay", 20000, 4000.0, 14000.0);
		OnlinePaymentEntity entity6 = new OnlinePaymentEntity(6, "BHIM", 20000, 4000.0, 14000.0);
		
		OnlinePaymentService service = new OnlinePaymentServiceImpl();
		service.validateAndSave(entity1);
		service.validateAndSave(entity2);
		service.validateAndSave(entity3);
		service.validateAndSave(entity4);
		
		Optional<OnlinePaymentEntity> validateAndFindById = service.validateAndFindById(2);
		if(validateAndFindById.isPresent()) {
			System.out.println("id is present");
			validateAndFindById.get();
		}else {
			System.out.println("it is null");
		}
		
		Optional<OnlinePaymentEntity> updateNameById = service.updatenameById(4, "Googlepay");
		if(updateNameById.isPresent()) {
			System.out.println("Name is updated");
			OnlinePaymentEntity onlinePaymentEntity = updateNameById.get();
			System.out.println(onlinePaymentEntity);
			
		}else {
			System.out.println("it is null");
		}
		
		List<OnlinePaymentEntity> list = new ArrayList<OnlinePaymentEntity>();
		list.add(entity5);
		list.add(entity6);

		
		service.validateAndSave(list);


	}

}
