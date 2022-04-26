package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC279 {
    public static int numSquares(int n) {
        if(n==0) return 1;
        int num = (int) (Math.pow(n,0.5));
        List<Integer> nums = new ArrayList<>();
        for(int i=1;i<num+1;i++){
            nums.add(i*i);
        }
        boolean[] mark = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        mark[n] = true;
        int result =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            result++;
            while(size-->0){
                int currentVal = queue.poll();
                for(int i=0;i<nums.size();i++){
                    int newVal = currentVal-nums.get(i);
                    if(newVal< 0){
                        continue;
                    }
                    if(newVal ==0){
                        return result;
                    }
                    if(newVal>0 && mark[newVal] != true){
                        mark[newVal] = true;
                        queue.offer(newVal);
                    }
                }
            }

        }

        return -1;


    }

    public static void main(String[] args){
        System.out.println(numSquares(13));
    }
}
