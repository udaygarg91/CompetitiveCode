package com.main.soroco;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WissenTask {

	List<W> l;
	String name;

	public WissenTask(List<W> l, String name) {
		this.l = l;
		this.name = name;
	}

	public List<W> getL() {
		return l;
	}

	public void setL(List<W> l) {
		this.l = l;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		List<W> ll = new ArrayList<>();
		ll.add(new W("ABC"));
		ll.add(new W("DEF"));
		
		WissenTask wt = new WissenTask(ll , "WA");
		WissenTask wt1 = new WissenTask(ll , "WA");
		List<WissenTask > l = new ArrayList<>();
		l.add(wt1);
		l.add(wt);
		List<WissenTaskDto > ld = l.stream().map(e -> new WissenTaskDto(e.getL())).collect(Collectors.toList());
		
		for (WissenTaskDto w : ld) {
			System.out.println(w.getLl().size());
		}
		
		
	}
}

class WissenTaskDto {

	List<W> ll;

	public WissenTaskDto(List<W> ll) {
		this.ll = ll;

	}

	public List<W> getLl() {
		return ll;
	}

	public void setLl(List<W> ll) {
		this.ll = ll;
	}

}

class W {
	String name;

	public W(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}