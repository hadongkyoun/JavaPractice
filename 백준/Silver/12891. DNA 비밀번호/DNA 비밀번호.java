import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		//DNA 문자열 길이
		int DNA_len = scanner.nextInt();
		//부분 문자열 길이
		int sub_len = scanner.nextInt();

		String DNA = scanner.next();
		
		//부분 문자열에 포함돼야 할 A,C,G,T의 최소 개수( 배열 )		
		int[] min = new int[4];
		for(int i=0; i<4; i++)
			min[i] = scanner.nextInt();
		//체크배열
		int[] check = new int[4];

		//결과값
		int result = 0;

		//슬라이딩 윈도우
		for(int i=0, j=0; i<DNA_len; i++){

			//슬라이딩 윈도우에 문자 추가
			switch(DNA.charAt(i)){
				case 'A':
					check[0]++;
					break;
				case 'C':
					check[1]++;
					break;
				case 'G':
					check[2]++;
					break;
				case 'T':
					check[3]++;
					break;
				default:
					break;
			}

			//부분 문자열 check
			if(i >= sub_len-1){
				int cnt = 0;

				//check배열과 min 조건이 같은지
				for(int k=0; k<4; k++){
					if(min[k] <= check[k])
						cnt++;
				}

				//요구조건 만족시
				if(cnt == 4)
					result++;

				//슬라이딩 윈도우에 문자가 빠질때
				switch(DNA.charAt(j)){
						case 'A':
							check[0]--;
							break;
						case 'C':
							check[1]--;
							break;
						case 'G':
							check[2]--;
							break;
						case 'T':
							check[3]--;
							break;
						default:
							break;
				}

				//부분 문자열의 길이를 지키기 위해
				j++;
				//for문에서 i++
			}
		}

		System.out.println(result);
	}	
}
