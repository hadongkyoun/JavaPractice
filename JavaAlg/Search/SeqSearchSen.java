package kr.ac.sejong.db.java_test.JavaAlg.Search;
import java.util.Scanner;

class SentinelArray{
	static int find(int []arr, int data) {
		int result = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == data) {
				result = i;
				break;
			}
		}
		return result;
	}
	
}

public class SeqSearchSen {
	
	/*** I think this method(Sentinel) is useless ***/

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int size = scanner.nextInt();
		int arr[] = new int[size+1];
		
		for(int i=0; i<size; i++) {
			System.out.printf("x[%d] : ", i);
			arr[i] = scanner.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int searchData = scanner.nextInt();
		arr[size] = searchData;
		
		int res = SentinelArray.find(arr, searchData);
		
		if(res == arr.length)
			System.out.printf("값을 찾지 못했습니다.");
		else
			System.out.printf("값은 X[%d]에 있습니다", res);
		
	
		scanner.close();
	}

}
