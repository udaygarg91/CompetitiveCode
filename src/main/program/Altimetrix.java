package com.main.soroco;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Altimetrix {
	public static void main(String[] args) {
		String s = "defgacdciacdaabacde";
		List<String> ans = new ArrayList<>(); // ac ca aci
		int c = 0;
		String ss = s.charAt(c) + "";
		ans.add(ss);
		for (int i = 1; i < s.length();) {
			char ch = s.charAt(i);
			if (s.substring(c, i).contains(ch + "")) {
				if (ans.get(0).length() < ss.length()) {
					ans.removeAll(ans);
					ans.add(ss);
				} else if (ans.get(0).length() == ss.length()) {
					ans.add(ss);
				}
				ss = ss.substring(1);
				c = c + 1;
			} else {
				ss = ss + ch;
				i++;
			}
		}
		if (ans.get(0).length() < ss.length()) {
			ans.removeAll(ans);
			ans.add(ss);
		} else if (ans.get(0).length() == ss.length()) {
			ans.add(ss);
		}
		System.out.println(ans);
	}

}
