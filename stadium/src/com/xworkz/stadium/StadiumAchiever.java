package com.xworkz.stadium;

import com.xworkz.stadium.entity.StadiumEntity;
import com.xworkz.stadium.service.StadiumService;
import com.xworkz.stadium.service.StadiumServiceImpl;
import com.xworkz.stadium.type.StadiumType;

public class StadiumAchiever {

	public static void main(String[] args) {

		StadiumEntity entity1 = new StadiumEntity(1, "Chinnaswamy", 1980, 25000, 1000, StadiumType.OUTDOOR);

		StadiumService service = new StadiumServiceImpl();
		service.validateAndSave(entity1);

	}

}
