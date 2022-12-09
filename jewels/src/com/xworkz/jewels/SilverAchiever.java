package com.xworkz.jewels;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.xworkz.jewels.entity.SilverEntity;
import com.xworkz.jewels.service.SilverService;
import com.xworkz.jewels.service.SilverServiceImpl;
import com.xworkz.jewels.type.SilverType;

public class SilverAchiever {

	public static void main(String[] args) {
		
		SilverEntity entity = new SilverEntity(SilverType.BRACELET, 71000.0, 12700.0, 1000.0, 2000.0, 1500.0, "GRT");
		SilverEntity entity1 = new SilverEntity(SilverType.NOSERING, 70000.0, 12000.0, 1000.0, 1500.0, 1500.0, "Kalyan");

		SilverService service = new SilverServiceImpl();
//		service.validateAndSave(entity);
//		service.validateAndSave(entity1);
		
		List<SilverEntity> list = new ArrayList<SilverEntity>();
		list.add(entity);
		list.add(entity1);
		
//		service.validateAndSave(list);
		
		Optional<SilverEntity> findByShopNameAndId = service.findByShopNameAndId("Kalyan", 2);
		if(findByShopNameAndId.isPresent()) {
			SilverEntity silverEntity = findByShopNameAndId.get();
			System.out.println(silverEntity);
		}else {
			System.out.println("data is null");
		}

	}

}
