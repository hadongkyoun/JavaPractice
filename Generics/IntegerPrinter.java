package kr.ac.sejong.db.java_test.Generics;

public class IntegerPrinter implements Printer {
	private int data;
	
	public IntegerPrinter(int data) {
		this.data = data;
	}
	
	public void print() {
		System.out.println(data);
	}
}
