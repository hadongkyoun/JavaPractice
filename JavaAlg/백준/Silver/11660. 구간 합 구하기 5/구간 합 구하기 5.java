import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int Dsum(int[][] D, int x1, int y1, int x2, int y2){
		return ( D[x2][y2] - D[x2][y1-1] - D[x1-1][y2] + D[x1-1][y1-1]);
	}

	public static void main (String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		//표의 크기
		int N = Integer.parseInt(st.nextToken());
		//합을 구해야 하는 횟수 M
		int M = Integer.parseInt(st.nextToken());

		//구간 합 2차원 배열
		int[][] D = new int[N+1][N+1];

		for(int i=1; i<N+1; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++){
				//구간합에서 배열+1 크기로 선언하면 굉장히 편해짐
					D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			sb.append(Dsum(D, Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),
			Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())) + "\n");
		}
		System.out.println(sb);
	}

}
