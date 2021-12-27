package main.program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SAPTask {

	static Integer c = 0;
	public static List<Integer> getTheGroups(int n, List<String> queryType, List<Integer> students1,
			List<Integer> students2) {
		// Write your code here
		List<Integer> ans = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= n; i++) {

			adj.add(new ArrayList<Integer>());

		}
		for (int i = 0; i < queryType.size(); i++) {
			if (queryType.get(i).equalsIgnoreCase("Friend")) {
				adj.get(students1.get(i)).add(students2.get(i));
				adj.get(students2.get(i)).add(students1.get(i));
			}
			if (queryType.get(i).equalsIgnoreCase("Total")) {
				dfs(students1.get(i), adj, new int[n + 1]);
				dfs(students2.get(i), adj, new int[n + 1]);
				ans.add(c);
				c = 0;
			}

		}
		
		ans.add(c);
		System.out.println(c);
		return ans;
	}

	public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
		if (visited[node] == 1) {
			return;
		}
		visited[node] = 1;
		c++;
		for (int i = 0; i < adj.get(node).size(); i++) {
			dfs(adj.get(node).get(i), adj, visited);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		int queryTypeCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> queryType = IntStream.range(0, queryTypeCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(Collectors.toList());

		int students1Count = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> students1 = IntStream.range(0, students1Count).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());

		int students2Count = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> students2 = IntStream.range(0, students2Count).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());

		List<Integer> result = SAPTask.getTheGroups(n, queryType, students1, students2);

//		bufferedWriter.write(result.stream().map(Object::toString).collect(Collectors.joining("\n")) + "\n");
//
//		bufferedReader.close();
//		bufferedWriter.close();
	}
}