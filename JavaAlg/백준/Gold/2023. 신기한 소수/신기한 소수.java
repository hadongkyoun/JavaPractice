import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		int[] start = {2,3,5,7};
		//int[] next = {1,3,5,7,9};
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i<start.length; i++){
			DFS(start[i], arr, N);

		}
		
		for(int i=0; i<arr.size(); i++)
			bw.write(arr.get(i) + "\n");

		bw.flush();
		bw.close();
	}
	static void DFS(int val, ArrayList<Integer> arr, int N){
		if(checkVal(val, N)){
			arr.add(val);
			return;
		}
		//짝수면 어처피 소수가 아니기 때문
		int[] middle = {1,3,5,7,9};
		for(int i=0; i<middle.length; i++){
			int box = val*10 + middle[i];
			if(isPrime(box)){
				DFS(box, arr, N);
			}
		}
	}
	static boolean isPrime(int val){
		for(int i=2; i<=val/2; i++){
			if(val%i == 0)
				return false;
		}
		return true;
	}
	static boolean checkVal(int val, int N){
		int cnt = 0;
		while(val != 0){
			val = val/10;
			cnt++;
		}
		if(cnt == N)
			return true;
		else
			return false;
	}
}
