package com.main.soroco;

import java.util.Stack;

public class Luxoft {
	public static void main(String[] args) {
		//https://leetcode.com/discuss/general-discussion/579606/count-contiguous-subarrays
		//Count contiguous subarrays

		int[] arr = new int[] { 3, 4, 1, 6, 2 };

		// {1, 3, 1, 5, 1}

		Stack<Integer> stack = new Stack<>();
		int[] ans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				ans[i] += ans[stack.pop()];
			}
			stack.push(i);
			ans[i]++;
		}
		stack.clear();

		int n = arr.length - 1;

		for (int i = n; i >= 0; i--) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				ans[i] += ans[stack.pop()];
			}
			stack.push(i);
		}

		for (int i : ans) {
			System.out.print(i + " ");
		}
	}
}
