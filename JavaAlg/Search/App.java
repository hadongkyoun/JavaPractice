package kr.ac.sejong.db.java_test.JavaAlg.Search;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int size, searchIndex;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		size = scanner.nextInt();
		
		int arr[] = new int[size];
		
		//여기 수정
		for(int i=0; i<size; i++) {
			System.out.printf("x[%d] : ", i);
			arr[i] = scanner.nextInt();
		}
		System.out.print("검색할 값 : ");
		searchIndex = scanner.nextInt();
		
		SeqSearch s = new SeqSearch();
		
		s.find(arr, searchIndex);
	
		scanner.close();
	}

}
