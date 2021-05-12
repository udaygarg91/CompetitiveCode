package main.program;

import java.util.Stack;

public class NextLargestElementStack {
	public static void main1(String[] args) {
		int[] arr = new int[] { 6, 8, 0, 1, 3 };
		int ans[] = new int[arr.length];
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		for (int i = 1; i < arr.length; i++) {
			while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
				ans[s.peek()] = arr[i];
				s.pop();
			}
			s.push(i);
		}
		while (!s.isEmpty()) {
			ans[s.peek()] = -1;
			s.pop();
		}
		for (Integer integer : ans) {
			System.err.println(integer + ",  ");
		}
	}

	public static void main(String[] args) {

		int[] arr = new int[] {10, 3, 12, 4, 2, 9, 13, 0, 8, 11, 1, 7, 5, 6};
//		Its Correct output is:
//			12 12 13 9 9 13 -1 8 11 -1 7 -1 6 -1
//
//			And Your Code's output is:
//			12 12 -1 9 9 13 -1 8 11 -1 7 -1 6 -1
		int ans[] = new int[arr.length];
		int n = arr.length;
		ans[n - 1] = n - 1;

		for (int i = n - 2; i >= 0; i--) {
			if (arr[i + 1] > arr[i]) {
				ans[i] = i + 1;
			} else {
				if (arr[i] < arr[ans[i + 1]])
					ans[i] = ans[i + 1];
				else
					ans[i] = i;
			}
		}
		for (int i = 0; i < n; i++) {
			if (ans[i] == i)
				System.out.print(-1+" ");
			else
				System.out.print(arr[ans[i]]+" ");
		}
	}

	public static long[] nextLargerElement(long[] arr, int n) {
		long ans[] = new long[arr.length];
		ans[n - 1] = n - 1;
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i + 1] > arr[i]) {
				ans[i] = i + 1;
			} else {
				if (arr[i] < arr[(int) ans[i + 1]])
					ans[i] = ans[i + 1];
				else
					ans[i] = i;
			}
		}
		for (int i = 0; i < n; i++) {
			if (ans[i] == i)
				ans[i] = -1;
			else
				ans[i] = arr[(int) ans[i]];
		}
		return ans;
	}
}
