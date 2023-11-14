public class TuringSolution {
    public int solution(String digits, String num) {
        char[] chars = num.toCharArray();
        int lastindex = 0;
        int count = 0;
        for (char c : chars) {
            int index = digits.indexOf(c);
            count = count + Math.abs(index - lastindex);
            lastindex = index;
        }
        return count;

    }
}
