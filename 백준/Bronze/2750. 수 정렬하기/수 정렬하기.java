import java.util.*;

public class Main{
	
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		//버블 정렬
		int N = scanner.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++){
			arr[i] = scanner.nextInt();
		}

		for(int i=0; i<N; i++){
			for(int j=0; j<N-1; j++){
				if(arr[j] > arr[j+1]){
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}

		for(int i=0; i<N; i++)
			System.out.println(arr[i]);
	}
}
