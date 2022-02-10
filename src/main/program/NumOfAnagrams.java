package com.main.soroco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumOfAnagrams {
	public static void main(String[] args) {
		// Input: strs = ["eat","tea","tan","ate","nat","bat"]
		// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
		String s[] = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
		Map<String, List<String>> fM = new HashMap<>();
		List<List<String>> ans = new ArrayList<>();
		for (String ss: s) {
			String[] c = ss.split("");
			Arrays.sort(c);
			List<String> l = Arrays.asList(c);
			String as = l.toString();
			if(fM.containsKey(as)) {
				fM.get(as).add(ss);
			}
			else {
				List<String> valueList = new ArrayList<>();
				valueList.add(ss);
				fM.put(as, valueList);
			}
		}
		for (String key : fM.keySet()) {
			ans.add(fM.get(key));
		}
		System.out.println(ans);
	}
}
