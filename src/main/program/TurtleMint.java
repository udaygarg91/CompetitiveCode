package com.main.soroco;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TurtleMint {
	public static void main(String[] args) {
		//String s = "1+2*3*2+3";
		//calBacs(s);
		String s = "(1+2)*3*(2+3)"; //9
		String s1 = "(1*3+2)*5/5+2"; // 7

		Stack<Integer> stk = new Stack<>();
		String tmp = s;
		String tmp1 = "";

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stk.push(i);
			}
			if (s.charAt(i) == ')') {
				String ss = s.substring(stk.pop(), i + 1);
				System.out.println(ss);
//				String res = calBacs(ss);
//				tmp.replaceAll(ss, res);
			}
		}

		char[] arr = tmp.toCharArray();
		List<String> l = new ArrayList<>();
		for (Character character : arr) {
			l.add(character + "");
		}
		List<String> ll = new ArrayList<>(l);

//		for (int i = 1; i < l.size(); i++) {
//			if (l.get(i) == "*") {
//				Integer ans = Integer.valueOf(l.get(i - 1)) * Integer.valueOf(l.get(i + 1));
//				ll.remove(i);
//				ll.remove(i - 1);
//				ll.remove(i + 1);
//				ll.add(i - 1, String.valueOf(ans));
//			} else if (l.get(i) == "/") {
//				int ans = Integer.valueOf(l.get(i - 1)) / Integer.valueOf(l.get(i + 1));
//				ll.remove(i);
//				ll.remove(i - 1);
//				ll.remove(i + 1);
//				ll.add(i - 1, String.valueOf(ans));
//			}
//		}
		int ans = 0;
		for (int i = 0; i < ll.size(); i++) {
			// if()
		}

//		tmp1 = tmp;
//		for (int i = 0; i < tmp.length(); i++) {
//			if(tmp.charAt(i) == '*') {
//				String st = tmp.substring(i-1, i+2);
//				System.out.println(st);
//				calBacs1(st);
//			}
//		}
	}

	public static String calBacs(String s) {
		s.replace('(', ' ');
		s.replace(')', ' ');
		s.trim();
		String ss = s;
		int c = 1;
		int ans = 0;
		while (c<ss.length()) {
			if (ss.charAt(c) == '*') {
				ans = ans + (Integer.valueOf(ss.charAt(c-1))*Integer.valueOf(ss.charAt(c+1)));
				ss.replaceAll(ss.substring(c-1,  c+1), ans+"");
				c++;
			}
			if (ss.charAt(c) == '/') {
				ans = ans + (Integer.valueOf(ss.charAt(c-1))/Integer.valueOf(ss.charAt(c+1)));
				ss.replaceAll(ss.substring(c-1,  c+1), ans+"");
				c++;
			}
		}
		
		while (ss.length()>1) {
			if (ss.charAt(c) == '+') {
				ans = ans + (Integer.valueOf(ss.charAt(c-1))+Integer.valueOf(ss.charAt(c+1)));
				ss.replaceAll(ss.substring(c-1,  c+1), ans+"");
				c++;
			}
			if (ss.charAt(c) == '-') {
				ans = ans + (Integer.valueOf(ss.charAt(c-1))-Integer.valueOf(ss.charAt(c+1)));
				ss.replaceAll(ss.substring(c-1,  c+1), ans+"");
				c++;
			}
		}
		System.out.println(ss);
		return null;
	}

	public static String calBacs1(String s) {
		return null;
	}

}
