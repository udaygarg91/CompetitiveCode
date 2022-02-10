package com.main.soroco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChaiPay {
	public static long prison(int n, int m, List<Integer> h, List<Integer> v) {
		// Write your code here
		n = n + 1;
		m = m + 1;
		
		System.out.println(h);
		System.out.println(v);
		
		Collections.sort(h);
		Collections.sort(v);
		
		
		
		int[][] p = new int[n][m];
		for (int i = 0; i < n; i++)
			Arrays.fill(p[i], 0);
		for (int i = 0; i < h.size(); i++) {
			for (int j = 0; j < v.size(); j++) {
				int hh = h.get(i);
				int vv = v.get(j);
				hh = hh - 1;
				vv = vv - 1;
				int[] arr = new int[] { hh - 1, hh };
				int[] arr1 = new int[] { vv - 1, vv };

				int nn = n;
				while (nn > 0) {
					if (hh > 0) {
						p[nn - 1][hh] = 1;
						p[nn - 1][hh - 1] = 1;
					}
					nn--;
				}
				int mm = m;
				while (mm > 0) {
					if (vv > 0) {
						p[vv][mm - 1] = 1;
						p[vv - 1][mm - 1] = 1;
					}
					mm--;
				}

//				p[hh - 1][vv - 1] = 1;
//				p[hh][vv - 1] = 1;
//				p[hh - 1][vv] = 1;
//				p[hh][vv] = 1;
			}
		}
		int c1 = 0, c2 = 0;
		int c11 = 0, c22 = 0;
		for (int i = 0; i < m; i++) {
			if (p[0][i] == 1) {
				c1++;
			} else {
				c2 = Math.max(c1, c2);
				c1 = 0;
			}

			if (p[n - 1][i] == 1) {
				c11++;
			} else {
				c22 = Math.max(c11, c22);
				c11 = 0;
			}
		}
		c2 = Math.max(c1, c2);
		c22 = Math.max(c11, c22);
		c2 = Math.min(c2, c22);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(p[i][j] + " ");
			}
			System.out.println();
		}

		int c3 = 0, c4 = 0;
		int c33 = 0, c44 = 0;
		for (int i = 0; i < n; i++) {
			if (p[i][0] == 1) {
				c3++;
			} else {
				c4 = Math.max(c3, c4);
				c3 = 0;
			}
			if (p[i][m - 1] == 1) {
				c33++;
			} else {
				c44 = Math.max(c33, c44);
				c33 = 0;
			}
		}
		c4 = Math.max(c3, c4);
		c44 = Math.max(c33, c44);
		c4 = Math.min(c4, c44);

		System.out.println(c2 * c4);
		return c2 * c4;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		int m = Integer.parseInt(bufferedReader.readLine().trim());

		int hCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> h = IntStream.range(0, hCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());

		int vCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> v = IntStream.range(0, vCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());

		long result = ChaiPay.prison(n, m, h, v);

//	        bufferedWriter.write(String.valueOf(result));
//	        bufferedWriter.newLine();
//
//	        bufferedReader.close();
//	        bufferedWriter.close();
	}
}
