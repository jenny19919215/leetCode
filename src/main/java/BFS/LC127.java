package BFS;


import java.util.*;

public class LC127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || !wordList.contains(endWord)){
            return 0;
        }
        int len = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()){
            int size= queue.size();
            while (size-- >0){
                String word = queue.poll();
                List<String> temp = new ArrayList<>();
                for(String element: wordList){
                    if(!diffWithOneChar(word,element)){
                        continue;
                    }
                    if(element.equals(endWord)){
                        return len+1;
                    }
                    queue.offer(element);
                    temp.add(element);
                }
                for (String e: temp){
                    wordList.remove(e);
                }
            }
            len++;
        }
        return 0;
    }

    private static boolean diffWithOneChar(String word, String element) {
        if(word == null || element == null){
            return false;
        }
        int a = Integer.valueOf(word);
        if(word.length() != element.length()){
            return false;
        }
        int result = 0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)!=element.charAt(i)){
                result++;
            }
        }
        return result ==1;
    }

    public static void main(String[] args){
        System.out.println(ladderLength("hit","cog", Arrays.asList(new String []{"hot","dot","dog","lot","log","cog"})));

    }

}
