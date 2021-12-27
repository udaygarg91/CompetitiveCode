package main.program;

import java.util.ArrayList;
import java.util.List;

public abstract class FindSubsets {
	public static void main(String[] args) {
		//new FindSubsets().subsets(new int[] { 1, 2, 3 });
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> answer = new ArrayList<>();
		findSS(nums, nums.length, 0, new ArrayList<>(), 0, answer);
		return answer;
	}

	public void findSS(int[] nums, int numSize, int i, List<Integer> subset, int size, List<List<Integer>> answer) {
		if (i == numSize) {
			answer.add(new ArrayList<>(subset));
			return;
		}
		subset.add(size, nums[i]);
		findSS(nums, numSize, i + 1, subset, size + 1, answer);
		subset.remove(size);
		findSS(nums, numSize, i + 1, subset, size, answer);
	}
}
