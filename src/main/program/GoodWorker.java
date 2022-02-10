package com.main.soroco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class GoodWorker {
//	Given k sorted arrays of sizes n1, n2, n3... nk, write a program to merge them into one single sorted array of size n1 + n2 + ... + nk.
//	Example: k = 3
//	a1 = [1, 5, 8]
//	a2 = [4, 5, 10, 11]
//	a3 = [2, 3]
//	Output: (n1+n2) + (n1+n2+n3) + ()
	// n(n1)+(n-1)n2
//	arr = [1, 2, 3, 4, 5, 5, 8, 10, 11]
	// min arNum
	// 1 1 2
	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<>();
		lists.add(Arrays.asList(1, 5, 8));
		lists.add(Arrays.asList(4, 5, 10, 11));
		lists.add(Arrays.asList(2, 5));
		System.out.println(merge(lists));
	}

	public static List<Integer> merge(List<List<Integer>> lists) {
		if (null == lists || lists.isEmpty())
			return null;

		List<Integer> ans = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Stack<Integer>> map1 = new HashMap<>();
		SortedSet<ArrNumValueLoc> tree = new TreeSet<>();
		for (int i = 0; i < lists.size(); i++) {
			map.put(i, 0);
			if (lists.get(i) == null)
				lists.add(i, new ArrayList<>());
			if (!lists.get(i).isEmpty())
				tree.add(new ArrNumValueLoc(i, lists.get(i).get(0)));
		}

		while (map.size() > 0) {
			if (!tree.isEmpty()) {
				ArrNumValueLoc obj = (ArrNumValueLoc) tree.first();
				ans.add(obj.value);
				// System.out.print(obj.value + "-");
				int nxtPos = map.get(obj.key) + 1;
				map.put(obj.key, nxtPos);
				tree.remove(obj);
				if (map1.get(obj.value) != null && !map1.get(obj.value).isEmpty()) {
					int pos = map1.get(obj.value).pop();
					tree.add(new ArrNumValueLoc(pos, obj.value));
					nxtPos = map.get(obj.key) - 1;
					map.put(obj.key, nxtPos);
				}
				int len = lists.get(obj.key).size();
				if (len == nxtPos) {
					map.remove(obj.key);
				} else {
					List<Integer> ll = lists.get(obj.key);
					System.out.println(obj.key + " " + nxtPos);
					if (tree.add(new ArrNumValueLoc(obj.key, (Integer) ll.get(nxtPos))) == false) {
						Stack<Integer> pos = map1.get(ll.get(nxtPos));
						if (pos == null) {
							Stack<Integer> stk = new Stack<Integer>();
							stk.push(obj.key);
							map1.put(ll.get(nxtPos), stk);
						} else {
							pos.push(ll.get(obj.key));
						}
					} else {
						tree.add(new ArrNumValueLoc(obj.key, (Integer) ll.get(nxtPos)));
					}
				}
			}
		}

		return ans;
	}

}

class ArrNumValueLoc implements Comparable<ArrNumValueLoc> {

	Integer key, value;

	public ArrNumValueLoc(Integer key, Integer value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public int compareTo(ArrNumValueLoc o) {
		return this.value.compareTo(o.value);
	}

	@Override
	public String toString() {
		return "ArrNumValueLoc [key=" + key + ", value=" + value + "]";
	}

}