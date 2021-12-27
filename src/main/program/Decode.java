package main.program;

import java.util.TreeMap;

public class Decode {
	public static void main(String[] args) {
		String s = "czjkk9elaqwiz7s6kgvl4gjixan3ky7jfdg3kyop3husw3fm289thisef8blt7a7zr5v5lhxqpntenvxnmlq7l34ay3jaayikjps";
		int k = 768077956;
		int size = 0;
		String str = "";
		int ssSize = 0;
		int sz = 0;
		TreeMap<Integer, String> map = new TreeMap<>();
		int c = 0, idx = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				map.put(++c, s.substring(idx, i + 1));
				idx = i + 1;

				String ss = map.get(c);
				sz = sz + ss.length() - 1;
				ssSize = Integer.parseInt(ss.charAt(ss.length() - 1) + "");
				size = ssSize * sz;
				sz = size;
				str = str + ss.substring(0, ss.length() - 1);
				if (size >= k) {
					sz = str.length();
					break;
				} else {
					String str2 = str;
					for (int j = 0; j < ssSize - 1; j++)
						str = str + str2;
				}

			}
		}
		if (map.isEmpty()) {
			map.put(1, s + 1);
			sz = s.length();
			str = s;
		}
//		int size = 0;
//		String str = "";
//		int ssSize = 0;
//		int sz = 0;
//		for (int i : map.keySet()) {
//			String ss = map.get(i);
//			sz = sz + ss.length() - 1;
//			ssSize = Integer.parseInt(ss.charAt(ss.length() - 1) + "");
//			size = ssSize * sz;
//			sz = size;
//			str = str + ss.substring(0, ss.length() - 1);
//			if (size >= k) {
//				sz = str.length();
//				break;
//			} else {
//				String str2 = str;
//				for (int j = 0; j < ssSize - 1; j++)
//					str = str + str2;
//			}
//		}
		int mod = (k - 1) % sz;
		System.out.println(str);
		System.out.println(mod);
		System.out.println(str.charAt(mod));
	}

	public int countPairs(int[] deliciousness) {
		int c = 0;
		for (int i = 0; i < deliciousness.length - 1; i++) {
			for (int j = 1; j < deliciousness.length; j++) {
				if (deliciousness[i] != deliciousness[j]) {
					int n = deliciousness[i] + deliciousness[j];
					if (n > 0 && (n & (n - 1)) == 0)
						c++;
				}
			}
		}
		return c;
	}
}
