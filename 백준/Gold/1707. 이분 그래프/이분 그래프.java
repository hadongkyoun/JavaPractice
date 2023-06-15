import java.io.*;
import java.util.*;

public class Main {

	static int flag;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//테스트 케이스 횟수
		int K = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] adj;
		boolean[] visited;
		int[] union;

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());	//정점 수
			//인접리스트 활성화
			adj = new ArrayList[V+1];
			for(int v=1; v<=V; v++)
				adj[v] = new ArrayList<Integer>();
			visited = new boolean[V+1];
			union = new int[V+1];

			int E = Integer.parseInt(st.nextToken());	//간선 수
			for(int j=0; j<E; j++){
				st = new StringTokenizer(br.readLine());

				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				//무방향 그래프
				adj[u].add(v);
				adj[v].add(u);
			}

			//이분 그래프 테스트 시작
			flag = 0;
			for(int v=1; v<=V; v++){
				if(!visited[v]){
					DFS(v,  adj, visited, union, 1);
				}
			}

			if (flag == 1)
				bw.write("NO\n");
			else   
				bw.write("YES\n");
		
		}
		bw.flush();
		bw.close();
	}


	static void DFS(int now,  ArrayList<Integer>[] adj, boolean[] visited, int[] union, int sign){
		//방문 한 노드면 종료
		if(visited[now]){
			if(union[now] == sign*-1)
				flag = 1;
			return;
		}
		visited[now] = true;
		union[now] = sign;
		for(int i=0; i<adj[now].size(); i++){
				DFS(adj[now].get(i), adj, visited, union, sign*-1);
		}

	}


}
