package DFS;

import java.util.ArrayList;
import java.util.List;
//reference LC 113
public class LC17 {
    private static final java.lang.String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args){
        LC17 lc17 = new LC17();
        List<String> result = lc17.letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        dfs(digits,new StringBuilder(),0,result);
        return result;

    }

    private void dfs(String digits, StringBuilder combination, int pos, List<String> result) {
        if(pos == digits.length()){
            result.add(combination.toString());
            return;
        }

        //for(int i =pos;i<digits.length();i++){
            String word = KEYS[digits.charAt(pos)-'0'];
            for(int j =0;j<word.length();j++){
                combination.append(word.charAt(j));
                pos++;
                dfs(digits,combination,pos,result);
                pos--;
                combination.deleteCharAt(pos);
            }
       // }

    }
}
