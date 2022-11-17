package com.xworkz.human.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.xworkz.human.entity.HumanEntity;
import com.xworkz.human.repository.HumanRepo;
import com.xworkz.human.repository.HumanRepoImpl;

public class HumanServiceImpl implements HumanService {

	HumanRepo repo = new HumanRepoImpl();

	@Override
	public boolean validateAndSave(HumanEntity entity) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<HumanEntity>> validate = validator.validate(entity);
		if (validate.size() > 0) {
			System.out.println("fix the bugs");
		} else {
			repo.save(entity);
			System.out.println(entity);
		}
		return true;
	}

	@Override
	public Optional<HumanEntity> validateAndFindById(int id) {
		return this.repo.findById(id);
	}

	@Override
	public Optional<HumanEntity> updateNameById(int id, String name) {
		return this.repo.updateNameById(id, name);
	}

	@Override
	public void validateAndSave(List<HumanEntity> list) {
		this.repo.save(list);
	}

}
