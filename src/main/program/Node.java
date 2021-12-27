package main.program;

public class Node {
	int key;
	Node next;
	Node prev;
	int val;
	Node left;
	Node right;

	Node() {
	}

	Node(int key, int val) {
		this.key = key;
		this.val = val;
		next = null;
		prev = null;
	}

	Node(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
