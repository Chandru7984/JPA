package com.xworkz.human.repository;

import java.util.List;
import java.util.Optional;

import com.xworkz.human.entity.HumanEntity;

public interface HumanRepo {

	boolean save(HumanEntity entity);

	Optional<HumanEntity> findById(int id);

	Optional<HumanEntity> updateNameById(int id, String name);
	
	void save(List<HumanEntity> list);
	
	Optional<HumanEntity> findAgeByName(String name);

}
