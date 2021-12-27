package main.program;

public class Person implements Comparable<Person> {
	Integer classId;
	String name;
	String screenClass;

	public Person(int classId, String name, String screenClass) {
		this.classId = classId;
		this.name = name;
		this.screenClass = screenClass;
	}

	@Override
	public int compareTo(Person o) {
		if (o.classId <= classId) {
			return 1;
		}
		return -1;
	}

	@Override
	public String toString() {
		return "Person [id=" + classId + ", name=" + name + ", screenClass=" + screenClass + "]";
	}

}
