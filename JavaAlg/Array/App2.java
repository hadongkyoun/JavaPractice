package kr.ac.sejong.db.java_test.JavaAlg.Array;

public class App2 {

	public static void main(String[] args) {
		int []array = new int[] {1,2,3,4,5,6,7};
		ReverseOrder R = new ReverseOrder();
		R.Reverse(array);
		for(int i = 0; i < 7; i++) {
			System.out.print(array[i]+", ");
		}
	}

}
