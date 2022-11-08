package com.xworkz.stadium.service;

import com.xworkz.stadium.entity.StadiumEntity;
import com.xworkz.stadium.repository.StadiumRepo;
import com.xworkz.stadium.repository.StadiumRepoImpl;
import com.xworkz.stadium.type.StadiumType;

public class StadiumServiceImpl implements StadiumService {

	private StadiumRepo repo = new StadiumRepoImpl();

	@Override
	public boolean validateAndSave(StadiumEntity entity) {
		int id = entity.getId();
		String name = entity.getName();
		int foundedYear = entity.getFoundedYear();
		int capacity = entity.getCapacity();
		int entryFees = entity.getEntryFees();
		StadiumType type = entity.getType();

		if (id > 0) {
			System.out.println("id is valid");
		} else {
			System.err.println("id is invalid");
		}
		if (name != null && name.length() > 3 && name.length() < 50) {
			System.out.println("name is valid");
		} else {
			System.err.println("name is invalid");
		}
		if (foundedYear > 1950) {
			System.out.println("year is valid");
		} else {
			System.err.println("year is invalid");
		}
		if (capacity > 0) {
			System.out.println("capacity is valid");
		} else {
			System.err.println("capacity is invalid");
		}
		if (entryFees > 0) {
			System.out.println("fees is valid");
			this.repo.save(entity);
		} else {
			System.err.println("fees is invalid");
		}
//		if (type != null && type == type.OUTDOOR && type == type.INDOOR) {
//			System.out.println("type is valid");
//			this.repo.save(entity);
//		} else {
//			System.err.println("type is invalid");
//		}
		return false;
	}

}
