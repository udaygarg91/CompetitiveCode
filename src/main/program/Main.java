package main.program;
public class Main {
	public static void main(String[] args) {
		Person[] arr = new Person[] { new Person(2, "ba", "GoldA"),
				new Person(3, "ca", "SilverA"),
				new Person(1, "aa", "PlatinumB"), 
				new Person(3, "cb", "SilverB"),
				new Person(3, "cc", "SilverC"),
				new Person(2, "bb", "GoldB"),
				new Person(1, "ab", "PlatinumA"),
				new Person(1, "ac", "PlatinumC"),
				new Person(2, "bc", "GoldC") };

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j + 1].classId < arr[j].classId) { // 1(a) 1(b) 1(c) 1(d)
					Person tmp = arr[j + 1];				//1b 1c 1d 1a 
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		for (Person person : arr) {
			System.out.println(person);
		}
	}

}
