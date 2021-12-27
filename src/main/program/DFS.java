package main.epam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DFS {
//	public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
//		ArrayList<Integer> ans = new ArrayList<>();
//		int[] v = new int[adj.size()];
//		Arrays.fill(v, 0);
//		for (int i = 0; i < adj.size(); i++)
//			dfs(i, adj, v, ans);
//		return ans;
//	}
//
//	public void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] v, ArrayList<Integer> ans) {
//		if (v[node] == 1)
//			return;
//
//		v[node] = 1;
//		ans.add(node);
//		for (int i = 0; i < adj.get(node).size(); i++) {
//			dfs(adj.get(node).get(i), adj, v, ans);
//		}
//
//	}

	public static void main(String args[]) throws Exception {

		// Write your code here
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int e = s.nextInt();
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i <= n ; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < e; i++) {
			int n1 = s.nextInt();
			int n2 = s.nextInt();
			adj.get(n1).add(n2);
			adj.get(n2).add(n1);
		}

		ArrayList<Integer> ans = new ArrayList<>();
		int[] v = new int[n + 1];
		Arrays.fill(v, 0);
		int c = 0;
		for (int i = 1; i <= n; i++) {
			if (v[i] == 0)
				c++;
			dfs(i, adj, v, ans);
		}
		System.out.print(c);
	}

	public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] v, ArrayList<Integer> ans) {
		if (v[node] == 1)
			return;

		v[node] = 1;
		ans.add(node);
		for (int i = 0; i < adj.get(node).size(); i++) {
			//System.out.println(i);
			dfs(adj.get(node).get(i), adj, v, ans);
		}
	}
}
