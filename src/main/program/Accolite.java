package com.main.soroco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Accolite {
	public static void main(String[] args) {
//		Write a program to print all permutations of a given string
//		sample input- ABC. 
//		sample output- ABC ACB BAC BCA CBA CAB
//		Write a program to print all permutations of a given string
//		sample input- ABC. 
//		sample output- ABC ACB BAC BCA CBA CAB
		String s = "ABC";
		List<String> ans = new ArrayList<>();
		getPer(s.toCharArray(), 0, ans, new StringBuilder());
		for (String string : ans) {
			System.out.print(string + " ");
		}
//		System.out.println(ans);
		// getPowerSet(s.toCharArray(), 0, ans, new StringBuilder());
//		System.out.println(ans);
		// sort(new int[] { 0, 1, 0, 0, 0, 0, 0, 1 });
		// MathChallenge("abcabcabcabc");

//		String str = "(6*(4/2)+3*1)";
//		System.out.println(str.substring(str.lastIndexOf("("), str.indexOf(")", str.lastIndexOf("(")) + 1));
	}

	public static void getPer(char[] arr, int pos, List<String> ans, StringBuilder s) {
		if (pos == arr.length) {
			ans.add(Arrays.asList(arr).stream().map(String::valueOf).collect(Collectors.joining()));
			return;
		}

		for (int i = pos; i < arr.length; i++) {
			rotate(arr, pos, i);
			getPer(arr, pos + 1, ans, s);
			rotate(arr, pos, i);
		}
	}

	public static void swap(char[] s, int l, int r) {
		char tmp = s[l];
		s[l] = s[r];
		s[r] = tmp;
	}

	public static void rotate(char[] s, int l, int r) {
		int a = l;
		int b = r;
		while (l < r - 1) {
			char c = s[l];
			s[l] = s[r - 1];
			s[r - 1] = c;
			r--;
			l++;
		}
		while (a < b) {
			char c = s[a];
			s[a] = s[b];
			s[b] = c;
			b--;
			a++;
		}
	}

	public static void getPowerSet(char[] arr, int pos, List<String> ans, StringBuilder s) {
		if (pos == arr.length) {
			ans.add(s.toString());
			return;
		}

		getPowerSet(arr, pos + 1, ans, s.append("" + arr[pos]));
		s.deleteCharAt(s.length() - 1);
		getPowerSet(arr, pos + 1, ans, s);

	}

//	void reverse(int a[], start_index 3, end_index 6)
//	e.g. [4,1,7,2,9,4,11,8] becomes [4,1,7,11,4,9,2,8]

	public static void reverse(int a[], int start_index, int end_index) {
		while (start_index <= end_index) {
			int tmp = a[start_index];
			a[start_index] = a[end_index];
			a[end_index] = tmp;
			start_index++;
			end_index--;
		}
		for (int i : a) {
			System.out.print(i + ", ");
		}
	}

	public static void sort(int a[]) {
		// 0,1,0,0,0,0,0,1

		int p1 = 0, p2 = a.length - 1;

		while (p1 < p2) {
			if (a[p1] == 1) {
				int tmp = a[p2];
				a[p2] = a[p1];
				a[p1] = tmp;
				p2--;
			} else
				p1++;
		}

		for (int i : a) {
			System.out.print(i + ", ");
		}
	}

	public static String MathChallenge(String str) {
		// code goes here

		if (str.length() == 1)
			return "-1";
		int i = 1;
		String ans = "";
		int len = 0;
		StringBuilder sb = new StringBuilder("" + str.charAt(0));
		while (i <= str.length() / 2) {
			if (sb.charAt(0) == str.charAt(i)) {
				String s = str.substring(i, i + sb.length());
				if (s.equals(sb.toString()) && str.length() % sb.length() == 0) {
					ans = sb.toString();
				}
				sb.append("" + str.charAt(i));
			} else {
				sb.append("" + str.charAt(i));
			}
			i++;
		}
		if (ans.isEmpty())
			ans = "-1";
		System.out.println(ans);
		return ans;
	}
}
