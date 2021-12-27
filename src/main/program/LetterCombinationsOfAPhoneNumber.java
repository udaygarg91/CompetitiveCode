package main.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args) {
		new LetterCombinationsOfAPhoneNumber().letterCombinations("27");
	}

	public List<String> letterCombinations(String digits) {
		List<String> answer = new ArrayList<>();
		Map<Integer, List<Character>> digitMap = new HashMap<>();
		digitMap.put(2, new ArrayList<>(Arrays.asList('a', 'b', 'c')));
		digitMap.put(3, new ArrayList<>(Arrays.asList('d', 'e', 'f')));
		digitMap.put(4, new ArrayList<>(Arrays.asList('g', 'h', 'i')));
		digitMap.put(5, new ArrayList<>(Arrays.asList('j', 'k', 'l')));
		digitMap.put(6, new ArrayList<>(Arrays.asList('m', 'n', 'o')));
		digitMap.put(7, new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
		digitMap.put(8, new ArrayList<>(Arrays.asList('t', 'u', 'v')));
		digitMap.put(9, new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

		StringBuilder tmp = new StringBuilder();
		getComb(tmp, 0, digits, digitMap, answer);
		System.out.println(answer);
		return answer;
	}

	public void getComb(StringBuilder tmp, int index, String digits, Map<Integer, List<Character>> digitMap, List<String> answer) {
		if (digits.length() == index) {
			answer.add(tmp+"");
			return;
		}

		for (int i = 0; i < digitMap.get(digits.charAt(index) - '0').size(); i++) {
			tmp.append(digitMap.get(digits.charAt(index) - '0').get(i) + "");
			getComb(tmp, index + 1, digits, digitMap, answer);
			tmp.replace(index, index + 1, "");
		}
	}
}
