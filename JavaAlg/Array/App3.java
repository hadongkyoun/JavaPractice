package kr.ac.sejong.db.java_test.JavaAlg.Array;

import java.util.Scanner;

public class App3 {

	static boolean SameArray(int []a, int []b) {
		//길이가 다르다면
		if(a.length != b.length)
			return false;
		
		for(int i=0; i<a.length; i++) {
			//같지 않은 경우
			if(a[i] != b[i])
				return false;
		}
		
		return true;
	}
	
	static void insertArray(Scanner scanner, int []a) {
		for(int i=0; i<a.length; i++) {
			a[i] = scanner.nextInt();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int aSize, bSize;
		System.out.print("배열 a의 사이즈: ");
		aSize = scanner.nextInt();
		System.out.print("배열 b의 사이즈: ");
		bSize = scanner.nextInt();
		
		int []a = new int[aSize];
		int []b = new int[bSize];
		
		System.out.printf("배열 a(size:%d) 입력: ", aSize);
		insertArray(scanner, a);
		System.out.printf("배열 b(size:%d) 입력: ", bSize);
		insertArray(scanner, b);
		
		System.out.println("두 배열이 같다...." + SameArray(a,b));
		
		
	}

}
