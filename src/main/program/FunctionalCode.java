package main.epam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class FunctionalCode {
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>(Arrays.asList(11, 2, 3, 4, 5));
		int sum = 0;
		for (Integer integer : list) {
			sum = sum + integer * integer;
		}
		System.out.println(sum);
		sum = list.stream().reduce(0, (x, y) -> x + y * y);
		System.out.println(sum);

		sum = list.stream().map(x -> x * x).reduce(0, (x, y) -> x + y);
		System.out.println(sum);

		sum = list.stream().map(x -> x * x).reduce(0, Integer::sum);
		System.out.println(sum);
		
//		list.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
//		list.stream().distinct().sorted(Comparator.naturalOrder()).forEach(System.out::println);
//		list.stream().distinct().sorted(Comparator.comparing(x -> x.toString().length()).reversed()).forEach(System.out::println);
//		
		System.out.println(list.stream().anyMatch(x -> x>3));
		
	}
}
