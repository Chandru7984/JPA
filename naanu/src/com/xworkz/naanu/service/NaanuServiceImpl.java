package com.xworkz.naanu.service;

import com.xworkz.naanu.entity.NaanuEntity;
import com.xworkz.naanu.repository.NaanuRepo;
import com.xworkz.naanu.repository.NaanuRepoImpl;

public class NaanuServiceImpl implements NaanuService {

	private NaanuRepo repo = new NaanuRepoImpl();

	@Override
	public boolean validateAndSave(NaanuEntity entity) {
		int id = entity.getId();
		String name = entity.getName();
		String country = entity.getCountry();
		String state = entity.getState();
		if (id > 0) {
			System.out.println("id is valid");
		} else {
			System.err.println("id is not valid");
		}
		if (name != null && name.length() > 3 && name.length() < 50) {
			System.out.println("name is valid");
		} else {
			System.err.println("name is not valid");
		}
		if (country != null && country.length() > 3 && country.length() < 50) {
			System.out.println("country is valid");
		} else {
			System.err.println("country is not valid");
		}
		if (state != null && state.length() > 3 && state.length() < 50) {
			System.out.println("state is valid");
			this.repo.save(entity);
		} else {
			System.err.println("state is not valid");
		}
		return false;
	}

}
