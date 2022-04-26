package DFS;

import java.util.ArrayList;
import java.util.List;

public class LC46 {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null) return null;
        List<List<Integer>> result = new ArrayList<>();
        boolean[] mark = new boolean[nums.length];
        dfs(nums,nums.length,new ArrayList<Integer>(),0,mark,result);
        return result;

    }

    private void dfs(int[] nums, int length, List<Integer> tmp,int pos,boolean[] mark, List<List<Integer>> result) {
        if(pos == length){
            result.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = 0;i<nums.length;i++) {
            if(mark[i]){
                continue;
            }
            tmp.add(nums[i]);
            mark[i] = true;
            dfs(nums, length, tmp, pos + 1, mark, result);
            tmp.remove(tmp.size() - 1);
            mark[i] = false;
        }



    }
}
