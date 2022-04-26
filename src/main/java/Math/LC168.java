package Math;

public class LC168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber>0){
            columnNumber--;
            char a = (char) ((columnNumber%26 )+'A');
            sb.append(a);
            columnNumber = columnNumber/26;
        }

    return sb.reverse().toString();
    }
}
