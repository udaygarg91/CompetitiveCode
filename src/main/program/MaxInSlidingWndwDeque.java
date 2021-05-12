package main.program;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxInSlidingWndwDeque {
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		int[] ans = maxInSlidingWndwDeque(nums, k);
	}

	public static int[] maxInSlidingWndwDeque(int[] nums, int k) {
		int n = nums.length;
		int[] ans = new int[n - k + 1];
		int count = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		dq.push(0);
		for (int i = 1; i < k; i++) {
			while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
				dq.pollLast();
			}
			dq.addLast(i);
		}
		// System.out.println(nums[dq.peekFirst()]);
		ans[count++] = nums[dq.peekFirst()];
		for (int i = k; i < n; i++) {
			if (dq.peekFirst() == i - k) {
				dq.pollFirst();
			}
			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
				dq.pollLast();
			}
			dq.addLast(i);
			ans[count++] = nums[dq.peekFirst()];
			// System.out.println(nums[dq.peekFirst()]);
		}
		return ans;
	}
}
