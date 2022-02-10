package com.main.soroco;

public class Siply3 {
	public static void main(String[] args) {

		String s = "t";
		if (s.length() > 1) {
			s = s.charAt(s.length() - 1) + " " + s.charAt(s.length() - 2);
			System.out.println(s);
		}
		// numOfPath(3, 3, null);
	}

	public static int numOfPath(int m, int n, int[][] mat) {
		mat = new int[m][n];

		if (mat[m - 1][n - 1] == 1)
			return 0;

		mat[0][0] = 1;

		int i = 1, j = 1;
		while (i < m) {
			mat[0][i++] = 1;
		}
		while (j < n) {
			mat[j++][0] = 1;
		}

		for (i = 1; i < m; i++) {
			for (j = 1; j < n; j++) {
				mat[i][j] = mat[i - 1][j] + mat[i][j - 1];
			}
		}

		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		return 0;
	}

	public static int numOfPathRecursive(int i, int j, int m, int n, int[][] mat) {
		if (i == m - 1 || j == n - 1) {
			return 1;
		}
		int x = numOfPathRecursive(i + 1, j, m, n, mat);
		int y = numOfPathRecursive(i, j + 1, m, n, mat);
		return x + y;
	}
}
