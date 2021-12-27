//https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

package main.program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class FirstNegativeIntEveryWindowSizeK {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			long a[] = new long[(int) (n)];
			// long getAnswer[] = new long[(int)(n)];
			String inputLine[] = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				a[i] = Long.parseLong(inputLine[i]);
			}
			int k = Integer.parseInt(br.readLine().trim());

			Compute obj = new Compute();
			long answer[] = obj.printFirstNegativeInteger(a, n, k);
			int sz = answer.length;

			StringBuilder output = new StringBuilder();
			for (int i = 0; i < sz; i++)
				output.append(answer[i] + " ");
			System.out.println(output);
		}
	}
}

class Compute {

	public long[] printFirstNegativeInteger(long A[], int N, int K) {

		long[] ans = new long[N - K + 1];
		int count = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < K; i++) {
			if (A[i] < 0)
				dq.addLast(i);
		}
		// System.out.println(A[dq.peekFirst()]);
		if (!dq.isEmpty())
			ans[count++] = A[dq.peekFirst()];
		else
			ans[count++] = 0;
		for (int i = K; i < N; i++) {
			if (!dq.isEmpty() && dq.peekFirst() == i - K) {
				dq.pollFirst();
			}
			if (A[i] < 0) {
				dq.addLast(i);
			}
			if (!dq.isEmpty())
				ans[count++] = A[dq.peekFirst()];
			else
				ans[count++] = 0;
			// System.out.println(A[dq.peekFirst()]);
		}
		return ans;

	}

}

// } Driver Code Ends

//User function Template for Java
