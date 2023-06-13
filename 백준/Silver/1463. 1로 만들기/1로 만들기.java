import java.io.*;
import java.util.*;

public class Main {
	
	static int minCnt = Integer.MAX_VALUE;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int X = input.nextInt();
		DFS(X, 0);
		System.out.print(minCnt);

	}
	static void DFS(int X, int cnt){
		if(cnt > minCnt)
			return;
		if(X==1){
			if(minCnt > cnt)
				minCnt = cnt;
			return;
		}

		if (X % 3 == 0)
			DFS(X / 3, cnt + 1);
		if (X % 2 == 0)
			DFS(X / 2, cnt + 1);

		DFS(X - 1, cnt + 1);

	}
}
