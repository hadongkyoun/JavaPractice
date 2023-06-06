package kr.ac.sejong.db.java_test.ArrayPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<Integer> arrayList = new LinkedList<Integer>();
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		for(int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
	}

}
