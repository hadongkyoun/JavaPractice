import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pQue = new PriorityQueue<Integer>();
		for(int i=0; i<N; i++){
			pQue.add(Integer.parseInt(br.readLine()));
		}

		int cnt = 0;
		int number = 0;
		int result = 0;
		while(!pQue.isEmpty()){
			number += pQue.poll();
			cnt++;
			if(cnt == 2){	//숫자가 두 개 나온 순간
				pQue.add(number);
				result += number;
				cnt = 0;
				number = 0;
			}
		}

		System.out.print(result);
	}
}
