package kr.ac.sejong.db.java_test.JavaAlg.Search;

import java.util.Scanner;


public class BinarySearchApp {

	static int find(int []arr, int n, int data) {
		int pl = 0, pr = n-1, pc;
		
		
		
		while(pl <= pr) {
			
			pc = (pl + pr)/2;
			
			if(arr[pc] == data)
				return pc;
			//찾고자 하는 값이 중앙값보다 크다
			else if(arr[pc] < data)
				pl = pc +1;
			//찾고자 하는 값이 중앙값보다 작다
			else
				pr = pc - 1;
			
		}
		return -1;
		
	}
	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int size = scanner.nextInt();
		int arr[] = new int[size];
		
		System.out.println("오름차순으로 입력하세요.");
		
		for(int i=0; i<size; i++) {
			System.out.printf("x[%d] : ", i);
			arr[i] = scanner.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int searchData = scanner.nextInt();
		
		int result =find(arr, size, searchData);
		
		if(result == -1)
			System.out.printf("찾고자 하는 값이 없습니다.");
		else
			System.out.printf("%d은(는) x[%d]에 있습니다.", searchData, result);
	
		scanner.close();
	}
}
