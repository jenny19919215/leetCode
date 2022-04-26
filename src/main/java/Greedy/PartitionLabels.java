package Greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args){
        String s = "ababcbacadefegdehijhklij";
        PartitionLabels partitionLabels = new PartitionLabels();
        partitionLabels.partitionLabels(s);
    }

    public List<Integer> partitionLabels(String s) {
        if(s == null) return null;
        List<Integer> result = new ArrayList<>();
        int[] letter = new int[26];
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            letter[c-'a'] = i;
        }
        int end =0,start=0;
        for(int i =0;i<s.length();i++){
            char c =s.charAt(i);
            end = Math.max(letter[c-'a'],end);
            if(end == i){
                result.add(end-start+1);
                start = end+1;
            }
        }
        return result;
    }

}
