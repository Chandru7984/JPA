package com.xworkz.human;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.xworkz.human.entity.HumanEntity;
import com.xworkz.human.service.HumanService;
import com.xworkz.human.service.HumanServiceImpl;

public class HumanAchiever {

	public static void main(String[] args) {

		HumanEntity humanEntity = new HumanEntity(4, "Chandru", 24, "Bengaluru", "VM Vare", 3.13, 500000.0, "Developer");

		HumanService service = new HumanServiceImpl();
		service.validateAndSave(humanEntity);
		

		Optional<HumanEntity> validateAndFindById = service.validateAndFindById(3);
		if (validateAndFindById.isPresent()) {
			System.out.println("id is present");
			validateAndFindById.get();
		} else {
			System.out.println("it is null");
		}
		
		Optional<HumanEntity> updateNameById = service.updateNameById(5, "Dada");
		if(updateNameById.isPresent()) {
			System.out.println("name is updated");
			updateNameById.get();
		}else {
			System.out.println("it is null");
		}

		List<HumanEntity> list1 = new ArrayList<HumanEntity>();
		list1.add(humanEntity);
		
		service.validateAndSave(list1);
		
	}

}
