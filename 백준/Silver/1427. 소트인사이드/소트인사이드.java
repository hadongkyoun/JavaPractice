
import java.util.*;

public class Main{

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String n = scanner.next();
		int[] nums = new int[n.length()];

		for (int i = 0; i < n.length(); i++) {
			nums[i] = Integer.parseInt(n.substring(i, i + 1));
		}

		// 삽입정렬
		for (int i = 0; i < nums.length; i++) {

			// 최댓값 가정
			int maxPos = i;
			for (int j = i+1; j < nums.length; j++) {
				if(nums[maxPos] < nums[j]){
					maxPos = j;
				}
			}

			if(maxPos != i){
				int tmp = nums[i];
				nums[i] = nums[maxPos];
				nums[maxPos] = tmp;
			}

		}

		for(int i=0; i<nums.length; i++)
			System.out.print(nums[i]);


	}
	
}
