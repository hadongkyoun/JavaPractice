package kr.ac.sejong.db.java_test.JavaAlg.Array;

import java.util.Scanner;

public class App3 {

	static boolean SameArray(int []a, int []b) {
		//���̰� �ٸ��ٸ�
		if(a.length != b.length)
			return false;
		
		for(int i=0; i<a.length; i++) {
			//���� ���� ���
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
		System.out.print("�迭 a�� ������: ");
		aSize = scanner.nextInt();
		System.out.print("�迭 b�� ������: ");
		bSize = scanner.nextInt();
		
		int []a = new int[aSize];
		int []b = new int[bSize];
		
		System.out.printf("�迭 a(size:%d) �Է�: ", aSize);
		insertArray(scanner, a);
		System.out.printf("�迭 b(size:%d) �Է�: ", bSize);
		insertArray(scanner, b);
		
		System.out.println("�� �迭�� ����...." + SameArray(a,b));
		
		
	}

}
