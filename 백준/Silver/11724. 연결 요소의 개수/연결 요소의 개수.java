
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class DFSgraph{
	private ArrayList<Integer> []nodeList;
	private boolean[] visited;
	DFSgraph(int node){
		nodeList = new ArrayList[node+1];
		for(int i=1; i<=node; i++)
			nodeList[i] = new ArrayList<Integer>();
		visited = new boolean[node+1];
	}

	void setEdge(int nodeNumber1, int nodeNumber2){
		nodeList[nodeNumber1].add(nodeNumber2);
		nodeList[nodeNumber2].add(nodeNumber1);
	}

	int visitAllnode(){
		int count = 0;

		for(int i=1; i<nodeList.length; i++){
			if(!visited[i]){
				count++;
				DFS(i);
			}
		}

		return count;
	}

	void DFS(int v){
		if(visited[v])
			return;
		visited[v] = true;
		for(int i : nodeList[v]){
			if(visited[i] == false)
				DFS(i);
		}
	}
}


public class Main{


	public static void main(String args[]) throws IOException {
		//StringBuilder sb = new StringBuilder();

		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int nodeNums = Integer.parseInt(st.nextToken());
		int edgeNums = Integer.parseInt(st.nextToken());
		
		//초기화
		DFSgraph graph = new DFSgraph(nodeNums);
		int n1;
		int n2;
		for(int i = 0; i<edgeNums; i++){
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			graph.setEdge(n1, n2);
		}
		System.out.println(graph.visitAllnode());
	}
}