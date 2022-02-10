package com.main.soroco;

import java.util.Arrays;

public class QuestGBL {
	public static int getDupNum(int[] arr) {
		if (arr == null || arr.length == 0)
			return 0;
		int n = arr.length - 1;
		int sum = n * (n + 1) / 2;

		int sum1 = Arrays.stream(arr).reduce(0, (a, b) -> a + b);

		return sum1 - sum;

	}

	public static void main(String[] args) {
		int num[] = new int[101];
		for (int i = 0; i < num.length - 1; i++) {
			num[i] = i + 1;
		}
		num[num.length - 1] = 55;
		// System.out.println(getDupNum(num));
		System.out.println(getSecondHightNum(num));
	}

	public static int getSecondHightNum(int[] arr) {

		int h1 = arr[0];
		int h2 = Integer.MIN_VALUE;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > h1) {

				h2 = h1;

				h1 = arr[i];
			}
		}

		return h2;

	}
}
