package com.xworkz.jewellery.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.xworkz.jewellery.entity.GoldEntity;
import com.xworkz.jewellery.repo.GoldRepo;
import com.xworkz.jewellery.repo.GoldRepoImpl;

public class GoldServiceImpl implements GoldService {

	GoldRepo repo = new GoldRepoImpl();

	@Override
	public boolean validateAndSave(GoldEntity entity) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<GoldEntity>> validate = validator.validate(entity);
		if (validate.size() > 0) {
			System.out.println("fix the bugs");
		} else {
			repo.save(entity);
			System.out.println(entity);
		}
		return true;
	}

	@Override
	public boolean validateAndSave(List<GoldEntity> list) {
		return this.repo.save(list);
	}

	@Override
	public Optional<GoldEntity> findByShopNameAndId(String name, int id) {
		return this.repo.findByShopNameAndId(name, id);
	}

	@Override
	public Optional<String> findShopNameById(int id) {
		return this.repo.findShopNameById(id);
	}

	@Override
	public Optional<Double> findMakingChargesByShopName(String name) {
		return this.repo.findMakingChargesByShopName(name);
	}

	@Override
	public Optional<Object[]> findWastageChargesAndmakingChargesByShopName(String name) {
		return this.repo.findWastageChargesAndmakingChargesByShopName(name);
	}

	@Override
	public Optional<Double> findTotalPriceByGramAndShopName(double gram, String shopName) {
		return this.repo.findTotalPriceByGramAndShopName(gram, shopName);
	}

	@Override
	public Collection<GoldEntity> getAll() {

		return repo.getAll();
	}
	@Override
	public Collection<String> getAllShopName() {
		return repo.getAllShopName();
	}
	
	@Override
	public Collection<Object[]> getAllShopNameAndType() {
		return repo.getAllShopNameAndType();
	}
	
	@Override
	public Optional<Collection<GoldEntity>> findAllByMakingChargesGreaterThan(double charges) {
		return repo.findAllByMakingChargesGreaterThan(charges);
	}
	
	@Override
	public Optional<Collection<GoldEntity>> findAllByWastageChargesGreaterThanAndMakingChargesGreaterThan(
			double charges, double makingCharges) {
		return repo.findAllByWastageChargesGreaterThanAndMakingChargesGreaterThan(charges, makingCharges);
	}
}
