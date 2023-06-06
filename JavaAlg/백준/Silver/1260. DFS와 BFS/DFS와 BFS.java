import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int start_v = Integer.parseInt(st.nextToken()); //시작 정점 번호

		ArrayList<Integer>[] graph = new ArrayList[N+1];
		//정점
		for(int i=1; i<=N; i++){
			graph[i] = new ArrayList<Integer>();
		}
		//간선
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			graph[n1].add(n2);
			graph[n2].add(n1);
		}

		//인접리스트 오름차순 정렬
		for(int i=1; i<=N; i++){
			Collections.sort(graph[i]);
		}
		//DFS
		boolean[] visited = new boolean[N+1];
		
		DFS(start_v, graph, visited, sb);
		sb.append("\n");

		//BFS
		visited = new boolean[N+1];

		BFS(start_v, graph, visited, sb);
		
		System.out.print(sb);
	}
	static void DFS(int v, ArrayList<Integer>[] graph, boolean[] visited, StringBuilder sb){
		if(visited[v])
			return;
		visited[v] = true;
		sb.append(v + " ");
		//재귀
		for(int i=0; i<graph[v].size(); i++){
			DFS(graph[v].get(i), graph, visited, sb);
		}
	}

	static void BFS(int v, ArrayList<Integer>[] graph, boolean[] visited, StringBuilder sb){

		Queue<Integer> queue = new LinkedList<Integer>();
		visited[v] = true;
		//넣고시작
		queue.add(v);
		sb.append(v + " ");
		//재귀 X, 큐 (2중 w,f문)
		while(!queue.isEmpty()){
			int nowNode = queue.poll();
			for(int i=0; i<graph[nowNode].size(); i++){
				int data = graph[nowNode].get(i);
				if(!visited[data]){
					visited[data] = true;
					queue.add(data);
					sb.append(data + " ");
				}
			}
		}

	}
}