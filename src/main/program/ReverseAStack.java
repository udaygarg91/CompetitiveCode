package main.program;

import java.util.Stack;

public class ReverseAStack {

	public static void reverse(Stack<Integer> s) {
		if (s.isEmpty()) {
			return;
		}
		int tmp = s.pop();
		reverse(s);
		pushBottom(tmp, s);
	}

	public static void pushBottom(int y, Stack<Integer> s) {
		if (s.isEmpty()) {
			s.push(y);
			return;
		}
		int tmp = s.pop();
		pushBottom(y, s);
		s.push(tmp);
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.add(4);
		s.add(3);
		s.add(2);
		s.add(1);
		System.out.println(s);
		reverse(s);
		System.out.println(s);
	}
}
