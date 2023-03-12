package kr.ac.sejong.db.java_test.inheritance;
import kr.ac.sejong.db.java_test.oop.circle.*;

public class Sphere extends Circle2 {
	private int z;

	public Sphere(int x, int y, int z, int r) {
		super(x, y, r);
		this.z = z;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	public double getVoluime() {
		return getR() * getR() * getR();
	}
	@Override
	public String toString() {
		return "("+getX()+","+getY()+","+getZ()+")-" + getR();
	}
}
