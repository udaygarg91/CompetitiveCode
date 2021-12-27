package main.epam;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class ComputerFactory {
	public static void main(String[] args) {
		String input = "hello hello this is is a java java program";

		String[] strArr = input.split(" ");
		Set<String> set = new LinkedHashSet<>(Arrays.asList(strArr));

		input = String.join(" ", set);
		System.out.println(input);
	}
}
