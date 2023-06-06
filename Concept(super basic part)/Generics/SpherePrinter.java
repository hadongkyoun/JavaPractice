package kr.ac.sejong.db.java_test.Generics;
import kr.ac.sejong.db.java_test.inheritance.Sphere;
public class SpherePrinter implements Printer {
	private Sphere data;
	public SpherePrinter(Sphere data) {
		this.data = data;
	}

	@Override
	public void print() {
		System.out.println(data);
	}
	
}
