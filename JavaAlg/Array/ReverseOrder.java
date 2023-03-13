package kr.ac.sejong.db.java_test.JavaAlg.Array;

public class ReverseOrder {
	
	public void Reverse(int []a) {
		int tmp;
		for(int i=0; i<a.length/2; i++) {
			tmp = a[a.length-1-i];
			a[a.length-1-i] = a[i];
			a[i] = tmp;
		}
	}
	
}
