package com.main.soroco;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Phenom {
	public static void main(String[] args) {
		// 10(a), 50(b), 5(c)
		// output: number of elements in the range of a to b divided by c
//		System.out.println(m1(10, 50, 7));

		System.out.println(vowelsubstring("aaeiouxaeiou"));
	}

	public static int m1(int min, int max, int divisor) {

		int count = (max / divisor) - (min - 1) / divisor;
		return count;

	}

	public static int vowelsubstring(String s) {
		// Write your code here
		int c = 0;
		int n = s.length();
		String vow = "aeiou";
		Set<String> vSet = new HashSet<>(Arrays.asList(vow.split("")));
		Set<Character> set = null;
		for (int i = 0; i < n - 4;) {
			set = new HashSet<>();
			int j = i;
			boolean b = false;
			String vs = "";
			while (j < n) {
				char cc = s.charAt(j);
				if (vSet.contains(cc + "")) {
					set.add(cc);
					vs = vs + cc;
					if (set.size() == 5)
						b = true;
					j++;
				} else {
					i = j + 1;
					break;
				}
			}
			i = j + 1;
			if (b) {
				Map<Character, Integer> fm = new HashMap<>();
				for (int k = 0; k < vs.length(); k++) {
					char cc = vs.charAt(k);
					if(vSet.contains(cc+""))
					if (fm.containsKey(cc))
						fm.put(cc, fm.get(cc) + 1);
					else
						fm.put(cc, 1);
				}
				int k = 0;
				int a = 1;
				int bb = 1;
				while (k < vs.length() - 4) {
					StringBuffer sb = new StringBuffer(vs);
					char cc = sb.charAt(k);
					fm.put(cc, fm.get(cc) - 1);
					if (fm.get(cc) > 0)
						a++;
					else {
						fm.put(cc, fm.get(cc) + 1);
						break;
					}
					k++;

				}
				k = vs.length() - 1;
				while (k >= 0) {
					StringBuffer sb = new StringBuffer(vs);
					char cc = sb.charAt(k);
					fm.put(cc, fm.get(cc) - 1);
					if (fm.get(cc) > 0)
						bb++;
					else {
						break;
					}
					k--;
				}
				c = c + a * bb;

			}
		}
		return c;
	}
}
