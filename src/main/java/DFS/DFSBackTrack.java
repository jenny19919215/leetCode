package DFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
// https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5dfv5h/ and leetcode 46 全排列
public class DFSBackTrack {

    public static void main(String[] args){
        DFSBackTrack dfsBackTrack = new DFSBackTrack();
        String[] array= dfsBackTrack.permutation("abc");
       System.out.println(Arrays.toString(array));

    }

    public String[] permutation(String s) {
        if(s == null) return new String[0];
        int length = s.length();
        boolean[] used = new boolean[length];
        Set<String> res = new HashSet<>();
        StringBuilder path = new StringBuilder();
        dfs(s,length,0,used,res,path);

        return res.stream().toArray(String[]::new);
    }

    private void dfs(String s, int length, int pos, boolean[] used, Set<String> res, StringBuilder path) {
        if(pos == length){
            res.add(path.toString());
            return;
        }
        for(int i=0; i<length;i++){
            if(used[i]){
                continue;
            }
            path.append(s.charAt(i));
            used[i] = true;
            dfs(s,length,pos+1,used,res,path);
            used[i] = false;
            path.deleteCharAt(path.length()-1);
        }
    }
}
