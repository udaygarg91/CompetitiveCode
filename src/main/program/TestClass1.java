package com.main.soroco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TestClass1 {
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

	static long ps[] = new long[(int) 1e6];

	static long solve(int l, int r) {

		for (int i = 1; i < 1e6; i++) {
			int e = i;
			PriorityQueue<Integer> p = new PriorityQueue<Integer>();
			while (e > 0) {
				int rem = e % 10;
				e /= 10;
				p.add(rem);
			}
			e = 0;
			while (!p.isEmpty()) {
				e = e * 10 + p.poll();
			}

			HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();

			Boolean b = hm.get(e);
			if (b != null && b == true) {

				ps[i] = i;

			}

			else if (b == null && isBeautiful(e, hm)) {

				ps[i] = i;

			}

		}

		for (int i = 2; i < 1e6; i++) {
			ps[i] = ps[i - 1] + ps[i];
		}
		return ps[r] - ps[l - 1];

	}

	public static Boolean isBeautiful(int i, HashMap<Integer, Boolean> hm) {

		int cur = i;

		if (i == 0) {

			return false;

		}

		Boolean b = hm.get(i);
		if (b != null) {

			return b;

		}

		int temp = 0;
		hm.put(i, false);
		while (i > 0) {
			int rem = i % 10;

			temp += rem * rem;

			i /= 10;
		}

		if (temp == 1) {

			hm.put(cur, true);

			return true;

		}

		Boolean flag = isBeautiful(temp, hm);

		hm.put(cur, flag);

		return flag;

	}
}