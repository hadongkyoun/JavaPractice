class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        double[] avgScore = new double[score.length];
        int row = 0,col = 0, sum = 0, st;
        double myAvg;
        for(int i=0, j = 0; i<score.length * 2; i++){
            row = i / 2;
            col = i % 2;
            if(col == 0)
                sum = 0;
            
            sum += score[row][col];
            
            if(col == 1){
                avgScore[j] = sum/2.0;
                j++;
            }
        }
        
        for(int i=0; i < avgScore.length; i++){
            st = 1;
            myAvg = avgScore[i];
            for(int j = 0; j<avgScore.length; j++){
                if(myAvg < avgScore[j])
                    st++;
            }
            answer[i] = st;
        }
        
        
        return answer;
    }
}