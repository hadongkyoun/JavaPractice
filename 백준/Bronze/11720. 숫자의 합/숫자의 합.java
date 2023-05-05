import java.util.Scanner;

public class Main{

	public static void main(String args[]){
		/* 좋지 않은 문제 숫자의 갯수 N이 두번째줄에 입력받은 숫자의 갯수와 다르게 할 경우
			 문제에서 딱히 이부분 예외처리가 안됨. */
		Scanner input = new Scanner(System.in);

		//숫자의 갯수 N
		int N = input.nextInt();
		String data = input.next();

		char[] nums = data.toCharArray();
		int sum = 0;
		for(int i=0; i < nums.length; i++){
			sum += nums[i] -'0';
		}

		System.out.println(sum);
		input.close();
	}
}