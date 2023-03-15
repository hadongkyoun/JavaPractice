package kr.ac.sejong.db.java_test.JavaAlg.Array;

public class App4 {

	public static void main(String[] args) {
		//1~1000까지 소수 찾기
		PrimeNumber p = new PrimeNumber();
		
		for(int i=1; i<=1000; i++) {
			p.findPrime(i);
		}

	}

}
