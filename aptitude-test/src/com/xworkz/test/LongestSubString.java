package com.xworkz.test;

import java.util.HashSet;

public class LongestSubString {

	public static void main(String[] args) {

		    String s = "abcabcbb";
		    int j = 0;
		    int lenSubstr = 0;
		    HashSet<Character> subset = new HashSet<Character>();
		    for (int i = 0; i < s.length(); i++) {
		      char c = s.charAt(i);

		      if (!subset.contains(c)) {
		        subset.add(c);
		        lenSubstr = Math.max(lenSubstr, subset.size());
		      } else {
		        while (j < i) {

		          if (s.charAt(j) == c) {
		            j++;
		            break;
		          } else {
		            subset.remove(s.charAt(j));
		            j++;
		          }
		        }
		        subset.add(c);
		      }
		    }
		    System.out.println("Original String = " + s);
		    System.out.println("Length of Longest substring = " + lenSubstr);
		  }

}
