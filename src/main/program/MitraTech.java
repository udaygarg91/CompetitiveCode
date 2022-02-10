package com.main.soroco;

public class MitraTech {
	public static void main(String[] args) {
		System.out.println(MathChallenge("(6*((4/2))+3*1)"));
	}

	public static String MathChallenge(String str) {
		while (str.contains("(")) {
			String s = str.substring(str.lastIndexOf("("), str.indexOf(")", str.lastIndexOf("(")) + 1);
			String s1 = MathChallenge1(s);
			str = str.replace(s, s1);
		}
		str = MathChallenge1(str);
		return str;
	}

	public static String MathChallenge1(String str) {
		// code goes here
		str = str.replace("(", "");
		str = str.replace(")", "");

		while (str.contains("*")) {
			str = getCal(str, "*");
		}
		while (str.contains("/")) {
			str = getCal(str, "/");
		}
		while (str.contains("+")) {
			str = getCal(str, "+");
		}
		while (str.contains("-")) {
			str = getCal(str, "-");
		}
		return str;
	}

	public static String getCal(String str, String sign) {
		StringBuilder sb = new StringBuilder(str);

		while (str.contains(sign)) {
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			int i = sb.lastIndexOf(sign) - 1;
			int j = sb.lastIndexOf(sign) + 1;
			while (i >= 0 && Character.isDigit(sb.charAt(i))) {
				sb1.append("" + sb.charAt(i));
				i--;
			}
			i++;
			sb1 = sb1.reverse();
			while (j < sb.length() && Character.isDigit(sb.charAt(j))) {
				sb2.append("" + sb.charAt(j));
				j++;
			}
			j--;
			int ans = 0;
			if (sign == "*")
				ans = Integer.valueOf(sb1.toString()) * Integer.valueOf(sb2.toString());
			else if (sign == "/")
				ans = Integer.valueOf(sb1.toString()) / Integer.valueOf(sb2.toString());
			else if (sign == "+")
				ans = Integer.valueOf(sb1.toString()) + Integer.valueOf(sb2.toString());
			else
				ans = Integer.valueOf(sb1.toString()) - Integer.valueOf(sb2.toString());
			sb.replace(i, j + 1, ans + "");
			str = sb.toString();
		}
		return str;
	}
}
