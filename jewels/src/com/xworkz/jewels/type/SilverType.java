package com.xworkz.jewels.type;

public enum SilverType {
	
	EARRING("Ear ring"),BRACELET("Bracelet"),NECKLES("Neckles"),NOSERING("Nose ring"),BANGLES("Bangles");
	
	private String values;

	private SilverType(String values) {
		this.values = values;
	}
	
	public String getValues() {
		return values;
	}

}
