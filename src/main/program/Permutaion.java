//package com.main.soroco;
//
//import java.util.*;
//
//public class Permutaion {
//	public List permute(int[] nums) {
//		List
//		List<List<Integer>> ans = new ArrayList<>();
//		rec(nums, 0, ans);
//		return ans;
//	}
//
//	public static void rec(int[] nums, int pos, List<List<Integer>> ans) {
//		if (pos == nums.length) {
//			List<Integer> l = new ArrayList<>();
//			for (Integer i : nums) {
//				l.add(i);
//			}
//			ans.add(l);
//			return;
//		}
//
//		for (int i = pos; i < nums.length; i++) {
//			swap(nums, i, pos);
//			rec(nums, pos + 1, ans);
//			swap(nums, i, pos);
//		}
//	}
//
//	public static void swap(int[] nums, int i, int j) {
//		int t = nums[i];
//		nums[i] = nums[j];
//		nums[j] = t;
//	}
//}
