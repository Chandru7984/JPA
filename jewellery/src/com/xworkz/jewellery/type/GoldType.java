package com.xworkz.jewellery.type;

public enum GoldType {
	
	EARRING("Ear ring"),BRACELET("Bracelet"),NECKLES("Neckles"),NOSERING("Nose ring"),BANGLES("Bangles");
	
	private String value;
	
	private GoldType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
