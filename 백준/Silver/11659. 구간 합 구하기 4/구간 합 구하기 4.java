import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	/*
		br.readLine() 같이 파일처리 등 입출력 관련된 코드를 사용할땐
	 	IOException 예외처리를 해줘야 한다.
	*/
	 public static  void main(String[] args) throws IOException{

		//M이 100,000개 하면 그 안에서 System.out.println을 100,000개 불러야 하기 때문에
		StringBuilder sb = new StringBuilder();


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//수의 갯수
		int N = Integer.parseInt(st.nextToken());
		//합을 구해야 하는 횟수
		int M = Integer.parseInt(st.nextToken());

		/*
			배열입력
			int[] arr = new int[N];
		*/

		//구간 합 배열 (인덱스 1부터 시작)
		int[] S = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i <= N; i++){
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());
		}

		//구간 합 출력
		int left_th, right_th;
		for(int i=0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			left_th = Integer.parseInt(st.nextToken());
			right_th = Integer.parseInt(st.nextToken());

			sb.append(S[right_th] - S[left_th-1] + "\n");

		}
		
		System.out.println(sb);
	}
}