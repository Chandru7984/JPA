package com.xworkz.test;

public class OddAndEven {

	 public static void main(String args[]) {
	      int[] myArray = {20,37,58,69,99,70,87,18,9};
	      System.out.println("Even numbers in the given array are:: ");
	      for (int i=0; i<myArray.length; i++) {
	         if(myArray[i]%2 == 0) {
	            System.out.println(myArray[i]);
	         }
	      }
	      System.out.println("Odd numbers in the given array are:: ");
	      for (int i=0; i<myArray.length; i++) {
	         if(myArray[i]%2 != 0) {
	            System.out.println(myArray[i]);
	         }
	      }
	   }

}
