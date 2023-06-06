import java.io.*;
import java.util.*;

public class Main{
	
	 public static  void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int testN = Integer.parseInt(st.nextToken());
		int[] testCase = new int[testN];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<testN; i++){
			testCase[i] = Integer.parseInt(st.nextToken());
		}
		boolean[] exist = new boolean[testN];

		Arrays.sort(arr);
		for(int k=0; k<testN; k++){
			int i=0;
			int j=N-1;
			while(i <= j){
				int mid = (i+j)/2;
				if(arr[(i+j)/2] < testCase[k])
					i = mid + 1;
				else if(arr[(i+j)/2] > testCase[k])
					j = mid - 1;
				else{
					exist[k] = true;
					break;
				}
			}
		}

		for(int k=0; k<testN; k++)
			if(exist[k])
				System.out.println(1);
			else
				System.out.println(0);

	}
}