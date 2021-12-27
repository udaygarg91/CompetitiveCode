package main.epam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {

	public static void main(String[] args) throws Exception {

		Thread t1 = new Thread(() -> {
			try {
				System.out.println(Singleton.getInstanse().hashCode());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				System.out.println(Singleton.getInstanse().hashCode());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

//		t1.start();
//		t2.start();

		Singleton s = Singleton.getInstanse();
		Singleton s1 = (Singleton) s.clone();

		//System.out.println(s.hashCode());
		System.out.println(s1.hashCode());

//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abc.acr"));
//		oos.writeObject(s);
//		oos.flush();
//		oos.close();
//		ObjectInputStream obj = new ObjectInputStream(new FileInputStream("abc.acr"));
//		Singleton test = (Singleton) obj.readObject();
//		obj.close();

		//System.out.println(test.hashCode());

		Class cc = s1.getClass();
		Constructor []arr = cc.getDeclaredConstructors();
		arr[0].setAccessible(true);
		Singleton p = (Singleton) arr[0].newInstance();
		System.out.println(p.hashCode());
	}
}
