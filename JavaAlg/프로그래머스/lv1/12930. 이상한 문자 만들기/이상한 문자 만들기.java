import java.util.*;
import java.io.*;


class Solution {
    
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int blank = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            //c가 알파벳인 경우
            if(Character.isAlphabetic(c)){
                if((i-blank)%2 == 0)
                    c = Character.toUpperCase(c);
                else
                    c = Character.toLowerCase(c);
            }
            else{
                blank = i+1;
            }
            sb.append(c);
        }
        answer = sb.toString();  
            
        return answer;
    }
}