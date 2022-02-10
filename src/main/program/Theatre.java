package com.main.soroco;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

	int blockACount = 0;
	int blockBCount = 0;

	public Theatre(int noOfSeatsInEachBlock) {
		this.blockACount = noOfSeatsInEachBlock;
		this.blockBCount = noOfSeatsInEachBlock;
	}

	public BooktingDetails bookTicket(int noOfSeats) {
		if (checkSeatAvailability(noOfSeats) == 0)
			return null;
		BooktingDetails b = null;
		List<Integer> seats = new ArrayList<>();
		if (blockACount >= blockBCount) {
			blockACount = blockACount - noOfSeats;
			while (noOfSeats > 0)
				seats.add(blockACount + noOfSeats--);
			b = new BooktingDetails("BlockA", seats);
		} else {
			blockBCount = blockBCount - noOfSeats;
			while (noOfSeats > 0)
				seats.add(blockBCount + noOfSeats--);
			b = new BooktingDetails("BlockB", seats);
		}
		System.out.println(getSeatNUmber(b.seatNums));
		return b;
	}

	private int checkSeatAvailability(int noOfSeats) {
		if (blockACount < noOfSeats && blockBCount < noOfSeats) {
			return 0;
		}
		return 1;
	}

	public List<String> getSeatNUmber(List<Integer> seats) {
		List<String> seatLoc = new ArrayList<>();
		int c = seats.size();
		int ascOddRow = 97;
		int ascEvenRow = 101;
		int i = 0;
		while (i < c) {
			if ((99 / 5) % 2 == 0) {
				Character s = (char) ascEvenRow;
				seatLoc.add(seats.get(i) + "-" + s);
				ascEvenRow--;
				if (ascEvenRow == 97)
					ascEvenRow = 101;
					
			} else {
				Character s = (char) ascOddRow;
				seatLoc.add(seats.get(i) + "-" + s);
				ascOddRow++;
				if (ascOddRow == 101)
					ascOddRow = 97;
					
			}
			i++;
		}

		return seatLoc;
	}

	public static void main(String[] args) {
		// 100e 99d 98c 97b 96a
		// 91e 92d 93c 94b 95a

		Theatre t = new Theatre(100);
		System.out.println(t.bookTicket(5));
		System.out.println(t.bookTicket(4));
		System.out.println(t.bookTicket(2));
	}
}

class BooktingDetails {
	String blockName;
	List<Integer> seatNums;

	public BooktingDetails(String blockName, List<Integer> seatNums) {
		this.blockName = blockName;
		this.seatNums = seatNums;
	}

	@Override
	public String toString() {
		return "BooktingDetails [blockName=" + blockName + ", seatNums=" + seatNums + "]";
	}

}