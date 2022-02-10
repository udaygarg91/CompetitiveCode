package com.main.soroco;

import java.util.HashMap;
import java.util.Map;

public class MagicPin {

	public static void main(String[] args) {

		Map<Integer, String> keys = new HashMap<>();
		keys.put(2, "abc");
		keys.put(3, "def");
		keys.put(4, "ghi");
		keys.put(5, "jkl");
		keys.put(6, "mno");
		keys.put(7, "pqrs");
		keys.put(8, "tuv");
		keys.put(9, "wxyz");
		keys.put(0, " ");
		printCombo(keys, "23", 0, new StringBuilder());
	}

	public static void printCombo(Map<Integer, String> keys, String digits, int i, StringBuilder ans) {

		if (i == digits.length()) {
			System.out.print(ans + " ");
			return;
		}

		int digit = Integer.parseInt(digits.charAt(i) + "");
		for (int j = 0; j < keys.get(digit).length(); j++) {
			char c = keys.get(digit).charAt(j);
			ans = ans.append(c + "");
			printCombo(keys, digits, i + 1, ans);
			ans.deleteCharAt(ans.length() - 1);
		}

	}
}
