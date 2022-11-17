package com.xworkz.human.service;

import java.util.List;
import java.util.Optional;

import com.xworkz.human.entity.HumanEntity;

public interface HumanService {

	boolean validateAndSave(HumanEntity entity);

	Optional<HumanEntity> validateAndFindById(int id);

	Optional<HumanEntity> updateNameById(int id, String name);
	
	void validateAndSave(List<HumanEntity> list);

}
