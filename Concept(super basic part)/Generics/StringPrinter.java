package kr.ac.sejong.db.java_test.Generics;

public class StringPrinter {
	//생성 당시 데이터를 하나 받아서 (문자열) 출력하는 print 기능을 갖는 것
	private String data;
	
	public StringPrinter(String data) {
		this.data =data;
	}
	public void print() {
		System.out.println(data);
	}
}
