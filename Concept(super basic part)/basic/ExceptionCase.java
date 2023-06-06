package kr.ac.sejong.db.java_test.basic;

import java.util.Scanner;

public class ExceptionCase {

	public static void main(String[] args) {
		int x = 10;
		Scanner scanner = new Scanner(System.in);
		int y = scanner.nextInt();
		
		// Exception Handling
		try {
			System.out.println(x/y);
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println("Do not give me zero");
		}
		
		/*
		 	중대한, 중요한 작업들
			---------------------
		 */
		
		scanner.close();
	} 

}
