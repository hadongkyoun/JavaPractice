import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수

		ArrayList<Integer>[] nodeList = new ArrayList[N];

		//인접리스트 생성
		for(int i=0; i<N; i++)
			nodeList[i] = new ArrayList<Integer>();
		//방문 배열
		boolean[] visited = new boolean[N];

		for(int i=0; i<E; i++){
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			nodeList[n1].add(n2);
			nodeList[n2].add(n1);
		}
		boolean[] exist = new boolean[1];
	
		for(int i=0; i<N; i++){
			DFS(i, nodeList, visited, 0, exist);
			if(exist[0])
				break;
		}

		if(exist[0])
			System.out.print(1);
		else
			System.out.print(0);
	}

	static void DFS(int v, ArrayList<Integer>[] nodeList, boolean[] visited, int cnt, boolean[] exist){
		if(cnt == 4){
			exist[0] = true;
			return;
		}
		visited[v] = true;
		for(int i=0; i<nodeList[v].size(); i++){
			if(visited[nodeList[v].get(i)] == false)
				DFS(nodeList[v].get(i), nodeList, visited, cnt+1, exist);
		}
		visited[v] = false;
	}
}
