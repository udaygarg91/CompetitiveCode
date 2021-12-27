package main.program;

public class RecSubsets {

	public static void getSubsets(int[] nums, int n, int i, int tmp[], int size) {

		if (i == n) {
			for (int j = 0; j < tmp.length; j++) {
				System.out.print(tmp[j] + " ");
			}
			System.out.println();
			return;
		}
		tmp[size] = nums[i];
		getSubsets(nums, n, i + 1, tmp, size + 1);
		tmp[size] = 0;
		getSubsets(nums, n, i + 1, tmp, size);

	}

	public static void main(String[] args) {
		getSubsets(new int[] { 1, 2, 3 }, 3, 0, new int[3], 0);
	}
}
