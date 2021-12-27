package main.program;

import java.util.Scanner;

public class CandidateCodeTechGig {
	boolean prime[];
	int justSmallPrime[];
	int justGreaterPrime[];

	public CandidateCodeTechGig() {
		sieveOfEratosthenes((int) Math.pow(10, 6));
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		CandidateCodeTechGig obj = new CandidateCodeTechGig();
		while (T > 0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int justSmallerPrime = obj.justSmallPrime[r];
			int justBiggerPrime = obj.justGreaterPrime[l];
			if (justBiggerPrime > r)
				System.out.println(-1);
			else
				System.out.println(justSmallerPrime - justBiggerPrime);
		}
	}

	void sieveOfEratosthenes(int n) {
		prime = new boolean[n + 1];
		for (int i = 0; i <= n; i++)
			prime[i] = true;

		for (int p = 2; p * p <= n; p++) {
			if (prime[p] == true) {
				for (int i = p * p; i <= n; i += p)
					prime[i] = false;
			}
		}
		justSmallPrime = new int[n + 1];
		justGreaterPrime = new int[n + 1];
		justSmallPrime[0] = 0;
		justSmallPrime[1] = 1;
		int idx = 0;
		for (int i = 2; i < prime.length; i++) {
			if (prime[i]) {
				idx = i;
			}
			justSmallPrime[i] = idx;
		}
		idx = 0;
		for (int i = prime.length - 1; i > 0; i--) {
			if (prime[i]) {
				idx = i;
			}
			justGreaterPrime[i] = idx;
		}
	}
}
