import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char[] arr = s.toCharArray();   //배열화
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<arr.length; i++){
            //변환    
            if(arr[i] != ' '){
                //알파벳 대문자인 경우
                if(arr[i] >='A' && arr[i] <='Z')
                    if(arr[i] + n > 'Z')
                        arr[i] = (char) ('A'-1 + (arr[i]+n)%'Z');
                    else
                        arr[i] += n;
            
                //알파벳 소문자인 경우
                else{
                    if(arr[i] + n > 'z')
                        arr[i] = (char) ('a'-1+ (arr[i]+n)%'z');
                    else
                        arr[i] += n;
                }
            }
            //끝
            sb.append(arr[i]);
        }
        
        answer = sb.toString();
        
        
        return answer;
    }
}