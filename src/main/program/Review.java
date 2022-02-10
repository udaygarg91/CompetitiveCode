//package com.main.soroco;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
//public class Review {
//
//	public static void main(String[] args) {
//		List l = new ArrayList();
//		l.add("String");
//		List<String> hats = new ArrayList<>();
//		setupHatsData(hats);
//		removeElement(hats, "ABC");
////		System.out.println(hats);
////		printConcatenatedString();
////		printWordForNumber(0);
////		isNull(5);
////		Map<String, String> keyValuePairs = new HashMap<>();
////		keyValuePairs.put("a", "A");
//		Map<String, String> m = new HashMap<>();
//		m.put("a", "a");
//		m.put("b", "a");
//
//		getValueFromMap(m, "aa");
////		getProcessedValue(12);
//	}
//
//	public static void setupHatsData(List<String> hats) {
//		hats.add("ABC");
//		hats.add("DEF");
//		hats.add("GHI");
//		hats.add("ABC");
//	}
//
//	public static void removeElement(List<String> hats, String element) {
//		if (null != element) {
//			Iterator i = hats.iterator();
//			String s = "";
//			while (i.hasNext()) {
//				s = (String) i.next();
//				if (element.equals(s))
//					i.remove();
//				//System.out.println(s);
//			}
//		}
////			for (String hat : hats) {
////				if (hat == "ABC") {
////					hats.remove(hat);
////					return;
////				}
////			}
//		ArrayList<String> aList = new ArrayList<String>();
//		aList.add("Apple");
//		aList.add("Mango");
//		aList.add("Guava");
//		aList.add("Orange");
//		aList.add("Peach");
//		System.out.println("The ArrayList elements are: ");
//		for (String s : aList) {
//			System.out.println(s);
//		}
//		Iterator i = aList.iterator();
//		String str = "";
//		while (i.hasNext()) {
//			str = (String) i.next();
//			if (str.equals("Orange")) {
//				i.remove();
//				System.out.println("\nThe element Orange is removed");
//				break;
//			}
//		}
//		System.out.println("\nThe ArrayList elements are: ");
//		for (String s : aList) {
//			System.out.println(s);
//		}
//	}
//
//	public static void printConcatenatedString(int endIdx) {
//		StringBuilder oneMillionHello = new StringBuilder("");
//		int loopLen = endIdx / 6;
//		for (int i = 0; i < loopLen + 1; i++) {
//			oneMillionHello.append("Hello!");
//		}
//		System.out.println(oneMillionHello.substring(0, 6));
//	}
//
//	public static void printWordForNumber(int caseIndex) {
//
//		switch (caseIndex) {
//		case 0:
//			System.out.println("Zero");
//			break;
//		case 1:
//			System.out.println("One");
//			break;
//		case 2:
//			System.out.println("Two");
//			break;
//		default:
//			System.out.println("Default");
//		}
//	}
//
//	public static boolean isNull(int value) {
//		Integer integer = new Integer(value);
//
//		if (integer == null) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//
//	public static String getValueFromMap(Map<String, String> keyValuePairs, String key) {
//
//		return keyValuePairs.get(key);
//
//	}
//
//	public static String getProcessedValue(Integer value) {
//		if (value >= 10) {
//			return String.valueOf(value);
//		} else {
//			return null;
//		}
//	}
//}
