package kr.ac.sejong.db.java_test.JavaAlg.Array;

public class MaxOfArrayRand {
	
	private int []a;
	
	
	public MaxOfArrayRand(int size) {
		a = new int[size];	
	}
	
	void setArray(int index, int data) {
		a[index] = data;
	}
	
	int getArraySize() {
		return a.length;
	}
	
	void getArray() {
		for(int i=0; i<a.length; i++)
			System.out.print(a[i]+", ");
		System.out.println();
	}
	int foundMax() {
		int max = a[0];
		for(int i=1; i<a.length; i++) {
			if(max < a[i])
				max = a[i];
		}
		
		return max;
	}
	
	
}
