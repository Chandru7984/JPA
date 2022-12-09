package com.xworkz.test;

public class IntersectionOfTwoArray {
	
		   public static void main(String args[]) {
		      int arr1[] = {1, 4, 5, 9, 10};
		      int arr2[] = {2, 8, 6, 1, 7, 4};
		      int m = arr1.length;
		      int n = arr2.length;
		      int i = 0, j = 0;
		      System.out.print("Array 1: ");
		      for(int k = 0; k < m; k++) {
		         System.out.print(arr1[k] + " "); 
		      }
		      System.out.print("Array 2: ");
		      for(int k = 0; k < n; k++) {
		         System.out.print(arr2[k] + " ");
		      }
		      System.out.print("");
		      System.out.print("Intersection of two arrays is: ");
		      while (i < m && j < n) {
		         if (arr1[i] > arr2[j])
		            i++;
		         else if (arr2[j] > arr1[i])
		            j++;
		         else {
		            System.out.print(arr2[j++]+" ");
		            i++; 
		         }
		      }
		   }
}
