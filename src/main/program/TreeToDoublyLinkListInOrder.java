package main.program;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class TreeToDoublyLinkListInOrder {

	Entry<Node, Node> convertToDLL(Node root) {
		if (root == null)
			return new SimpleEntry<Node, Node>(null, null);
		Entry<Node, Node> lst = convertToDLL(root.left);
		Entry<Node, Node> rst = convertToDLL(root.right);
		Node head = root;
		Node tail = root;
		root.left = lst.getValue();
		if (lst.getValue() != null) {
			head = lst.getKey();
			lst.getValue().right = root;
		}
		root.right = rst.getKey();
		if (rst.getKey() != null) {
			tail = rst.getValue();
			rst.getKey().left = root;
		}
		return new SimpleEntry<Node, Node>(head, tail);

	}

	public static void main(String[] args) {

	}

}

