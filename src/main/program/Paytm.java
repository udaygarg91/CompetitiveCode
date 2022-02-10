package com.main.soroco;

import java.util.PriorityQueue;

public class Paytm {
	public static void main(String[] args) {
		int[] nums = new int[] { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < nums.length; i++) {
			System.out.println(pq);
			if (pq.size() <= k - 1)
				pq.add(nums[i]);
			else if (pq.peek() < nums[i]) {
				pq.poll();
				pq.add(nums[i]);
			}
		}
		
		System.out.println(pq);
	}
}
