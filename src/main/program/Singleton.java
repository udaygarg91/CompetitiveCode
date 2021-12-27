package main.epam;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {

	final Main m;
	
	public Object readResolve() throws Exception {
		throw new Exception("Deserialize not suppoerted");
	}

	static Singleton s;

	private Singleton() throws Exception {
		m = null;
		if (s != null)
			throw new Exception("Reflection not supported");
	}

	synchronized static Singleton getInstanse() throws Exception {
		if (s == null) {
			s = new Singleton();
		}
		return s;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return Singleton.s;
	}
}
