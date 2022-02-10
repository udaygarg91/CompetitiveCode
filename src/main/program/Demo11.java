package com.main.soroco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo11 {
	public static void main(String[] args) {
		int arr[] = new int[] { 3, 3, 3, 3, 5, 5, 5, 2, 2, 7 };
		int halfLen = arr.length / 2;
		if (arr.length % 2 == 1)
			halfLen++;

		Map<Integer, Integer> fMap = new HashMap<>();

		for (Integer i : arr) {
			if (fMap.containsKey(i))
				fMap.put(i, fMap.get(i) + 1);
			else
				fMap.put(i, 1);
		}

		List<Integer> values = new ArrayList<>(fMap.values());
		System.out.println(values.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst());
		Collections.sort(values);

		System.out.println(values);
		int l = 0, r = values.size() - 1;
		int c = 0;
		int sum = values.get(r);
		while (l <= r) {
			sum = sum + values.get(r - 1);
			if (sum >= halfLen) {
				c++;
				break;
			} else {
				r--;
			}
		}
		if (c != 0)
			c++;
		System.out.println(c);
	}
}
