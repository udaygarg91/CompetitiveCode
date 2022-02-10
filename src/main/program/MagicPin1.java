package com.main.soroco;

import java.util.SortedSet;
import java.util.TreeSet;

public class MagicPin1 {
	public static void main(String[] args) {

		SortedSet<String> set = new TreeSet<>();
		permute("abc".toCharArray(), 0, set);
	}

	public static void permute(char[] arr, int i, SortedSet<String> set) {

		if (i == arr.length) {
			for (char c : arr) {
				System.out.print(c);
			}
			System.out.println();
			return;
		}
		String s = "00";
		if (set.size() != 0)
			s = set.last();
		int j = 0;
		int a = Integer.parseInt(s.charAt(0) + "");
		int b = Integer.parseInt(s.charAt(1) + "");
		if (a < arr.length - 1) {
			i = a++;
		} else if (b < arr.length - 1) {
			j = b++;
		} else {
			i = 0;
			j = 0;
			set.removeAll(set);
		}
		if (!set.contains(j + "" + i)) {
			swap(i, j, arr);
			permute(arr, i + 1, set);
			swap(i, j, arr);
			set.add(j + "" + i);
		} else {
			permute(arr, i, set);
		}

	}

	public static void swap(int i, int j, char[] arr) {
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
	}
}
