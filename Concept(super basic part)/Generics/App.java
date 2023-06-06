package kr.ac.sejong.db.java_test.Generics;
import kr.ac.sejong.db.java_test.oop.circle.Circle2;
import kr.ac.sejong.db.java_test.inheritance.Sphere;
public class App {

	public static void main(String[] args) {
//		세개 다 데이터 타입만 다름
//		StringPrinter p = new StringPrinter("Hello World");
//		p.print();
//		
//		IntegerPrinter p2 = new IntegerPrinter(3);
//		p2.print();
		
		//IntegerPrinter implements Printer (interface)
		Printer p6 = new IntegerPrinter(4);
		p6.print();
//		
//		CirclePrinter p3 = new CirclePrinter(new Circle2(2,2,4));
//		p3.print();
		
		GeneralPrinter<String> p = new GeneralPrinter<String>("Hello World");
		p.print();
		
		GeneralPrinter<Integer> p2 = new GeneralPrinter<Integer>(3);
		p2.print();
		
		GeneralPrinter<Circle2> p3 = new GeneralPrinter<Circle2>(new Circle2(2,2,4));
		p3.print();
		
		GeneralPrinter<Sphere> p4 = new GeneralPrinter<Sphere>(new Sphere(2,2,2,8));
		p4.print();
		
		Printer p5 = new SpherePrinter(new Sphere(2,2,2,8));
		p5.print();
	}

}
