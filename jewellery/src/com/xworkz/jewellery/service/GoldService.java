package com.xworkz.jewellery.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.xworkz.jewellery.entity.GoldEntity;

public interface GoldService {

	boolean validateAndSave(GoldEntity entity);

	boolean validateAndSave(List<GoldEntity> list);

	Optional<GoldEntity> findByShopNameAndId(String name, int id);

	Optional<String> findShopNameById(int id);

	Optional<Double> findMakingChargesByShopName(String name);

	Optional<Object[]> findWastageChargesAndmakingChargesByShopName(String name);

	Optional<Double> findTotalPriceByGramAndShopName(double gram, String shopName);

	Collection<GoldEntity> getAll();
	
	Collection<String> getAllShopName();
	
	Collection<Object[]> getAllShopNameAndType();
	
	Optional<Collection<GoldEntity>> findAllByMakingChargesGreaterThan(double charges);
	
	Optional<Collection<GoldEntity>> findAllByWastageChargesGreaterThanAndMakingChargesGreaterThan(double charges,double makingCharges);

	
	

}
