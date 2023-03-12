package kr.ac.sejong.db.java_test.oop.circle;

public class Circle2 {
	private int x;
	private int y;
	private int r;
	
	public Circle2(int x, int y, int r) {
		super();
		this.x = x;
		this.y = y;
		this.r = r;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getR() {
		return r;
	}


	public void setR(int r) {
		this.r = r;
	}
	
	public double getArea() {
		return 3.14 *r*r;
	}
	@Override
	public String toString() {
		return "(" + x + "," + y + ")-" +r;
				
	}
	
}
