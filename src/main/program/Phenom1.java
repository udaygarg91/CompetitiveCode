package com.main.soroco;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Phenom1 {
	public static void main(String[] args) {
//		>$10000 —> print “Good”
//		$5000 to $10000 —> print “OK”
//		<$5000 —> print “Bad”
//		Example: 
//		IBM... $4000
//		Oracle: $8000
//		TCS... $1000
//		Result: "Good"

		// price>0

		Map<String, Float> stkPriceMap = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		Float sum = 0f;
		// boolean addPriceStatus = true;
		while (true) {
			int i = 1;
			if (i == 1) {
				System.out.println("Enter stock price");
				try {
					String stockName = sc.next().trim().toLowerCase();
					Float price = sc.nextFloat();
					if (stkPriceMap.containsKey(stockName)) {
						Float existingPrice = stkPriceMap.get(stockName);
						sum = sum - existingPrice;
						stkPriceMap.put(stockName, price);
					} else {
						stkPriceMap.put(stockName, price);
					}
					sum = sum + price;
				} catch (Exception e) {
					System.err.print("Price must be a number");
					e.printStackTrace();
				}
			}
			System.out.println("Do you want to add more prices: Enter 1");
			System.out.println("To show the result: Enter 0");
			i = sc.nextInt();
			if (i == 0)
				showResult(sum);
		}

	}

	public static void showResult(Float stockPriceSum) {
		if (stockPriceSum >= 10000) {
			System.out.println("GOOD");
		} else if (stockPriceSum < 5000) {
			System.out.println("BAD");
		} else {
			System.out.println("OK");
		}
	}
	
	public static void addPrice(Float stockPriceSum) {
		
	}
}
