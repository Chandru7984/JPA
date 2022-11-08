package com.xworkz.stadium;

import com.xworkz.stadium.entity.StadiumEntity;
import com.xworkz.stadium.service.StadiumService;
import com.xworkz.stadium.service.StadiumServiceImpl;
import com.xworkz.stadium.type.StadiumType;

public class StadiumAchiever {

	public static void main(String[] args) {

		StadiumEntity entity1 = new StadiumEntity(2, "Chinnaswamy", 1985, 25000, 1000, StadiumType.OUTDOOR);
		StadiumEntity entity2 = new StadiumEntity(3, "Chinnaswamy", 1985, 25000, 1000, StadiumType.OUTDOOR);


		StadiumService service = new StadiumServiceImpl();
		service.validateAndSave(entity2);

	}

}
