import java.util.*;

public class Main {
	
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int N, K;

		N = scanner.nextInt(); // 동전 수
		K = scanner.nextInt(); // 목표 금액

		int[] coinPrice = new int[N];
		//오름 차순으로 주어짐
		for(int i=0; i<N; i++){
			coinPrice[i] = scanner.nextInt();
		}
		int cnt = 0;	//코인 개수
		int i = N-1;
		while(K != 0){
			//K보다 작은 제일 큰 가격을 가진 동전
			if(K >= coinPrice[i]){
				cnt += K/coinPrice[i];
				K = K%coinPrice[i];
			}
			i--;
		}

		//필요한 동전 개수의 최솟값
		System.out.print(cnt);


	}
}
