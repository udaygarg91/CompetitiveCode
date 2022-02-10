package com.main.soroco;

import java.util.ArrayList;
import java.util.List;

public class Siply {
	public static void main(String[] args) {
//		ip: [[2, 4], [12, 14], [6, 10], [14, 16], [3, 5]]
//			op:	[[2, 5], [6, 10], [12, 16]]

//		input arr: [
//		        	[1,0,0,1,0]
//		        	[1,0,1,0,0]
//		        	[0,1,1,0,1]
//		        	[1,0,1,0,1]
//		        	[1,0,1,1,0]
//		        ]
//		        output arr: [1,2,2,2,6]

		// [x, y-1][x,y+1][x-1,y][x+1,y]
		
		int ip[][] = new int[5][5];
		ip[0] = new int[] {1,0,0,1,0};
		ip[1] = new int[] {1,0,1,0,0};
		ip[2] = new int[] {0,1,1,0,1};
		ip[3] = new int[] {1,0,1,0,1};
		ip[4] = new int[] {1,0,1,1,0};
		
		List<int[]> adj = new ArrayList<>();
		adj.add(new int[] { 0, -1 });
		adj.add(new int[] { 0, 1 });
		adj.add(new int[] { 1, 0 });
		adj.add(new int[] { -1, 0 });
		int n = ip.length;
		int m = ip[0].length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (ip[i][j] == 1) {
					count++;
				}
				dfs(i, j, adj, ip);
			}
		}
		System.out.println(count);
	}

	public static void dfs(int i, int j, List<int[]> adj, int ip[][]) {
		if (i >= 0 && i < ip.length && j >= 0 && j < ip[0].length && ip[i][j] == 1) {
			if (ip[i][j] == 1)
				ip[i][j] = 0;
			for (int k = 0; k < adj.size(); k++) {
				dfs(i + adj.get(k)[0], j + adj.get(k)[1], adj, ip);
			}
		}

	}
}
