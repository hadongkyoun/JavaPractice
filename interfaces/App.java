package kr.ac.sejong.db.java_test.interfaces;

public class App {

	public static void main(String[] args) {
		//new HelloThread().start();
		//new Thread(new HelloRunnable()).start();
		
//		익명
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				while(true) {
//					System.out.println("Hello Runnable");
//				}
//			}
//		}).start();
		
// 		람다식 (구현해야할 함수가 한개 인 경우 가능)
		new Thread(()-> System.out.println("Hello Runnable")).start();
	}

}
