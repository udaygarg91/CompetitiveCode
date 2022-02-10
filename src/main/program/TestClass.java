package com.main.soroco;
//package com.main.soroco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//Beautiful number
class TestClass {

	static int n = (int) 1e6;
	static Map<Integer, Integer> mp = new HashMap<>();
	static long dp[] = new long[n];

	static long nextNumber(long n) {
		long totalSum = 0;
		while (n > 0) {
			long d = n % 10;
			n = n / 10;
			totalSum += d * d;
		}
		return totalSum;
	}

	static boolean isbeautiful(long n) {
		if (mp.get(n) != null && mp.get(n) == 1)
			return true;
		Set<Long> seen = new HashSet<>();
		while (n != 1 && !seen.contains(n)) {
			seen.add(n);
			n = nextNumber(n);
		}
		return n == 1;
	}

	static void help() {
		for (int i = 1; i <= 405; i++) {
			if (isbeautiful(i))
				mp.put(i, 1);
		}
		Arrays.fill(dp, 0);
		for (int i = 1; i < n; i++) {
			if (isbeautiful(i))
				dp[i] = i;
		}
		for (int i = 1; i < n; i++) {
			dp[i] += dp[i - 1];
		}
	}

	static long solve(int l, int r) {
		help();
		return dp[r] - dp[l - 1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter wr = new PrintWriter(System.out);

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t_i = 0; t_i < T; t_i++)

		{

			int l = sc.nextInt();

			int r = sc.nextInt();

			long out_ = solve(l, r);

			wr.write(out_ + "\n");

		}
		sc.close();
		wr.close();

		br.close();
	}

}
