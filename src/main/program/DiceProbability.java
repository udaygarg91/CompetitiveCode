package main.program;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiceProbability {

	public static void main(String[] args) {
		int N = 2;
		int M = 6;
		int X = 8;
		Set<ArrayList<Integer>> output = new HashSet<>();
		Integer totComb = 0;
		List<Integer> diceFace = new ArrayList<>();
		int i = 1;
		while (M >= i) {
			diceFace.add(i);
			i++;
		}
		rec(diceFace, N, M, X, 0, 0, output, totComb);
		System.out.println(totComb + "/" + (Math.pow(M, N)));
	}

	public static void rec(List<Integer> diceFace, int N, int M, int X, int idx, Integer sum,
			Set<ArrayList<Integer>> output, Integer totComb) {
		if (idx == N) {
			if (sum == X) {
				totComb++;
			}
			return;
		}
		for (int i = 0; i < diceFace.size(); i++) {
			sum = sum + diceFace.get(i);
			rec(diceFace, N, M, X, idx + 1, sum, output, totComb);
			sum = sum - diceFace.get(i);
		}
	}
}
