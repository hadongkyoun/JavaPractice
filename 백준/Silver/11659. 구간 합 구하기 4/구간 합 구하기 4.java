import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String args[]) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());
		
		int[] sums = new int[N];
	
		stringTokenizer = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			if(i == 0)
				sums[0] = Integer.parseInt(stringTokenizer.nextToken());
			else
				sums[i] = sums[i-1] + Integer.parseInt(stringTokenizer.nextToken());
		}


		for(int i=0; i<M; i++){
			stringTokenizer = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(stringTokenizer.nextToken());
			int right = Integer.parseInt(stringTokenizer.nextToken());
			if(left == 1)
				sb.append(sums[right-1] + "\n");
			else
				sb.append(sums[right-1] - sums[left-2] + "\n");
		}

		System.out.println(sb);
	}
}