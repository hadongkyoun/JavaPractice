package kr.ac.sejong.db.java_test.JavaAlg.Search;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int size, searchIndex;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("��ڼ� : ");
		size = scanner.nextInt();
		
		int arr[] = new int[size];
		
		//���� ����
		for(int i=0; i<size; i++) {
			System.out.printf("x[%d] : ", i);
			arr[i] = scanner.nextInt();
		}
		System.out.print("�˻��� �� : ");
		searchIndex = scanner.nextInt();
		
		SeqSearch s = new SeqSearch();
		
		s.find(arr, searchIndex);
	
		scanner.close();
	}

}
