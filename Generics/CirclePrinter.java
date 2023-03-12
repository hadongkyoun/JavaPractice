package kr.ac.sejong.db.java_test.Generics;
import kr.ac.sejong.db.java_test.oop.circle.Circle2;


public class CirclePrinter {
	private Circle2 data;
	
	public CirclePrinter(Circle2 data) {
		this.data = data;
	}
	
	public void print() {
		System.out.println(data);
	}
}
