package com.main.soroco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Task {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		while (q-- > 0) {
			int n = sc.nextInt();
			int e = sc.nextInt();
			Graph g = null;
			while (e-- > 0) {
				g = new Graph(n);
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				g.addEdge(n1 - 1, n2 - 1);
			}
			int sn = sc.nextInt();
			int[] ans = g.shortestReach(sn - 1);
			for (int i : ans) {
				System.out.print(i + " ");
			}
		}
	}
}

class Graph {
	List<List<Integer>> adjLst;
	int size;

	public Graph(int size) {
		adjLst = new ArrayList<>();
		this.size = size;
		while (size-- > 0)
			adjLst.add(new ArrayList<Integer>());
	}

	public void addEdge(int first, int second) {
		adjLst.get(first).add(second);
		adjLst.get(second).add(first);
	}

	public int[] shortestReach(int startId) { // 0 indexed
		int[] distances = new int[size];
		Arrays.fill(distances, -1);
		Queue<Integer> adj = new LinkedList<>();

		adj.add(startId);
		distances[startId] = 0;
		HashSet<Integer> visited = new HashSet<>();

		visited.add(startId);
		while (!adj.isEmpty()) {
			int curr = adj.remove();
			for (int node : adjLst.get(curr)) {
				if (!visited.contains(node)) {
					adj.add(node);
					visited.add(node);
					distances[node] = distances[curr] + 6;
				}
			}
		}
		return distances;
	}
}
