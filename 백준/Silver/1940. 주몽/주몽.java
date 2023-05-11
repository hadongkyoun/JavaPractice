import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //재료수
        int N = Integer.parseInt(st.nextToken());
        
        //필요한 두 고유번호의 합
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());   
        }
        Arrays.sort(nums);
        
        int start_i = 0, end_i = N-1, sum = 0, cnt = 0;
        while(start_i != end_i){
            sum = nums[start_i] + nums[end_i];
            
            if(sum >= M){
                if(sum==M)
                    cnt++;
                end_i--;
            }else{
                start_i++;
            }
        }
        
        System.out.println(cnt);
        
	}
}
