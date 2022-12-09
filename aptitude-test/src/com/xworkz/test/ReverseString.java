package com.xworkz.test;

public class ReverseString {

	public static void main(String[] args) {
		
		String input = "getting good at coding needs a lot of practice";
		
		char[] rev = input.toCharArray();
		
		for(int i=rev.length-1;i>=0;i--)
			System.out.print(rev[i]);

	}

}
