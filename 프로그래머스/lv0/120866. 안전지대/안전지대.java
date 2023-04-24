class Solution {
    public int solution(int[][] board) {
        int row,col,answer = 0;
        
        for(int i = 0; i < board.length * board[0].length; i++){
            row = i / board[0].length;
            col = i % board[0].length;
            if(board[row][col] == 1){
                if(row > 0)
                    //맨 위에 붙어 있지 않는 경우에만
                    insertUnsafe(board, row-1, col);
                    
                insertUnsafe(board, row, col);
                
                if(row < board.length-1)
                    //맨 아래에 붙어 있지 않는 경우에만
                    insertUnsafe(board, row+1, col);
            }
        }
        
        for(int i = 0; i < board.length * board[0].length; i++){
            row = i / board[0].length;
            col = i % board[0].length;
            if(board[row][col] == 0){
                answer++;
            }
        }
        
        return answer;
    }
    void insertUnsafe(int[][] board, int row, int col){
        
        if(col > 0 && board[row][col-1] == 0) 
            //맨왼쪽에 붙어있지 않는 경우에만 + 지뢰가 없는 경우만
            board[row][col - 1] = -1;
        
        if(col < board[0].length-1  && board[row][col+1] == 0)
            //맨오른쪽에 붙어있지 않는 경우에만 + 지뢰가 없는 경우만
            board[row][col + 1] = -1;
        
        if(board[row][col] == 0) 
            //지뢰가 위치한 장소가 아니면 -1
            board[row][col] = -1;
    }
}