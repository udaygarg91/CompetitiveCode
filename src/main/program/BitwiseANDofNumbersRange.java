package main.program;

import java.util.Scanner;

public class BitwiseANDofNumbersRange {
	public int rangeBitwiseAnd(int left, int right) {
		long mask = 1l << 32;
		long ans = 0;
		while (mask != 0) {
			if ((mask & left) == (mask & right)) {
				if ((mask & left) != 0) {
					ans = ans + mask;
				}
				mask >>= 1;
			} else {
				break;
			}
		}
		return (int) ans;
	}

	public static void main1(String[] args) {
		String s = "1101";
		StringBuilder ss = new StringBuilder(s);
		int cc = 0;
		int c = 0;
		for (int i = ss.length() - 1; i > 0;) {
			c = 0;
			boolean b = false;
			while (i >= 0 && ss.charAt(i) == '1') {
				ss.setCharAt(i, '0');
				i--;
				b = true;
				c++;
			}
			if (i >= 0 && b && ss.charAt(i) == '0') {
				ss.setCharAt(i, '1');
				i = i + c - 1;
				cc = cc + 2;
			} else if (i >= 0 && ss.charAt(i) == '0') {
				i = i - 1;
				cc = cc + 1;
			}
		}
		if (c != 0)
			System.out.println(cc + c + 1);
		else
			System.out.println(cc);

//		int n = 3;
//		System.out.println(countOfSetBit(n));
//		long m = 1l << 31;
//		while (m != 0) {
//			if ((n & m) != 0) {
//				if (m + countOfSetBit(m) == n) {
//					System.out.println(0);
//					return;
//				}
//			}
//			m = m >> 1;
//		}
//		System.out.println(1);
		// System.out.println(m);
	}

	public static void main2(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long arr[] = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		long ans = 0l;
		ans = ans + arr[n - 1] * n + arr[0] * n;
		for (int i = n - 2; i > n / 2; i--) {
			ans = ans + arr[i] * (n - i) * 2 + arr[n - i - 1] * (n - i) * 2;
		}
		if (n % 2 != 0) {
			ans = ans + arr[n / 2] * (n / 2 + 1) * 2;
		}
		System.out.println(ans - 1);
	}

	public static int countOfSetBit(long n) {
		int c = 0;
		while (n != 0) {
			c++;
			n = n & (n - 1);
		}
		return c;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String v = sc.next();
		int n = sc.nextInt();
		for (int k = 0; k < n; k++) {
			String s = sc.next();
			StringBuilder ss = new StringBuilder(v);
			boolean status = false;
			for (int i = 0; i < s.length(); i++) {
				int idx = ss.indexOf(String.valueOf(s.charAt(i)));
				if (idx == -1) {
					status = true;
					break;
				}
				ss = ss.delete(0, idx + 1);
			}
			if (status)
				System.out.println("NEGATIVE");
			else
				System.out.println("POSITIVE");
		}
	}
}
