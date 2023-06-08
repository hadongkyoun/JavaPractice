import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] adj = new ArrayList[N+1];
		boolean[] visited = new boolean[N+1];
		int[] distance = new int[N+1];
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		for(int i=1; i<=N; i++){
			adj[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			//단방향 그래프
			adj[v1].add(v2);
		}

		ArrayList<Integer> answer = new ArrayList<Integer>();
		BFS(X, K, adj, visited, distance, answer);
		
		Collections.sort(answer);
		if(answer.size() == 0)
			bw.write("-1");
		for(int i=0; i<answer.size(); i++)
			bw.write(answer.get(i) + "\n");
			
		bw.flush();
		bw.close();
	}
	static void BFS(int X, int K, ArrayList<Integer>[] adj, boolean[] visited, int[] distance,  ArrayList<Integer> answer){
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(X);
		visited[X] = true;
		while(!que.isEmpty()){
			int current_V = que.poll();
			for(int i=0; i<adj[current_V].size(); i++){
				int adjVertex = adj[current_V].get(i);
				if(!visited[adjVertex]){
					que.add(adjVertex);
					visited[adjVertex] = true;
					
					distance[adjVertex] = distance[current_V] + 1;

					if(distance[adjVertex] == K)
						answer.add(adjVertex);
				}

			}

		}
	}
}
