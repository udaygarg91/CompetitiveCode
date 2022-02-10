package com.main.soroco;

public class QuickSort {
	public static void main(String[] args) {
		int arr[] = new int[] {4, 1, 2, 4, 5, 3 };
		quickSortDriver(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i + ", ");
		}
	}

	public static void quickSortDriver(int arr[], int l, int r) {
		if (l < r) {
			int p = quicksort(arr, l, r);
			quickSortDriver(arr, l, p - 1);
			quickSortDriver(arr, p + 1, r);
		}
	}

	public static int quicksort(int arr[], int l, int r) {
		int i = l;
		int j = r;
		while (i < j) {
			while (arr[l] > arr[i] && i < j)
				i++;
			while (arr[l] <= arr[j] && i < j)
				j--;
			if (i < j) {
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
		int t = arr[l];
		arr[l] = arr[j];
		arr[j] = t;
		return j;
	}
}
