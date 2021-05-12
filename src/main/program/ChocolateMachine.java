package main.program;
import java.util.Scanner;

public class ChocolateMachine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfMachines = sc.nextInt();
		int t = sc.nextInt();
		int m[] = new int[numOfMachines];
		long h = 0;
		long ans = 0;
		for (int i = 0; i < m.length; i++) {
			m[i] = sc.nextInt();
			h = Math.max(h, m[i]);
		}
		h = h * t;  //0.....35
		long l = 0;
		long mid = 0;
		long noOfChocs = 0;
		while (l <= h) {
			mid = (l + h) / 2;
			noOfChocs = func(mid, m, t);
			if (noOfChocs >= t) {
				ans = mid;
				h = mid - 1;
			} else if (noOfChocs < t) {
				l = mid + 1;
			}
		}
		System.out.println(ans);
	}

	static long func(long mid, int m[], int t) {
		long numOfChocs = 0;
		for (int i = 0; i < m.length; i++) {
			numOfChocs += mid / m[i];
			if (numOfChocs > t) {
				return numOfChocs;
			}
		}
		return numOfChocs;
	}
}
