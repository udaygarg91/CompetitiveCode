package main.program;
import java.util.Scanner;
import java.util.TreeMap;

public class ColorfulField {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt(), t = sc.nextInt();

		TreeMap<Integer, Integer> inputs = new TreeMap<>();
		while (k > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			//putting waste cell value as -1
			inputs.put((x - 1) * m + y, -1); //(x - 1) * m + y is cell number
			k--;
		}
		
		int[] tIn = new int[t];
		int i = 0;
		while (t > i) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			//to print output as per given inputs sequence afterwards
			tIn[i++] = (x - 1) * m + y;
			//putting default value 0 for fruit cells
			if (inputs.get((x - 1) * m + y) == null)
				inputs.put((x - 1) * m + y, 0);
		}
		
		//preMax waaste count
		int wasteCount = 0;
		for (Integer key : inputs.keySet()) {
			if (inputs.get(key) == -1) {
				wasteCount++;
			} else {
				//updating preMax waste count for fruit cells
				inputs.replace(key, wasteCount);
			}
		}

		//Printing output by remainder 3
		//1 for Carrots 2 Kiwis for 3 for Grapes
		for (int j = 0; j < tIn.length; j++) {
			if (inputs.get(tIn[j]) == -1) {
				System.out.println("Waste");
			} else {
				int fruitNum = (tIn[j] - inputs.get(tIn[j])) % 3;
				if (fruitNum == 1)
					System.out.println("Carrots");
				else if (fruitNum == 2)
					System.out.println("Kiwis");
				else
					System.out.println("Grapes");
			}
		}
	}
}
