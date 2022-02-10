package com.main.soroco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.event.RowSorterListener;

import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Aclte {
//	9,3,7,7,5,9,9,2
//	o/p
//	9,9,9,7,7,3,5,2
//
//	9-3
//	7-2
//	3-1
//	5-1
//	2-1
	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 9, 3, 7, 7, 5, 7, 7, 9, 9, 2 };
		sortList(Arrays.asList(arr));
	}

	public static void sortList(List<Integer> list) {
		// Collections.reverse(list);
		Map<Integer, Integer> freqMap = new LinkedHashMap<>();
		for (Integer integer : list) {
			if (freqMap.containsKey(integer))
				freqMap.put(integer, freqMap.get(integer) + 1);
			else
				freqMap.put(integer, 1);
		}
		Comparator<Map.Entry<Integer, Integer>> cp = new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}

		};

		Set<Map.Entry<Integer, Integer>> set = freqMap.entrySet();
		List<Map.Entry<Integer, Integer>> l = new ArrayList<>(set);
		Collections.sort(l, cp);
		// Collections.reverse(l);
		for (Entry<Integer, Integer> entry : l) {
			// System.out.println(entry.getKey() + " - " + entry.getValue());
		}

		//freqMap.entrySet().stream().sorted((e, f) -> f.getValue().compareTo(e.getValue())).forEach(System.out::println);
	}

}
