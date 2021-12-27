package main.program;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SchedulingClasses {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int days = sc.nextInt();
		Map<Integer, Map<Integer, int[]>> dayToSubjects = new LinkedHashMap<>();
		for (int i = 0; i < days; i++) {
			int subjects = sc.nextInt();
			Map<Integer, int[]> timeMap = new TreeMap<>();
			for (int j = 0; j < subjects; j++) {
				String subjectName = sc.next();
				String startTime = sc.next().replace(":", "");
				String endTime = sc.next().replace(":", "");
				// To sort the timings on the base of start time + end time (16:00 + 18:00 will
				// be converted to 16001800 as the unique key of the tree map) and value will be
				// array of start time(1600) and end time(1800)
				int key = Integer.valueOf(startTime + endTime);
				int sT = Integer.valueOf(startTime);
				int eT = Integer.valueOf(endTime);
				timeMap.put(key, new int[] { sT, eT });
			}
			dayToSubjects.put(i + 1, timeMap);
		}
		getMaxSubCount(dayToSubjects);
	}

	// TC O(n^2) and SC O(n)
	public static void getMaxSubCount(Map<Integer, Map<Integer, int[]>> dayToSubjects) {
		for (int key : dayToSubjects.keySet()) {
			Map<Integer, int[]> timing = dayToSubjects.get(key);
			List<Integer> time = new ArrayList<>(timing.keySet());
			int max = 0;
			// check max count from starting time of every class
			for (int i = 0; i < time.size(); i++) {
				int endTime = 0;
				int count = 0;
				for (int j = i; j <= time.size() - 1; j++) {
					int startTime = timing.get(time.get(j))[0];
					int endTiming = timing.get(time.get(j))[1];
					if (startTime <= endTiming) {
						if (startTime == endTiming) {
							count++;
							// System.out.println(startTime +"--"+endTiming);
						} else if (endTime <= startTime) {
							count++;
							endTime = timing.get(time.get(j))[1];
							// System.out.println(startTime +"--"+endTiming);
						}
					}
				}
				// System.out.println("---");
				if (count > max) {
					max = count;
				}
			}
			System.out.println(max);
		}
	}

}
