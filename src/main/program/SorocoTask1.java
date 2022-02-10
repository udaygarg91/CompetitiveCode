package com.main.soroco;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class SorocoTask1 {
	static ArrayList<String> generate(int N) {
		ArrayList<String> l = new ArrayList<>();
		if (N == 0)
			return l;
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(1);
		int c = 0;
		while (c < N) {
			int e = q.poll();
			l.add(e + "");
			q.add(e * 10);
			q.add(e * 10 + 1);
			c++;
		}
		return l;
	}

	public static int findSmallestDivisor(String s, String t) {
		// Write your code here
		int sl = s.length();
		int tl = t.length();
		if (sl % tl != 0)
			return -1;
		for (int i = 0; i <= tl; i = i + tl) {
			String ss = s.substring(i, i + tl);
			if (!ss.equals(t))
				return -1;

		}
		while (t.substring(0, tl / 2).equals(t.substring(tl / 2))) {
			t = t.substring(tl / 2);
		}
		return t.length();
	}

	public static int[] maxSlidingWindow(int[] arr, int x) {

		int n = arr.length;
		int ans[] = new int[n - x + 1];
		int c = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		dq.addFirst(0);
		for (int i = 1; i < x; i++) {
			while (!dq.isEmpty() && arr[dq.peekLast()] > arr[i]) {
				dq.pollLast();
			}
			dq.addLast(i);
		}
		ans[c++] = arr[dq.peekFirst()];
		for (int i = x; i < n; i++) {
			if (dq.peekFirst() == i - x) {
				dq.pollFirst();
			}
			while (!dq.isEmpty() && arr[dq.peekLast()] > arr[i]) {
				dq.pollLast();
			}
			dq.addLast(i);
			ans[c++] = arr[dq.peekFirst()];
		}
		return ans;
	}

// Driver code
	public static void main(String[] args) {
		int arr[] = { 2, 5, 4, 6, 8, 5 };
		int k = 3;
		arr = maxSlidingWindow(arr, k);
		for (int i : arr) {
			System.out.println(i);
		}
		// System.out.println(findSmallestDivisor("aaaaaa", "aaa"));
	}
}
