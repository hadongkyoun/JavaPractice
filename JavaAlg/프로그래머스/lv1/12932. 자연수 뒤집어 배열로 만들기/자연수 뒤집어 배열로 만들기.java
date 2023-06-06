class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        String str = Long.toString(n);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        str = sb.toString();
        char[] arr = str.toCharArray();
        answer = new int[arr.length];
        for(int i=0; i<answer.length; i++)
            answer[i] = arr[i] -'0';
        
        return answer;
    }
}