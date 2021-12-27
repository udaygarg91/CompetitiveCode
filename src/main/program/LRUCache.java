package main.program;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	int maxSize;
	int currSize;
	Node head;
	Node tail;
	Map<Integer, Node> keyToAddress;

	public LRUCache(int capacity) {
		maxSize = capacity;
		currSize = 0;
		head = null;
		tail = null;
		keyToAddress = new HashMap<>();
	}

	public int get(int key) {
		int ans;
		if (!keyToAddress.containsKey(key))
			ans = -1;
		else {
			Node node = keyToAddress.get(key);
			moveToTail(node);
			ans = node.val;
		}
		return ans;
	}

	public void put(int key, int value) {
		if (keyToAddress.containsKey(key)) {
			Node node = keyToAddress.get(key);
			node.val = value;
			moveToTail(node);
			return;
		}
		if (currSize < maxSize) {
			keyToAddress.put(key, addToTail(key, value));
		} else {
			keyToAddress.remove(head.key);
			deleteAtHead();
			keyToAddress.put(key, addToTail(key, value));
		}

	}

	void moveToTail(Node node) {
		if (node == tail)
			return;
		if (node == head) {
			head = head.next;
			head.prev = null;
		} else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		node.prev = tail;
		node.prev.next = node;
		node.next = null;
		tail = node;
	}

	Node addToTail(int key, int val) {
		Node newNode = new Node(key, val);
		if (tail == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		currSize++;
		return newNode;
	}

	void deleteAtHead() {
		head = head.next;
		if (head != null)
			head.prev = null;
//		else
//			tail = head;
		currSize--;
	}
}
