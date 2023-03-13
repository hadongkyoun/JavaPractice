package kr.ac.sejong.db.java_test.JavaAlg.Array;
import java.util.Random;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		System.out.print("배열 크기: ");
		int n = scanner.nextInt();
		
		MaxOfArrayRand array = new MaxOfArrayRand(n);
		for(int i=0; i<array.getArraySize(); i++) {
			array.setArray(i, rand.nextInt());
		}
		array.getArray();
		System.out.println(array.foundMax());
		
		scanner.close();
	}

}
