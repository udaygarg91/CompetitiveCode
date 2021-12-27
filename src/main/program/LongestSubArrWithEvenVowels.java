package main.program;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubArrWithEvenVowels {
	public static void main(String[] args) {
	// String s = "leetcodeisgreat";
	 String s = "eleetminicoworoep";
		Map<Character, Integer> bitMap = new LinkedHashMap<>();
		bitMap.put('a', 0);
		bitMap.put('e', 0);
		bitMap.put('i', 0);
		bitMap.put('o', 0);
		bitMap.put('u', 0);
//		0, 1-0
//		1, 2-0
//		2, 3-0
//		3, 4-0
//		4, 5-0
//		5, 7-6
//		5, 8-0
//		8, 9-0
//		9, 11-10
//		9, 12-0
//		12, 13-0
//		13, 14-10
//		13, 16-15
//		13
		Map<Character, Integer> seqMap = new LinkedHashMap<>();
		seqMap.put('a', 0);
		seqMap.put('e', 1);
		seqMap.put('i', 2);
		seqMap.put('o', 3);
		seqMap.put('u', 4);

		int[] freq = new int[s.length()];
		int sum = 0;
		int max = 0;
		Map<Integer, int[]> map = new HashMap<>();
		map.put(0, new int[] { 0, 0 });
		for (int i = 0; i < s.length(); i++) {
			if (bitMap.keySet().contains(s.charAt(i))) {
				int bit = bitMap.get(s.charAt(i)) == 0 ? 1 : 0;
				bitMap.put(s.charAt(i), bit);
				sum = 0;
				for (char key : bitMap.keySet()) {
					if (bitMap.get(key) == 0)
						sum = (int) (sum + seqMap.get(key));
				}
			}
			freq[i] = sum;
			System.out.print(freq[i] + "="+i+" ,, ");
		}

		for (int i = 0; i < freq.length; i++) {
			int[] a = null;
			if (map.keySet().contains(freq[i])) {
				a = map.get(freq[i]);
				a[1] = i;
				map.put(freq[i], a);
			} else {
				a = new int[] { i, i };
				map.put(freq[i], a);
			}
			max = Math.max(max, a[1] - a[0]);
		}
		System.out.print(max);
	}
}
