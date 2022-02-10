package com.main.soroco;

public class Override1 {
	static {
		System.out.println("O1");
	}

	{
		System.out.println("O11");
	}

	public static void main(String[] args) {
		O2 o = new O2();
	}
}

class O2 extends Override1 {
	static {
		System.out.println("O2");
	}
	
	{
		System.out.println("O22");
	}
}
