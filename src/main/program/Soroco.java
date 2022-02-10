package com.main.soroco;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Soroco {
	public static void main(String[] args) {
//		1 -> abc
//		2 -> def
//		3 -> ghi
//		4 -> jkl
//		5 -> mno
//		6 -> pqr
//		7 -> stuv
//		8 -> wxyz

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "abc");
		map.put(2, "def");
		map.put(3, "ghi");
		map.put(4, "jkl");
		map.put(5, "mno");
		map.put(6, "pqr");
		map.put(7, "stuv");
		map.put(8, "wxyz");
		printCom(map, new StringBuilder(""), "12", 0);
		System.out.println();
		subset(new int[] { 1, 2, 3 }, 0, "");
	}
//
//	input: 23
//	output: dg dh di eg eh ei fg fh fi

	public static void printCom(Map<Integer, String> map, StringBuilder ans, String digit, int pos) {
		if (pos == digit.length()) {
			System.out.print(ans + " ");
			return;
		}

		for (int i = 0; i < map.get(Integer.valueOf(digit.charAt(pos) + "")).length(); i++) {
			char c = digit.charAt(pos);
			String strForDigit = map.get(Integer.valueOf(c + ""));
			ans.append(strForDigit.charAt(i) + "");
			printCom(map, ans, digit, pos + 1);
			ans.deleteCharAt(ans.length() - 1);
		}
	}

	public static void subset(int[] arr, int pos, String s) {
		if (pos == arr.length) {
			System.out.println(s);
			return;
		}
		subset(arr, pos + 1, s + arr[pos]);
		subset(arr, pos + 1, s);

	}
}
