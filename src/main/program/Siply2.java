package com.main.soroco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Siply2 {
//	public static List<List<Integer>> findSumZeroElements(int[] arr) {
//	List<List<Integer>> ansList = new ArrayList<>();
//	for (int i = 0; i < arr.length; i++) {
//		int sum = 0;
//		for (int j = i; j < arr.length; j++) {
//			sum += arr[j];
//			if (sum == 0) {
//				List<Integer> list = new ArrayList<>();
//				for (int k = i; k <= j; k++) {
//					list.add(arr[k]);
//				}
//				ansList.add(list);
//			}
//		}
//	}
//	return ansList;
//}

	public static void main(String[] args) {
//	arr[] = {6,-1,-3,4,-2,2,4,6,-12,-7}
//	Output:  [-1 -3 4],	[2 4 6 -12], [-2 2] and [-1 -3 4 -2 2] find ysubarray sum=0;
		int arr[] = new int[] { 6, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		List<List<Integer>> ansList = findSumZeroElements1(arr);
		System.out.println(ansList);
	}

	public static List<List<Integer>> findSumZeroElements1(int[] arr) {
		List<List<Integer>> ansList = new ArrayList<>();
		int sum = 0;
		Map<Integer, List<Integer>> sumIndexesMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (sumIndexesMap.containsKey(sum)) {
				List<Integer> list = sumIndexesMap.get(sum);
				for (Integer start : list) {
					List<Integer> ans = new ArrayList<>();
					for (int j = start + 1; j <= i; j++) {
						ans.add(arr[j]);
					}
					ansList.add(ans);
				}
			}

			if (sumIndexesMap.containsKey(sum))
				sumIndexesMap.get(sum).add(i);
			else {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				sumIndexesMap.put(sum, list);
			}
		}
		System.out.println(sumIndexesMap);
		return ansList;
	}
}
