package kr.ac.sejong.db.java_test.interfaces;

public class HelloThread extends Thread{
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Hello World");
		}
	}
}
