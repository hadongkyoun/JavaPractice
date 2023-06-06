import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] nums = new int[N];

		for(int i=0; i<N; i++){
			nums[i] = i+1;
		}

		int start_index = 1, end_index = 1, cnt = 1, sum = 1;
		
		while(end_index < N){
		//두 포인터의 합이 N보다 작을때
		if(sum < N){
			//합의 크기를 늘려 줘야 한다.
			sum += ++end_index;
		}
		else{
			if(sum == N)
				cnt++;
			//합의 크기를 줄여야 한다
			sum -= start_index++;
		}
	}
		System.out.println(cnt);
	}
}
