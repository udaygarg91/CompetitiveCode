package com.main.soroco;

import java.util.ArrayList;

public class SorocoMain {
	public static void main(String[] args) {
		// 15:20

//		String s = "00:59";
//
//		String[] arr = s.split(":");
//
//		int h = Integer.parseInt(arr[0]) % 12 * 5;
//
//		int m = Integer.parseInt(arr[1]);
//
//		int ang = Math.abs(m - h) * 6;
//		System.out.println(ang);

		int arr[] = new int[] { 2, 2, 2 };
		java.util.List<Integer> l = new ArrayList<>();

		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int smax = Integer.MIN_VALUE;
		int c = 0;
		for (int i : arr) {
			if (min > i)
				min = i;
			if (max < i) {
				smax = max;
				max = i;
			} else if (i > smax) {
				smax = i;
			}
		}
		System.out.println(min + " : min " + max + " : max " + smax + " : smax");

	}
}
