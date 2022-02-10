package com.main.soroco;

public class Test {
	public static void main(String[] args) {
		Bound<A> bea = new Bound<A>(new A());
		bea.doRunTest();

	}
}

class Bound<T extends B> {

	private T objRef;

	public Bound(T obj) {
		this.objRef = obj;
	}

	public void doRunTest() {
		this.objRef.displayClass();
	}
}

interface B {
	public void displayClass();
}

class A implements B {
	public void displayClass() {
		System.out.println("Inside super class A");
	}
}

class BoundedClass {
//    public static void main(String a[])
//    {
//        //Creating object of sub class A and
//        //passing it to Bound as a type parameter.
//        Bound<A> bea = new Bound<A>(new A());
//        bea.doRunTest();
//         
//    }
}