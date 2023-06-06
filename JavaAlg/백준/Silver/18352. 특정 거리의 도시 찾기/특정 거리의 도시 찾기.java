import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); //도시의 개수 N
		int M = Integer.parseInt(st.nextToken()); //도로의 개수 M
		int K = Integer.parseInt(st.nextToken());	//거리 정보 K
		int X = Integer.parseInt(st.nextToken()); //출발 도시의 번호 X

		//~~~~~~~~~~~~~~~~~ 그래프 형성 ~~~~~~~~~~~~~~~~~//

		//도시 형성
		ArrayList<Integer>[] node = new ArrayList[N+1];
		
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

		boolean[] visited = new boolean[N+1];	//노드 방문 유무
		int[] range = new int[N+1];						//출발 노드로부터의 거리

		BFS(X, node, visited, range);
		boolean exist = false;
		for(int i=1; i<=N; i++){
			if(range[i] == K){
				System.out.println(i);
				exist = true;
			}
		}
		if(!exist)
			System.out.print(-1);
	}
	static void BFS(int X, ArrayList<Integer>[] node, boolean[] visited, int[] range){
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(X);
		visited[X] = true;

		while(!que.isEmpty()){
			int now = que.poll();
			for(int i=0; i<node[now].size(); i++){
				if(!visited[node[now].get(i)]){
					que.add(node[now].get(i));
					visited[node[now].get(i)] = true;
					range[node[now].get(i)] = range[now] + 1; // 가중치 1
				}
			}

		}
	}
}
