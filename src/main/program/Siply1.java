package com.main.soroco;

public class Siply1 {
	public static void main(String[] args) {
//		1->2->3->4->5
//		number = 2 , position = 1
		// op: 1->2->5
//		number = 2 , position = 2
		// 1 4 5

		List head = new List(1);
		head.next = new List(2);
		List tmp = head.next;
		tmp.next = new List(3);
		tmp = tmp.next;
		tmp.next = new List(4);
		tmp = tmp.next;
		tmp.next = new List(5);

		tmp = head;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();

		removeListElement(head, 4, 1);
	}

	public static void removeListElement(List head, int number, int position) {
		List tmp = head;
		List slow = head;
		List fast = head;
		List tmp1 = head;
		int totElement = 0;
		int c = 0;
		int c2 = 0;
		while (fast.next != null) {
			if (c2 == number + position) {
				tmp1 = tmp1.next;
			} else {
				c2++;
			}

			if (c == position) {
				slow = slow.next;
			} else {
				c++;
			}
			fast = fast.next;
			totElement++;
		}
		totElement++;
		System.out.println("totElement : " + totElement);
		if (position > totElement || number > totElement || position + number > totElement) {
			System.out.println("Invalid input");
			return;
		}
		slow = slow.next;
		tmp1.next = slow;
		if (position + number == totElement)
			head = tmp1.next;
		tmp = head;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}
}

class List {
	int data;
	List next = null;

	public List(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public List getNext() {
		return next;
	}

	public void setNext(List next) {
		this.next = next;
	}

}