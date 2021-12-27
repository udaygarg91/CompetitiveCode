package main.program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Lecture implements Comparable<Lecture> {
	String name;
	String startTime;
	String endTime;

	Lecture() {

	}

	Lecture(String name, String startTime, String endTime) {
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getSubject() {
		return name;
	}

	public void setSubject(String name) {
		this.name = name;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public int compareTo(Lecture o) {

		return this.endTime.compareTo(o.endTime);
	}

	@Override
	public String toString() {
		return "Lecture [subject=" + name + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
}

public class ScheduleLecture {

	static int getTotalSubCount(List<Lecture> list) {
		String eT = null;
		int count = 0;
		int max = 0;
		for (Lecture lecture : list) {
			if (count == 0) {
				count++;
				eT = lecture.getEndTime();
				max++;
//				System.out.println(lecture.getStartTime()+ "-- "+eT);
			} else {
				if (lecture.getStartTime().compareTo(eT) >= 0) {
					eT = lecture.getEndTime();
					max++;
//					System.out.println(lecture.getStartTime()+ "-- "+eT);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int days = Integer.parseInt(reader.readLine());
		for (int i = 0; i < days; i++) {
			int totalClass = Integer.parseInt(reader.readLine());
			List<Lecture> input = new ArrayList<>();
			for (int k = 0; k < totalClass; k++) {
				Lecture Lecture = null;
				String lecAndTiming = reader.readLine();
				String[] lecAndTimes = lecAndTiming.split(" ");
				if(lecAndTimes[1].split(":")[0].length()==1) {
					lecAndTimes[1] = 0+lecAndTimes[1];
				}
				if(lecAndTimes[2].split(":")[0].length()==1) {
					lecAndTimes[2] = 0+lecAndTimes[2];
				}
				Lecture = new Lecture(lecAndTimes[0], lecAndTimes[1], lecAndTimes[2]);
				input.add(Lecture);
			}
			Collections.sort(input);
			System.out.println(getTotalSubCount(input));
		}
	}
}
