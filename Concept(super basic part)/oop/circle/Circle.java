package kr.ac.sejong.db.java_test.oop.circle;

public class Circle {

	// 데이터 추상화
	private int x;
	private int y;
	private int r;
	
	//프로시저 추상화
	//생성자
	
	public Circle(){
		
	}
	
	public Circle(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	// get
	public int getX() {
		return x;
	}
	// set
	public void setX(int x) {
		this.x = x;
	}
	
	double getArea() {
		return 3.14 * r * r;
	}
}
