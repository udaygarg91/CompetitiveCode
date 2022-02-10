package com.main.soroco;

public class MainClass {

	public void sum(int a, int b) {
		System.out.println(a + b);
	}

	public void sum(int a, int b, int c) {
		System.out.println(a + b + c);
	}

	public void sum(int a, String b) {
		System.out.println(a + b);
	}

	public static void main(String[] args) {
		MainClass m = new Main1();
		//m.sum1(11, "abc", 12);
		m.sum(11, "abc");
	}
	
	
	public static void main1(String[] args) {
		String s = "aabbaccdedeefeAAC";
		s = s.toLowerCase();
		int arr[] = new int[26];

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			arr[c - 'a']++; // 99 - 97 = 2
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 1) {
				char j = (char) (i + 97);
				System.out.print(j + " - " + arr[i] + ", ");
			}
		}
	}
}

class Main1 extends MainClass {

	public void sum(int a, int b, int c) {
		int sum = 0;
		while (c > 0) {
			sum = sum + (a+b);
		}
		System.out.println(sum);
	}

	public void sum(int a, String b) {
		System.out.println(b+"11");
	}

	public void sum1(int a, String b, int c) {
		System.out.println(b+"11"+c);
	}
}
