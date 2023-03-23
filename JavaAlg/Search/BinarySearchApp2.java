package kr.ac.sejong.db.java_test.JavaAlg.Search;

import java.util.Scanner;

public class BinarySearchApp2 {

	static void printArray(int []a, int n) {
		System.out.print("{");
		for(int i = 0; i < n; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println("}");
	}
	
	static int searchIdx(int []a, int n, int key, int []idx) {
		int cnt = 0;
		
		for(int i = 0, j = 0; i<n; i++) {
			if(a[i] == key) {
				idx[j] = i;
				j++;
				cnt++;
			}
		}
		
		return cnt;
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("요소갯수를 입력: ");
		int size = scanner.nextInt();
		int []arr = new int[size];
		int []idx = new int[size];
		System.out.println("------각 요소를 입력------");
		for(int i=0; i<size; i++) {
			System.out.printf("arr[%d]: ", i);
			arr[i] = scanner.nextInt();
		}
		
		System.out.print("찾을 키 갑");
		int k = scanner.nextInt();
		int result = searchIdx(arr, size, k, idx);
		
		System.out.print("배열 arr: ");
		printArray(arr, size);
		System.out.print("배열 idx: ");
		printArray(idx, result);
		
		System.out.println("일치 하는 요소 갯수" + result);
		scanner.close();

	}

}
