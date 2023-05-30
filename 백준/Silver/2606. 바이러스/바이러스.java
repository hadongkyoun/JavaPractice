import java.io.*;
import java.util.*;


public class Main {
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
        //입력 및 정의
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        ArrayList<Integer>[] adjList = new ArrayList[N+1];
        boolean[] visited = new boolean[N+1];

        for(int i=1; i <=N; i++)
            adjList[i] = new ArrayList<Integer>();

        int M = input.nextInt();
        for(int i=0; i<M; i++){
            int v1 = input.nextInt();
            int v2 = input.nextInt();
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }
        DFS(1, adjList, visited);
        System.out.println(cnt);

        input.close();
    }
    static void DFS(int start, ArrayList<Integer>[] adjList, boolean[] visited){
        if(visited[start])
            return;
        visited[start] = true;
        for(int i : adjList[start]){
            if(!visited[i]){
                cnt++;
                DFS(i, adjList, visited);
            }
        }
    }
    /*
    static int BFS(int startV, ArrayList<Integer>[] adjList, boolean[] visited){
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(startV);
        visited[startV] = true;
        int cnt = 0;
        while(!que.isEmpty()){
            int c_v = que.poll();
            for(int i : adjList[c_v]){
                if(!visited[i]){
                    cnt++;
                    visited[i] = true;
                    que.add(i);
                }
            }
        }
        return cnt;
    }*/
}
