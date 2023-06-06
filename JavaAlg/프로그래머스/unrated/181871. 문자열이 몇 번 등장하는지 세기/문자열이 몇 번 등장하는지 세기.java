class Solution {
    public int solution(String myString, String pat) {
        int answer = 0, start = 0, len = 0;
        
        for(int i=0; i<=myString.length() - pat.length(); i++){
            
            if(myString.substring(i, i+pat.length()).compareTo(pat) == 0)
                answer++;
            
        }
        
        return answer;
    }
}