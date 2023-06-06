package kr.ac.sejong.db.java_test.inheritance;
import kr.ac.sejong.db.java_test.oop.circle.*;

public class App {

	public static void main(String[] args) {
		// 업캐스팅
		Sphere s = new Sphere(3, 4, 5, 6);
		Circle2 c = s;
		System.out.println(c.getArea());

		// 다운캐스팅 (원래 안됨)
		// Circle c2 = new Circle(3, 4, 5);
		// Sphere s2 = (Sphere) c2;
		// 오류 : System.out.println(s2.getVoluime());

		// 업캐스팅 -> 다운캐스팅
		if (c instanceof Sphere) {
			
			Sphere s2 = (Sphere) c;
			System.out.println(s2.getVoluime());
		}
		Circle2 c2 = new Circle2(3,4,5);
		if(c2 instanceof Sphere) {
			Sphere s2 = (Sphere) c2;
			System.out.println(s2.getVoluime());
		}
	}

}
