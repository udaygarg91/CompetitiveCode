package main.program;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class MergeSort {

	int mergeSort(int arr[], int s1, int e1, int s2, int e2) {
		int ic = 0;
		int tmp[] = new int[e2 - s1 + 1];
		int i = s1, j = s2, c = 0;
		while (i <= e1 && j <= e2) {
			if (arr[i] < arr[j])
				tmp[c++] = arr[i++];
			else {
				tmp[c++] = arr[j++];
				ic = ic + (e1 - i + 1);
			}
		}
		while (i <= e1)
			tmp[c++] = arr[i++];
		while (j <= e2)
			tmp[c++] = arr[j++];

		int k = 0;
		while (k < c) {
			arr[s1++] = tmp[k++];
		}
		return ic;
	}

	int ic1 = 0;

	int sort(int arr[], int l, int r) {
		int ic = 0;
		if (l < r) {
			int m = (l + r) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			// merge(arr, l, m, r);
			ic = mergeSort(arr, l, m, m + 1, r);
		}
		ic1 = ic1 + ic;
		return ic1;
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = { 468, 335, 1, 170, 225, 479, 359, 463, 465, 206, 146, 282, 328, 462, 492, 496, 443, 328, 437, 392,
				105, 403, 154, 293, 383, 422, 217, 219, 396, 448, 227, 272, 39, 370, 413, 168, 300, 36, 395, 204, 312,
				323 };

		System.out.println("Given Array");
		printArray(arr);

		MergeSort ob = new MergeSort();
		System.out.println(ob.sort(arr, 0, arr.length - 1));

		System.out.println("\nSorted array");
		printArray(arr);
		Stack<Integer> s = new Stack<>();
		String str = "a";
		int[] freq = new int[26];
        int max = 0;
        char ans = ' ';
        if(str!=null)
        for(int i = 0; i<str.length(); i++){
            int loc = str.charAt(i) - 'a';
            freq[loc]++;
            if(max < freq[loc])
            {
                max = freq[loc];
                ans = str.charAt(i);
            }
        }
        HashMap<String, String> hm = new HashMap<>();
        Set<String> ss = hm.keySet();
        
        String m = "uday";    
       // String local = m+" garg"; //OR String local = "uday";
    	String local = new String(m);
    	//local = local + " garg";
    	//push to master
    	//m = local;
    	System.out.println(m);
    	System.out.println(local);

    	System.out.println(m == local.intern());
    	System.out.println(m.equals(local));
	}

	public List<Integer> countSmaller(int[] nums) {
		Stack<Integer> s = new Stack<>();
		Integer ans[] = new Integer[nums.length];
		s.push(0);
		for (int i = 1; i < nums.length; i++) {
			while (!s.isEmpty() && nums[s.peek()] > nums[i]) {
				ans[s.pop()] = nums[i];
			}
			s.push(i);
		}
		while (!s.isEmpty()) {
			ans[s.pop()] = 0;
		}
		return Arrays.asList(ans);

	}
}
