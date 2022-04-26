package DFS;

class DFS2 {
    //https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/58wowd/ dfs + 回溯剪枝法
    public boolean exist(char[][] board, String word) {
        for(int m =0;m<board.length;m++){
            for(int n=0;n<board[0].length;n++){
                if(dfs(board,m,n,0,word)){
                    return true;
                }
            }
        }

        return false;

    }

    private boolean dfs(char[][] board, int m, int n, int k,String word) {
        if(m<0|| m>=board.length || n >= board[0].length|| n<0|| board[m][n] != word.charAt(k)) return false;
        if(k == word.length()-1) return true;
        board[m][n] = '\0';
        boolean result = dfs(board,m+1,n,k+1,word) ||dfs(board,m-1,n,k+1,word)||dfs(board,m,n+1,k+1,word)
                ||dfs(board,m,n-1,k+1,word);
        board[m][n] = word.charAt(k);
        return result;
    }

};