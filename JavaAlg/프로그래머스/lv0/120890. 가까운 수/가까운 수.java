import java.util.Arrays;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int minSub = 100;//n과 배열의 임의의 정수가 가장 먼 경우
        
        Arrays.sort(array);
        
        for(int i=0; i < array.length; i++){
            if(Math.abs(array[i] - n) < minSub)
                answer = array[i];
                minSub = Math.abs(array[i] - n);
        }
        
        return answer;
    }
}