import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] arr = new int[N];
		int[] sum = new int[N+1];
		for(int i=0; i<N; i++){
			arr[i] = scanner.nextInt();
		}

		for(int i=0; i<N-1; i++){
			int j=i+1;
			int save = arr[j];
			while(j>0 && arr[j-1] > save){
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = save;
		}

		for(int i=1; i<=N; i++){
			sum[i] += sum[i-1] + arr[i-1];
		}
		int result = 0;
		for(int i=1; i<=N; i++){
			result+= sum[i];
		}
		System.out.print(result);

	}
}
