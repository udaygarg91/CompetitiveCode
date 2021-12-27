package main.program;

import java.util.Arrays;

public class SingleNonDup {
	public int singleNonDuplicate(int[] nums) {
	System.out.println(Arrays.binarySearch(nums,3));
		
//		int l = 0, h = nums.length - 1;
//		while (l <= h) {
//			if (l == h) {
//				return nums[l];
//			}
//			int m = (l + h) / 2;
//			if (m % 2 == 1) {
//				if (nums[m] == nums[m - 1]) {
//					l = m + 1;
//				} else if (nums[m] == nums[m + 1]) {
//					h = m - 1;
//				} else
//					return nums[m];
//			} else if (m % 2 == 0) {
//				if (m != 0 && nums[m] == nums[m - 1]) {
//					h = m - 1;
//				} else if (nums[m] == nums[m + 1]) {
//					l = m + 1;
//				} else
//					return nums[m];
//			}
//		}
		return nums[0];
	}

	public static void main(String[] args) {
		System.out.println(new SingleNonDup().singleNonDuplicate(new int[] { 1, 3, 3, 4, 5 }));
	}
}
