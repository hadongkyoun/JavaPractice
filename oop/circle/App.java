package kr.ac.sejong.db.java_test.oop.circle;

public class App {

	public static void main(String[] args) {
		Circle c1 = new Circle(3,4,5);
		System.out.println(c1.getArea());
		
		Circle2 c2 = new Circle2(4,4,2);
		System.out.println(c2.getArea());
		
		c2.setR(3);
		System.out.println(c2.getArea());
		

	}

}
