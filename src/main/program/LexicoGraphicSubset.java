package main.program;

public class LexicoGraphicSubset {

	public static void subsets(int arr[], int aux[], int i, int size, int n) {
		for (int k = 0; k < size; k++) {
			System.out.print(aux[k]);
		}
		System.out.println();
		if (i == n)
			return;
		for (int j = i; j < n; j++) {
			aux[size] = arr[j];
			subsets(arr, aux, j + 1, size + 1, n);
		}
	}

	public static void main(String[] args) {
		subsets(new int[] { 1, 2, 3, 4 }, new int[4], 0, 0, 4);
	}
}
