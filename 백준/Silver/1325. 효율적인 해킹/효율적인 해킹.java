import java.io.*;
import java.util.*;

//BFS


public class Main{
	static int N, M;
	static boolean visited[];
	static int infected[];
	static ArrayList<Integer>[] node;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); //컴퓨터 개수 N
		M = Integer.parseInt(st.nextToken()); //신뢰 관계 M

		//~~~~~~~~~~~~~~~~~ 그래프 형성 ~~~~~~~~~~~~~~~~~//

		
		node = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++){
			node[i] = new ArrayList<Integer>();
		}

		//도로 형성
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			node[start].add(end);
		}

		//~~~~~~~~~~~~~~~~~ 그래프 형성 ~~~~~~~~~~~~~~~~~//

		infected = new int[N+1];
		int max = 0;

		for(int i=1; i<=N; i++){
			//BFS는 visited를 이런식으로 초기화 해줘야 한다.
			visited = new boolean[N+1];
			BFS(i);
		}


		for(int i=1; i<=N; i++){
			max = Math.max(max, infected[i]);
		}
		for(int i=1; i<=N; i++){
			if(max == infected[i]){
				bw.write(i+" ");
			}
		}
		bw.flush();
		bw.close();
	}
	static void BFS(int v){
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(v);
		visited[v] = true;
		while (!que.isEmpty()) {
			int now = que.poll();
			for (int i : node[now]){
				if(!visited[i]){
					visited[i] = true;
					que.add(i);
					//추가 될 수록 정점 v 가 감염시키는 컴퓨터 증가
					infected[i]++;
				}
			}

		}
	}
}

