package com.xworkz.jewels.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.xworkz.jewels.entity.SilverEntity;
import com.xworkz.jewels.repository.SilverRepository;
import com.xworkz.jewels.repository.SilverRepositoryImpl;

public class SilverServiceImpl implements SilverService {

	SilverRepository repo = new SilverRepositoryImpl();
	
	@Override
	public boolean validateAndSave(SilverEntity entity) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<SilverEntity>> validate = validator.validate(entity);
		if(validate.size() > 0) {
			System.out.println("fix the bugs");
		}else {
			repo.save(entity);
			System.out.println(entity);
		}
		return true;
	}

	@Override
	public boolean validateAndSave(List<SilverEntity> list) {
		return this.repo.save(list);
	}

	@Override
	public Optional<SilverEntity> findByShopNameAndId(String name, int id) {
		return this.repo.findByShopNameAndId(name, id);
	} 

}
