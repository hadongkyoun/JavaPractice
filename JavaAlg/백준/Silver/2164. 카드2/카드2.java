import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		//큐 생성
		Queue<Integer> que = new LinkedList<>();

		int N = scanner.nextInt();

		scanner.close();

		//큐 삽입
		for(int i=0; i<N; i++){
			que.add(i+1);
		}
		
		//카드가 한장 남을때 까지 반복
		while(que.size() != 1){
			que.remove();
			int back = que.poll();
			que.add(back);
		}

		System.out.println(que.peek());
	}
}
