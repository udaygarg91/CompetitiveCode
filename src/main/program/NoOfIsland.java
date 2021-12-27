package main.epam;

import java.util.ArrayList;
import java.util.Arrays;

public class NoOfIsland {
	public int numIslands(char[][] grid) {
		ArrayList<int[]> adj = new ArrayList<>();
		adj.add(new int[] { 0, -1 });
		adj.add(new int[] { 0, 1 });
		adj.add(new int[] { 1, 0 });
		adj.add(new int[] { -1, 0 });

		int n = grid.length;
		int m = grid[0].length;

		int[][] v = new int[n][m];

		int c = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1' && v[i][j] != 1) {
					c++;
				}
				dfs(grid, v, adj, i, j);
			}
		}
		return c;
	}

	private static void dfs(char[][] grid, int[][] v, ArrayList<int[]> adj, int r, int c) {
		if (!isValid(r, c, grid))
			return;
		if (v[r][c] == 1)
			return;
		if (v[r][c] == 0)
			v[r][c] = 1;

		for (int i = 0; i < adj.size(); i++) {
			dfs(grid, v, adj, r + adj.get(i)[0], c + adj.get(i)[1]);
		}
	}

	private static boolean isValid(int r, int c, char[][] grid) {
		return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1';
	}
}
