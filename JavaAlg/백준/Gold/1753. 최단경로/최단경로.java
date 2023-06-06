import java.io.*;
import java.util.*;

//간선 클래스
class Edge implements Comparable<Edge>{
	int vertex;
	int value; // 가중치
	Edge(int vertex, int value){
		this.vertex = vertex;
		this.value = value;
	}

	@Override
	public int compareTo(Edge target){
		return this.value < target.value ? -1 : 1;
	}
}
public class Main{
	public static ArrayList<Edge>[] list;
	public static boolean[] visited;
	public static int[] distance;
	public static PriorityQueue<Edge> pQue = new PriorityQueue<Edge>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken()); //노드의 갯수
		list = new ArrayList[V+1];
		visited = new boolean[V+1];
		distance = new int[V+1];
		for(int i=1; i<=V; i++){
			list[i] = new ArrayList<Edge>();
			distance[i] = Integer.MAX_VALUE;
		}


		int E = Integer.parseInt(st.nextToken());	//에지의 개수
		st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken()); //출발 노드 번호

		for(int i=0; i<E; i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());	//시작 정점
			int v = Integer.parseInt(st.nextToken());	//도착 정점
			int w = Integer.parseInt(st.nextToken());	//가중치

			list[u].add(new Edge(v,w));
		}

		//최단거리 구하기 다익스트라 구현
		pQue.add(new Edge(K, 0));
		distance[K] = 0;
		while(!pQue.isEmpty()){
			Edge current = pQue.poll();
			int currentV = current.vertex;
			if(visited[currentV])
				continue;
			visited[currentV] = true;
			for(int i=0; i<list[currentV].size(); i++){
				Edge next = list[currentV].get(i);
				if(distance[currentV] + next.value < distance[next.vertex]){
					distance[next.vertex] = distance[currentV] + next.value;
					pQue.add(new Edge(next.vertex, distance[next.vertex]));
				}
			}
		}

		for(int i=1; i<=V; i++){
			if(!visited[i])
				bw.write("INF\n");
			else
				bw.write(distance[i] + "\n");
		}

		bw.flush();
		bw.close();
		


	}
}