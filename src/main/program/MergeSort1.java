package main.program;

import java.util.Arrays;

public class MergeSort1 {

	public static void main(String[] args) {
		int arr[] = { 468, 335, 1, 170, 225, 479, 359, 463, 465, 206, 146, 282, 328, 462, 492, 496, 443, 328, 437, 392,
				105, 403, 154, 293, 383, 422, 217, 219, 396, 448, 227, 272, 39, 370, 413, 168, 300, 36, 395, 204, 312,
				323 };

		System.out.println("Given Array");

		MergeSort1 ob = new MergeSort1();
		System.out.println(ob.sort(arr, 0, arr.length - 1));
		Arrays.stream(arr).forEach(e -> System.out.print(e + ", "));
		System.out.println("\nSorted array");
	}

	private int[] sort(int[] arr, int l, int r) {

		if (l < r) {
			int m = (l + r) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			mergerSort(arr, l, m, m + 1, r);

		}

		return arr;
	}

	private void mergerSort(int[] arr, int s1, int e1, int s2, int e2) {

		int[] tmp = new int[e2 - s1 + 1];
		int i = s1, j = s2, c = 0;
		while (i <= e1 && j <= e2) {
			if (arr[i] < arr[j]) {
				tmp[c++] = arr[i++];
			} else {
				tmp[c++] = arr[j++];
			}
		}
		while (i <= e1)
			tmp[c++] = arr[i++];
		while (j <= e2)
			tmp[c++] = arr[j++];
		int k = 0;
		while (s1 <= e2)
			arr[s1++] = tmp[k++];
	}
}
