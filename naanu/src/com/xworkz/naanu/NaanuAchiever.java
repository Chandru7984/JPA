package com.xworkz.naanu;

import com.xworkz.naanu.entity.NaanuEntity;
import com.xworkz.naanu.service.NaanuService;
import com.xworkz.naanu.service.NaanuServiceImpl;

public class NaanuAchiever {

	public static void main(String[] args) {
		NaanuEntity entity = new NaanuEntity(1, "chandru", "india", "karnataka");

		NaanuService service = new NaanuServiceImpl();
		service.validateAndSave(entity);
		
		
	}

}
