import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] numbers = new int[9];
		int max = 0, maxPos = -1;
		//9개 자연수 입력
		for(int i=0; i < numbers.length; i++) {
			//예외처리 생략
			numbers[i] = input.nextInt();
			if(max < numbers[i]) {
				max = numbers[i];
				maxPos = i+1;
			}
		}
		
		System.out.printf("%d%n%d", max,maxPos);
		
		input.close();
		
		
	}

}
