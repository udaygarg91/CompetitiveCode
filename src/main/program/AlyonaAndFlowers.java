package main.program;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AlyonaAndFlowers {
	public static void main(String[] args) {
		String s = "123bcdaei1f";
		List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		char[] arr = s.toCharArray();
		int n = arr.length - 1;
		int vC = 0, cC = 0, nC = 0;
		for (int i = 0; i <= n; i++) {
//			if (vC + nC + 1 == n - cC) {
//				break;
//			}
			char ch = arr[i];
			if (Character.isDigit(ch)) {
				char tmp = arr[n - nC];
				if(!Character.isDigit(tmp))
				{
				arr[n - nC] = ch;
				arr[i] = tmp;}
				nC++;
				cC++;
			} else if (vowels.contains(ch)) {
				char tmp = arr[vC];
				if(!vowels.contains(tmp))
				{
				arr[vC] = ch;
				arr[i] = tmp;}
				vC++;
				cC++;
			} else {

			}

		}
		System.out.println(arr);
	}

	public static void main2(String[] args) {

		// code here
		long n = 11;
		long a[] = new long[] { 6, 5, 11, 4, 9, 11, 8, 2, 6, 4, 5 };
		long sum = 0;
		long m = (long) Math.pow(10, 5);
		for (int i = 0; i < n; i++) {
			sum = sum + ((i + 1) % m * (n - i) % m * a[i] % m) % m;
		}
		System.out.println(sum);

	}

	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[n];
		arr[0] = sc.nextInt();
		for (int i = 1; i < n; i++) {
			arr[i] = sc.nextInt() + arr[i - 1];
		}
		int happiness = 0;
		while (m > 0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int sum;
			if (l == 1)
				sum = arr[r - 1];
			else
				sum = arr[r - 1] - arr[l - 2];
			if (sum > 0)
				happiness = happiness + sum;
			m--;
		}
		System.out.println(happiness);
	}
}
