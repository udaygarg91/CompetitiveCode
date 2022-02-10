package com.main.soroco;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Akqa {

	String name;
	int sal;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Akqa(String name, int sal) {
		this.name = name;
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Akqa [name=" + name + ", sal=" + sal + "]";
	}

	public static void main(String[] args) {
		List<Akqa> list = new ArrayList<>();
		list.add(new Akqa("C", 1));
		list.add(new Akqa("A", 1));
		list.add(new Akqa("B", 1));
		list.stream().sorted(Comparator.comparing(Akqa::getName).reversed()).forEach(System.out::print);
	}
}
