import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //Create Array
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        
        //input data to Array
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
           arr[i] = Integer.parseInt(st.nextToken());           
        }
        //sortArray
        Arrays.sort(arr);
        //find GOOD number
        int isGood, start_i, end_i, cnt = 0;
        for(int i=0; i<N; i++){
            isGood = arr[i];
            start_i = 0;
            end_i = N-1;
            while(start_i < end_i){
            
                if(arr[start_i] + arr[end_i] < isGood){
                    start_i++;                
                }
                else if(arr[start_i] + arr[end_i] > isGood){
                    end_i--;
                }
                else{
					if(start_i != i && end_i != i){
						cnt++;
						break;
					}
					else if(start_i == i){
						start_i++;
					}
					else if(end_i == i){
						end_i--;
					}
                }
            }
        }
    
        System.out.println(cnt);
    
    }
}

