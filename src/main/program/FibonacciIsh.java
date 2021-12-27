package main.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class FibonacciIsh {

	public static void main(String[] args) {
		int c = allPossibleFBT(3).size();
		System.out.println(c);
//		Scanner sc = new Scanner(System.in);
//		int size = sc.nextInt();
//		int arr[] = new int[size];
//		for (int i = 0; i < size; i++) {
//			arr[i] = sc.nextInt();
//		}
//		getMaxFibIshCount(arr);
	}

	public static int getMaxFibIshCount(int[] arr) {
		Map<Integer, Integer> freq = new HashMap<>();
		Set<Double> set = new HashSet<>();
		for (int i : arr) {
			int c = freq.getOrDefault(i, 0);
			freq.put(i, ++c);
		}

		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i != j) {
					int a = arr[i];
					int b = arr[j];
//					if (set.contains(a + 1d / b))
//						continue;
//					else
//						set.add(a + 1d / b);
					if (a == b && a == 0)
						max = Math.max(max, freq.get(0));
					else {
						int aFreq = freq.get(a);
						freq.put(a, --aFreq);
						int bFreq = freq.get(b);
						freq.put(b, --bFreq);
						int count = 2;
						while (true) {
							int c = a + b;
							int frq = freq.getOrDefault(c, 0);
							if (frq > 0) {
								freq.put(c, --frq);
								count++;
								a = b;
								b = c;
							} else {
								resetFreqMap(freq, count, a, b);
								break;
							}
						}
						max = Math.max(count, max);
					}
				}
			}
		}
		System.out.println(max);
		return max;
	}

	static void resetFreqMap(Map<Integer, Integer> frqMap, int count, int a, int b) {
		int f = frqMap.get(a);
		frqMap.replace(a, ++f);
		f = frqMap.get(b);
		frqMap.replace(b, ++f);
		while (count - 2 > 0) {
			int c = b - a;
			f = frqMap.get(c);
			frqMap.replace(c, ++f);
			b = a;
			a = c;
			count--;
		}
	}

	public static List<TreeNode> allPossibleFBT(int n) {
		List<List<TreeNode>> trees = new ArrayList<>();
		List<TreeNode> tree = new ArrayList<>();
		tree.add(null);
		trees.add(tree);
		for (int i = 1; i <= n; i++) {
			List<TreeNode> ans = new ArrayList<>();
			for (int j = 0; j < i; j++) {
				List<TreeNode> lst = trees.get(j);
				List<TreeNode> rst = trees.get(i - j - 1);
				for (int k = 0; k < lst.size(); k++)
					for (int l = 0; l < rst.size(); l++) {
						ans.add(new TreeNode(0, lst.get(k), rst.get(l)));
					}
			}
			trees.add(ans);
		}
		return trees.get(n);
	}
}
