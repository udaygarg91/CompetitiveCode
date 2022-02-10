package com.main.soroco;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.LongAdder;

public class Jio {

	public static void main(String[] args) {
		solution("...xxxx..x....xxxx.", 12);
	}

	public static int solution(String S, int B) {

		PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
		p.add(1);
		p.add(3);
		p.add(3);
		p.add(2);
		System.out.println(p.poll());
		System.out.println(p.poll());
		System.out.println(p.poll());
		System.out.println(p.poll());
		System.out.println(p.poll());
		
		SortedMap<Integer, LongAdder> m = new TreeMap<>(Collections.reverseOrder());

		int cnt = 0;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == 'x') {
				cnt++;
			} else if (cnt > 0) {
				m.computeIfAbsent(cnt, e -> new LongAdder()).increment();
				cnt = 0;
			}
		}
		if (cnt != 0) {
			m.computeIfAbsent(cnt, e -> new LongAdder()).increment();
		}

		int ans = 0;
		while (m.size() > 0 && B > 1) {
			Integer v = m.firstKey();
			if (m.get(v).intValue() == 1)
				m.remove(v);
			else
				m.get(v).decrement();
			if (v > B) {
				ans = ans + B - 1;
				B = 0;
				v = v - B - 1;
			} else if (v < B) {
				B = B - (v + 1);
				ans = ans + v;
				v = 0;
			} else {
				B = 0;
				ans = ans + v - 1;
				v = 1;
			}

		}
		//System.out.println(ans);
		return ans;
	}
}

class KV implements Comparable {
	Integer k, v;

	public KV(Integer k, Integer v) {
		this.k = k;
		this.v = v;
	}

	@Override
	public int compareTo(Object o) {
		KV v = (KV) o;
		return v.v.compareTo(this.v);
	}

	@Override
	public String toString() {
		return "KV [k=" + k + ", v=" + v + "]";
	}

}
