package main.program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SceneLength {

	public static List<Integer> getLengthOfEachScene(char[] sceneSquence) {
		Map<Character, int[]> charFirstLastPostion = new HashMap<>();
		for (int i = 0; i < sceneSquence.length; i++) {
			char c = sceneSquence[i];
			if (charFirstLastPostion.get(c) != null) {
				charFirstLastPostion.get(c)[1] = i + 1;
			} else {
				charFirstLastPostion.put(c, new int[] { i + 1, i + 1 });
			}
		}

		List<Integer> ans = new ArrayList<>();
		int low = 0, high = 0;
		for (char c : charFirstLastPostion.keySet()) {
			int firstPos = charFirstLastPostion.get(c)[0];
			int lastPos = charFirstLastPostion.get(c)[1];
			if (firstPos > high) {
				if (high > 0)
					ans.add(high - low + 1);
				low = firstPos;
				high = lastPos;
			} else if (lastPos > high) {
				high = lastPos;
			}
			System.out.print(c + " : ");
			System.out.print(charFirstLastPostion.get(c)[0] + " - ");
			System.out.println(charFirstLastPostion.get(c)[1]);
		}
		ans.add(high - low + 1);
		return ans;
	}

	public static void main(String[] args) {
		char[] arr = new char[] { 'a', 'b', 'a', 'b', 'c', 'b', 'a', 'c', 'a', 'd', 'e', 'f', 'e', 'g', 'd', 'e', 'h',
				'i', 'j', 'h', 'k', 'l', 'i', 'j' };
		
		System.out.println(getLengthOfEachScene(arr));
	}

}
