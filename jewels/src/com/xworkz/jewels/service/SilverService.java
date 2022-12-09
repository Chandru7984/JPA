package com.xworkz.jewels.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.xworkz.jewels.entity.SilverEntity;

public interface SilverService {
	
	boolean validateAndSave(SilverEntity entity);

	boolean validateAndSave(List<SilverEntity> list);

	Optional<SilverEntity> findByShopNameAndId(String name, int id);
//
//	Optional<String> findShopNameById(int id);
//
//	Optional<Double> findMakingChargesByShopName(String name);
//
//	Optional<Object[]> findWastageChargesAndmakingChargesByShopName(String name);
//
//	Optional<Double> findTotalPriceByGramAndShopName(double gram, String shopName);
//
//	Collection<SilverEntity> getAll();
//
//	Collection<String> getAllShopName();
//
//	Collection<Object[]> getAllShopNameAndType();
//
//	Optional<Collection<SilverEntity>> findAllByMakingChargesGreaterThan(double charges);
//
//	Optional<Collection<SilverEntity>> findAllByWastageChargesGreaterThanAndMakingChargesGreaterThan(double charges,
//			double makingCharges);

}
