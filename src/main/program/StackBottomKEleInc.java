package main.program;

import java.util.Stack;

public class StackBottomKEleInc {

	public static void incBottomKEle(Stack<Integer> s, Integer k, int val) {
		if (s.isEmpty()) {
			return;
		}
		int ele = s.pop();
		incBottomKEle(s, k, val);
		if (s.size() < k) {
			s.push(ele + val);
		} else
			s.push(ele);

	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println(s);
		incBottomKEle(s, 2, 10);
		System.out.println(s);
	}
}
