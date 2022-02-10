package com.main.soroco;

public class PowerSet {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4 };
		int[] t = new int[a.length];
		lexicoPowSet(a, t, 0, 0);
	}

	public static void lexicoPowSet(int[] arr, int tmp[], int pos, int i) {
		for (int j = 0; j < pos; j++) {
			System.out.print(tmp[j]);
		}
		System.out.println();
		if (i == arr.length)
			return;
		for (int j = i; j < arr.length; j++) {
			tmp[pos] = arr[j];
			lexicoPowSet(arr, tmp, pos + 1, j + 1);
		}
	}
	
	public void lexOrIt(int arr[]) {
		
		int i = 0;
		while(i<arr.length)
		{
			
		}
	}
	
	public void lexOrIt1(int arr[], int p) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]+"");
			System.out.println(sb);
		}
//		whi
	}
}
