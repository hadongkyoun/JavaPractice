import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int cnt;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];

		for(int i=0; i<N; i++){
			String data = br.readLine();
			for(int j=0; j<N; j++){
				int value = Integer.parseInt(data.substring(j,j+1));
				map[i][j] = value;
			}
		}

		PriorityQueue<Integer> pQue = new PriorityQueue<Integer>();
		int  number = 0; //1단지
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(!visited[i][j] && map[i][j] != 0){
					cnt = 1;
					number++;
					DFS(i,j, map, visited);
					pQue.add(cnt);
				}
			}
		}
		System.out.println(number);
		while(!pQue.isEmpty())
			System.out.println(pQue.poll());
	}
	static void DFS(int i, int j, int[][] map, boolean[][] visited){
		if(visited[i][j])
			return;
		visited[i][j] = true;
		//상하좌우
		for(int k=0; k<4; k++){
			int move_i = i + dx[k];
			int move_j = j + dy[k];
			if(move_i>=0 && move_j>=0 && move_i < map.length && move_j < map.length && map[move_i][move_j] != 0 && !visited[move_i][move_j]){
				cnt++;
				DFS(move_i, move_j, map, visited);
			}
		}
	}
}
