package DFS;

import java.util.ArrayList;
import java.util.List;

public class LC39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(candidates,target,curr,0,result);
        return result;
    }

    private void dfs(int[] candidates, int target,List<Integer>curr,int pos,List<List<Integer>> result) {
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(target<0){
            return;
        }
        for(int i =pos;i<candidates.length;i++){
            curr.add(candidates[i]);
            target-=candidates[i];
            dfs(candidates,target,curr,i,result);
            curr.remove(curr.size()-1);
            target+=candidates[i];
        }

    }
}
