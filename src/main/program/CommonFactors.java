package main.program;
public class CommonFactors {
	public static void main(String[] args) {
		System.out.println("ud");
		int n = 10;
		int[] arr = new int[n + 1];
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i] + 2;
			for (int j = 2 * i; j <= n; j = j + i) {
				arr[j]++;
			}
		}
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
