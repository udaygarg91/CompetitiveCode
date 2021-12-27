package main.program;
import java.util.Scanner;

public class CodeChef {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int k = sc.nextInt();
			int outputProblem = n / a + n / b - 2 * n /(a * b / getLcm(a, b));
			if (outputProblem >= k) {
				System.out.println("Win");
			} else {
				System.out.println("Lose");
			}
			t--;
		}
	}

	private static int getGcm(int a, int b) {
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		if (min == 0)
			return max;
		while (max % min != 0) {
			int tmp = max;
			max = min;
			min = tmp % min;
		}
		return min;
	}

	private static int getLcm(int a, int b) {
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		if (max == 0 || min == 0) {
			return max;
		}
		return (a * b) / getGcm(a, b);
	}
}
