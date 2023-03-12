package kr.ac.sejong.db.java_test.Generics;

public class GeneralPrinter<E> {
	private E data;
	
	public GeneralPrinter(E data) {
		this.data = data;
	}
	public void print() {
		System.out.println(data);
	}
}
