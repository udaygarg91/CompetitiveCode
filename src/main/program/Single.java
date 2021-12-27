package main.epam;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class Student implements Serializable {
	static int i = 5;
}

public class Single {

	static int i = 5;

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//		String s1 = "abc";
//		String s2 = "def";
//		String s3 = new String("abc");
//		System.out.println(s1.hashCode());
//		System.out.println(s2.hashCode());
//		System.out.println(s3.hashCode());
//		System.out.println(s1 == s3.intern());
//		
//		Student s = new Student();
//		Student.i = 10;
//		
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abc.acr"));
//		oos.writeObject(s);
//		oos.flush();
//		oos.close();
//		ObjectInputStream obj = new ObjectInputStream(new FileInputStream("abc.acr"));
//		Student test = (Student) obj.readObject();
//		obj.close();
//		System.out.println(test.i);

		String s = " 1, 2, 3, 4, 5, 1, 2, 3";
		
		Set<String> set = new HashSet<>(Arrays.asList(s.split(",")));
		s = String.join(",", set);
		System.out.println(s);
		
		List<Integer> l = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3));
//		for (Integer integer : l) {
//			System.out.println(integer);
//			l.remove(1);
//		}
//		
		Iterator<Integer> i = l.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
			i.remove();
		}
	}

}
