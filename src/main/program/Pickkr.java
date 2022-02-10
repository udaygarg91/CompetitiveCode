package com.main.soroco;

public class Pickkr {

	public static void main(String[] args) {
		int arr[] = new int[] { 0, 0, 1, 1, 2, 2, 0, 0, 0 ,1};

		int l = 0;
		int r = arr.length - 1;

		for (int i = 0; i < arr.length;) {
			if (arr[i] == 0) {
				int t = arr[l];
				arr[l] = arr[i];
				arr[i] = t;
				l++;
				i++;
			} else if (arr[i] == 2) {
				int t = arr[r];
				arr[r] = arr[i];
				arr[i] = t;
				r--;
			} else
				i++;
		}

		for (int i : arr) {
			System.out.print(i + " ");
		}

	}
}
