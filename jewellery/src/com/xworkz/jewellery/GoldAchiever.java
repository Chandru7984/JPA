package com.xworkz.jewellery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.xworkz.jewellery.entity.GoldEntity;
import com.xworkz.jewellery.service.GoldService;
import com.xworkz.jewellery.service.GoldServiceImpl;
import com.xworkz.jewellery.type.GoldType;

public class GoldAchiever {

	public static void main(String[] args) {

		GoldEntity entity = new GoldEntity(GoldType.BANGLES, 50000.0, 9000.0, 10.0, 2000.0, 500.0, true, "BHIMA");
		GoldEntity entity1 = new GoldEntity(GoldType.BRACELET, 40000.0, 8000.0, 8.0, 1000.0, 500.0, true, "Kalyan");

		GoldService service = new GoldServiceImpl();
//		service.validateAndSave(entity);
//		service.validateAndSave(entity1);

		List<GoldEntity> list = new ArrayList<GoldEntity>();
		list.add(entity);
		list.add(entity1);

//		service.validateAndSave(list);

		Optional<GoldEntity> findByShopNameAndId = service.findByShopNameAndId("BHIMA", 2);
		if (findByShopNameAndId.isPresent()) {
			GoldEntity goldEntity = findByShopNameAndId.get();
			System.out.println(goldEntity);
		} else {
			System.out.println("it is null");
		}

		Optional<String> findShopNameById = service.findShopNameById(3);
		if (findShopNameById.isPresent()) {
			String string = findShopNameById.get();
			System.out.println(string);
		} else {
			System.out.println("it is null");
		}

		Optional<Double> findMakingChargesByShopName = service.findMakingChargesByShopName("BHIMA");
		if (findMakingChargesByShopName.isPresent()) {
			Double double1 = findMakingChargesByShopName.get();
			System.out.println(double1);
		} else {
			System.out.println("it is null");
		}

		Optional<Object[]> findWastageChargesAndmakingChargesByShopName = service
				.findWastageChargesAndmakingChargesByShopName("Kalyan");
		if (findWastageChargesAndmakingChargesByShopName.isPresent()) {
			Object[] double1 = findWastageChargesAndmakingChargesByShopName.get();
			for (Object object : double1) {
				System.out.println(object);
			}
		} else {
			System.out.println("it is null");
		}

		Optional<Double> findTotalPriceByGramAndShopName = service.findTotalPriceByGramAndShopName(8.0, "Kalyan");
		if (findTotalPriceByGramAndShopName.isPresent()) {
			Double double1 = findTotalPriceByGramAndShopName.get();
			System.out.println(double1);
		} else {
			System.out.println("it is null");
		}

		System.out.println("===============getAll method===================");

		Collection<GoldEntity> all = service.getAll();
		System.out.println(all);

		Collection<String> allShopName = service.getAllShopName();
		System.out.println(allShopName);

		Collection<Object[]> allShopNameAndType = service.getAllShopNameAndType();
		for (Object[] objects : allShopNameAndType) {
			for (int i = 0; i <= objects.length-1; i++) {
				System.out.println(objects[i]);
			}
		}
		
		Optional<Collection<GoldEntity>> makingChargesGreaterThan = service.findAllByMakingChargesGreaterThan(1000.0);
		if(makingChargesGreaterThan.isPresent()) {
			Collection<GoldEntity> collection = makingChargesGreaterThan.get();
			System.out.println(collection);
		}else {
			System.out.println("data is null");
		}

	}

}
