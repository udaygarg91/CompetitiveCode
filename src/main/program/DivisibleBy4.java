package main.program;
import java.util.Arrays;
import java.util.Iterator;

public class DivisibleBy4 {

	public static int count4Divisibiles(int arr[], int n) {

		int k = 4;
		int remArr[] = new int[k];
		Arrays.fill(remArr, 0);
		for (int i = 0; i < arr.length; i++) {
			remArr[arr[i] % k]++;
		}

		int ans = 0;
		ans += remArr[0] * (remArr[0] - 1) / 2;
		int j;
		if (k % 2 != 0)
			j = k / 2;
		else {
			j = k / 2 - 1;
			ans += remArr[k / 2] * (remArr[k / 2] - 1) / 2;
		}
		for (int i = 1; i <= j; i++) {
			ans += remArr[i] * (remArr[k - i]);
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(count4Divisibiles(new int[] { 2, 2, 1, 7, 5 }, 5));
	}
}
