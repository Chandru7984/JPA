package com.xworkz.test;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class RemoveDuplicates {

	public static void main(String[] args) {

	    	String[] tree = {"Hello", "hi", "Wow", "cute", "thanks", "hi", "Aww", "cute", "hello", "beloved", "Aww"};
	 
	        List<String> tmpList = Arrays.asList(tree);
	 
	        TreeSet<String> treeSet = new TreeSet<String>(tmpList);
	        System.out.println(treeSet);
	    }

}
