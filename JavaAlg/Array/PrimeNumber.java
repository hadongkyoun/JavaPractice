package kr.ac.sejong.db.java_test.JavaAlg.Array;

public class PrimeNumber {
	void findPrime(int data) {
		int stack = 0;
		for(int i=1; i<=data; i++) {
			if(data%i == 0)
				stack++;
			if(stack > 2)
				return;
		}
		if(stack == 2)
			System.out.println(data);
	}
}
