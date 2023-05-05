import java.util.Scanner;

public class Main{

	public static void main(String args[]){
		StringBuilder sb = new StringBuilder();

		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt(), M = input.nextInt();
		int[] nums = new int[N];
		int[] sums = new int[N];
		
		for(int i=0; i<N; i++){
			nums[i] = input.nextInt();
			if(i == 0)
				sums[0] = nums[0];
			else
				sums[i] = sums[i-1] + nums[i]; 
		}

		int left;
		int right;
		for(int i=0; i<M; i++){
			left = input.nextInt();
			right = input.nextInt();
			if(left == 1)
				sb.append(sums[right-1] + "\n");
			else
				sb.append(sums[right-1] - sums[left-2] + "\n");
		}
		System.out.println(sb);
		input.close();
	}
}