package main.program;

public class Sorting10SmallestSubarray {
	public static void main(String[] args) {
		int arr[] = new int[] { 5, 1, 4, 3, 2, 9 };
		int k = 10;
		int incrementalIdx = 0;
		int n = arr.length;
		int sum = 0;
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			while (incrementalIdx < n && sum < k) {
				sum = sum + arr[incrementalIdx];
				incrementalIdx++;
			}
			if (sum >= k) {
				ans = incrementalIdx - i;
				ans = Math.min(ans, Integer.MAX_VALUE);
			}
			sum = sum - arr[i];
		}
		if (ans == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(ans);
	}
}
