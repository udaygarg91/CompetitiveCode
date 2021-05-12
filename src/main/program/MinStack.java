package main.program;

import java.util.Stack;

public class MinStack extends FindSubsets {
	/** initialize your data structure here. */
	long curMin;
	Stack<Long> stk = null;

	public MinStack() {
		
		curMin = Integer.MAX_VALUE;
		stk = new Stack<>();
	}

	public void push(int val) {
		if (stk.isEmpty()) {
			stk.push((long) val);
			curMin = val;
			return;
		}
		if (val < curMin) {
			stk.push(2 * (long) val - curMin);
			curMin = val;
			return;
		}
		stk.push((long) val);
	}

	public void pop() {
		if (stk.peek() < curMin) {
			curMin = (2 * (long)curMin - stk.pop());
		} else {
			stk.pop();
		}
	}

	public int top() {
		if (stk.peek() < curMin)
			return (int) curMin;
		return stk.peek().intValue();
	}

	public int getMin() {
		return (int) curMin;
	}

	public static void main(String[] args) {
		MinStack ms = new MinStack();
		System.out.println(ms.getMin());
		ms.push(2147483646);
		System.out.println(ms.top());
		ms.push(2147483647);
		System.out.println(ms.getMin());
		ms.push(2147483647);
		System.out.println(ms.top());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		ms.push(2147483647);
		System.out.println(ms.top());
		System.out.println(ms.getMin());
		ms.push(-2147483648);
		System.out.println(ms.top());
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
	}
}
