package com.main.soroco;

import java.util.Stack;

public class BetterPlace {
	public static void main(String[] args) {
		String str = "001129122045";
		int n = 6; // 001045
//		String str = "121198";
//		int n = 2; //1118
//		String str = "765028321";
//		int n = 5; //0221
//		String str = "4325043";
//		int n = 3; //2043
		StringBuilder ans = new StringBuilder();
//		getSmallNum(str, n, str.length() - n, ans);
//		System.out.println(ans);
		getSmallNum(str, n);
	}

	public static void getSmallNum(String str, int n, int ansLen, StringBuilder ans) {

		if (ans.length() == ansLen)
			return;
		char c = str.charAt(n);
		int idx = n;
		for (int i = n - 1; i >= 0; i--) {
			char cc = str.charAt(i);
			if (cc <= c) {
				c = cc;
				idx = i;
			}
		}

		ans = ans.append(str.charAt(idx) + "");

		str = str.substring(idx + 1);
		n = n - idx;

		getSmallNum(str, n, ansLen, ans);

	}

	public static void getSmallNum(String str, int n) {

		if (n > str.length())
			return;
		if (n == 0)
			return;
		Stack<Character> s = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			while (!s.isEmpty() && n > 0 && c < s.peek()) {
				n--;
				s.pop();
			}
			s.push(c);
		}
		System.out.println(s);
		System.out.println();
	}
}
