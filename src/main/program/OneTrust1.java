package com.main.soroco;

import java.util.Stack;

public class OneTrust1 {
	Stack<Integer> stk = new Stack<>();

	Stack<Integer> stk1 = new Stack<>();

	public void insert(Integer i) {
		stk.push(i); // 3
	}

	public Integer retreive() {
		if (stk1.isEmpty()) {
			while (!stk.isEmpty()) {
				stk1.push(stk.pop());
			}
		}
		return stk1.pop();
	}

	public static void main(String[] args) {
		OneTrust1 obj = new OneTrust1();
		obj.insert(1);
		obj.insert(2);
//		obj.insert(1);
		System.out.println(obj.retreive());
		obj.insert(3);
		System.out.println(obj.retreive());
		System.out.println(obj.retreive());
		// 2 3 1 s
		// 1 2 3 q

	}
}
