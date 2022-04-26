package DoublePointer;

public class ReverseWords {
    public static void main(String[] args){
       ReverseWords reverseWords = new ReverseWords();
       reverseWords.reverseWords("the sky is blue");
    }

    public String reverseWords(String s) {
        if (s == null) return null;
        int i= s.length()-1, j=i;
        StringBuilder result = new StringBuilder();
        while(i>=0){
            while(i>=0&&!s.substring(i,i+1).equals(" ")){
                i--;
            }
            result.append(s.substring(i+1,j+1)+" ");
            while(i>=0 && s.substring(i,i+1).equals(" ")){
                i--;
            }
            j=i;

        }
        return result.toString().trim();
    }
}
