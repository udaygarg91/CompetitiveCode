package com.main.soroco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Task2 {

	public static int countHighlyProfitableMonths(List<Integer> stockPrices, int k) {
		if (k == 1)
			return stockPrices.size();
		int c = 0;
		int s = 0;
		for (int i = 1; i < stockPrices.size(); i++) {
			if (stockPrices.get(i) > stockPrices.get(i - 1) && (i - s) == k - 1) {
				c++;
				if (i < stockPrices.size() - 2 && stockPrices.get(i + 1) <= stockPrices.get(i))
					s = i + 1;
				else
					s = s + 1;
			} else if (stockPrices.get(i) <= stockPrices.get(i - 1) && (i - s) != k - 1) {
				s = i;
			}
		}
		return c;
	}

	public static void main(String[] args) {
		System.out.println("haha");
		Integer[] a = new Integer[] { 7, 1, 2, 3, 6, 9, 12, 3, 2 };// { 5, 3, 5, 7, 8 };
		System.out.println(countHighlyProfitableMonths(Arrays.asList(a), 8));
	}

	public static void main1(String[] args) {
		// f1(str s, int k) ->
		// s -> aabbbc op: k=2 ba k=1 b

		kFreqElem("aabbbc");

		int[] arr = new int[10];

		// 4*10 = 40 add:1001-1040
		Arrays.fill(arr, 1);

		System.out.println();

		String s = "s";
		System.out.println(s.split("\\|").length);

		List<String> l = new ArrayList<>();
		l.add("a");
		l.add("a");
		System.out.println(l);

		List<Integer> l2 = new ArrayList<>(Arrays.asList(1, 1, 5));
		Set<Integer> l1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
		System.out.println(l1.retainAll(l2));
		System.out.println(l1);

	}

	public static String kFreqElem(String str) {
		Map<Character, Integer> freqMap = new LinkedHashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (freqMap.containsKey(c))
				freqMap.put(c, freqMap.get(c) + 1);
			else
				freqMap.put(c, 1);
		}

		Comparator<Map.Entry<Character, Integer>> c = new Comparator<Map.Entry<Character, Integer>>() {

			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().compareTo(o2.getValue());
			}
		};

		Set<Character> ss = freqMap.keySet();

		List<Map.Entry<Character, Integer>> l = new ArrayList<>(freqMap.entrySet());
		Collections.sort(l, c);
		Collections.reverse(l);
		// sort the map basis on the value
		System.out.println(l.get(0).getKey());
		return "";
	}

}
