package main.program;

import java.util.LinkedList;
import java.util.Queue;

//Input: nums = [4,14,2]
//Output: 6
//Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
//showing the four bits relevant in this case).
//The answer will be:
//HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
//https://leetcode.com/problems/total-hamming-distance/
public class HammingDistance {
	public int totalHammingDistance(int[] nums) {
		int ans = 0;
		long m = (1l << 31);
		int n = nums.length;
		for (int i = 31; i >= 0; i--) {
			int c = 0;
			for (int j = 0; j < n; j++) {
				if ((m & nums[j]) != 0)
					c++;
			}
			ans = ans + c * (n - c);
			m = (m >> 1l);
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new HammingDistance().totalHammingDistance(new int[] { 4, 14, 2 }));

	}
}
