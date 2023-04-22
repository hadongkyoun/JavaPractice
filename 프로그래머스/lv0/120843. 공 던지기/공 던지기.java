class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        for(int i=0, ball_index = 0; i<k; i++, ball_index+=2){
            answer = numbers[ball_index%numbers.length];
        }    
    
        return answer;
    }
}