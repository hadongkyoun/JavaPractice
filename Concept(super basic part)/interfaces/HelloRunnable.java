package kr.ac.sejong.db.java_test.interfaces;

public class HelloRunnable implements Runnable {
	@Override
	public void run() {
		while(true) {
			System.out.println("Hello Runnable");
		}
	}
}
