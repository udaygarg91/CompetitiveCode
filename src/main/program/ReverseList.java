package main.program;

public class ReverseList {
	public static void main(String[] args) {
		int i = 5;
		ListNode n = new ListNode(6);
		ListNode n1 = new ListNode(5);
		n.next = n1;
		ListNode n2 = new ListNode(4);
		n1.next = n2;
		ListNode n3 = new ListNode(3);
		n2.next = n3;
		ListNode n4 = new ListNode(2);
		n3.next = n4;
		ListNode t = null;
		ListNode c = n, p = null;
		while (c != null) {
			t = c.next;
			c.next = p;
			p = c;
			c = t;
			//System.out.println("p:" + p.val + " c:" + c.val + "");
		}
		t = p;
		while (t != null) {
			System.out.println(t.val);
			t = t.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	public ListNode(int val) {
		this.val = val;
	}
}
