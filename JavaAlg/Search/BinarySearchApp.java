package kr.ac.sejong.db.java_test.JavaAlg.Search;

import java.util.Scanner;


public class BinarySearchApp {

	static int find(int []arr, int n, int data) {
		int pl = 0, pr = n-1, pc;
		
		
		
		while(pl <= pr) {
			
			pc = (pl + pr)/2;
			
			if(arr[pc] == data)
				return pc;
			//ã���� �ϴ� ���� �߾Ӱ����� ũ��
			else if(arr[pc] < data)
				pl = pc +1;
			//ã���� �ϴ� ���� �߾Ӱ����� �۴�
			else
				pr = pc - 1;
			
		}
		return -1;
		
	}
	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("��ڼ� : ");
		int size = scanner.nextInt();
		int arr[] = new int[size];
		
		System.out.println("������������ �Է��ϼ���.");
		
		for(int i=0; i<size; i++) {
			System.out.printf("x[%d] : ", i);
			arr[i] = scanner.nextInt();
		}
		
		System.out.print("�˻��� �� : ");
		int searchData = scanner.nextInt();
		
		int result =find(arr, size, searchData);
		
		if(result == -1)
			System.out.printf("ã���� �ϴ� ���� �����ϴ�.");
		else
			System.out.printf("%d��(��) x[%d]�� �ֽ��ϴ�.", searchData, result);
	
		scanner.close();
	}
}
