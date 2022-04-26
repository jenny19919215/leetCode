package BFS;






import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class LC1091 {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length ==0) return -1;
        int rows=grid.length;
        int cols = grid[0].length;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(0,0));
        int level =1;
        int[][] dir =new int[][]{{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pair element = queue.poll();
                int row = (int) element.getKey();
                int col = (int) element.getValue();
                if(row ==rows-1 && col ==cols-1){
                    return level;
                }
                grid[row][col] =1;
                for(int j=0;j<dir.length;j++){
                    int[] delta = dir[j];
                    int newRow = row+delta[0];
                    int newCol = col+delta[1];
                    if(newRow <0 || newRow>=rows || newCol<0|| newCol >=cols){
                        continue;
                    }
                    if(grid[newRow][newCol] == 0){
                        grid[newRow][newCol]=1;
                        queue.offer(new Pair<>(newRow,newCol));
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args){
        int[][] grid = new int[][]{{0,0,0},{1,0,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
