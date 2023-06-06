import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 맵의 크기
		int max = 0;
		int[][] map = new int[N][N];
		boolean[][] visited;

		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > max){
					max = map[i][j];
				}
			}
		}
		int areaMax = 0;
		for (int rain = 0; rain <= max; rain++) {
			int safeArea = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && rain < map[i][j]){		//방문도 안했고, 장마량보다 높은 지역 (안전영역 구하기)
						safeArea++;
						DFS(i,j, map, visited, rain);
					}
				}
			}
			if(areaMax < safeArea)
				areaMax = safeArea;
		}
		System.out.print(areaMax);
		//main 끝
	}
	static void DFS(int i, int j, int[][] map, boolean[][] visited, int rain){
		if(visited[i][j])
			return;
		visited[i][j] = true;
		for(int k=0; k<4; k++){
			int move_i = i + dx[k];
			int move_j = j + dy[k];
			if(move_i>=0 && move_j >= 0 && move_i<map.length && move_j<map.length && !visited[move_i][move_j] && rain < map[move_i][move_j]){
				DFS(move_i, move_j, map, visited, rain);
			}
		}
	}
}
