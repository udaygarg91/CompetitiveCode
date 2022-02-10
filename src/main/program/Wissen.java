package com.main.soroco;

import java.util.ArrayList;
import java.util.List;

public final class Wissen {

	public static void main1(String[] args) {

		// Longest Increasing Subsequence
		// Input: nums = [10,9,2,5,3,7,101,18]
		int num[] = new int[] { 104, 1, 2, 5, 20, 101, 18, 102 };
		List<List<Integer>> l = new ArrayList<>();
		int c = 1;
		int max = 0;
		int ii = 0;
		List<Integer> lll = null;
		List<Integer> ll = null;
		for (int i = 0; i < num.length - 1; i++) {
			for (int k = i + 1; k < num.length; k++) {
				ll = new ArrayList<>();
				ll.add(num[i]);
				for (int j = k; j < num.length; j++) {
					if (num[ii] < num[j]) {
						ll.add(num[j]);
						c++;
						ii = j;
					}
				}
				if(c > max)
					lll = ll;
				max = Math.max(max, c);
				c = 1;
				ii = i;
			}
			ii = i + 1;
		}
		System.out.println(lll);
		System.out.println(max);
	}
	
	
	public static void main(String[] args) {
		//Input: strs = ["eat","tea","tan","ate","nat","bat"]
		//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
		
		
	}

}
