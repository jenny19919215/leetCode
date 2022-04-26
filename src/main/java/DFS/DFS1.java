package DFS;

import java.util.logging.Logger;

class DFS1 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int a = new DFS1().maxAreaOfIsland(grid);
        int b = 'c';
        Logger.getGlobal().info("result is " + b);
    }

    //https://leetcode-cn.com/problems/max-area-of-island/
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int max = 0;
        for(int m =0;m<grid.length;m++){
            for(int n=0;n<grid[0].length;n++){
                int length = 0;
                max = Math.max(max,dfs(m,n,grid));
            }
        }
        return max;
    }

    private int dfs(int m, int n, int[][] grid) {
        if(m<0|| m>=grid.length || n >= grid[0].length|| n<0|| grid[m][n] != 1) return 0;
        grid[m][n] = 0;
        return dfs(m+1,n,grid) + dfs(m-1,n,grid)
                + dfs(m,n+1,grid) + dfs(m,n-1,grid) +1;


    }
};