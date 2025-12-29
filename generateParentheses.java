/*n represent the pair of parentheses*/
import java.util.ArrayList;
import java.util.List;
public class generateParentheses {

    private static void backtrack(StringBuilder current, int open, int close, int n, List<String> result) {
        // If the length is 2*n, we have used all parentheses
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // We can always add '(' if we still have some left
        if (open < n) {
            current.append('(');
            backtrack(current, open + 1, close, n, result);
            current.deleteCharAt(current.length() - 1); // backtrack
        }

        // We can only add ')' if there are more '(' than ')' used
        if (close < open) {
            current.append(')');
            backtrack(current, open, close + 1, n, result);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
    public void  generateParentheses(int n){
        int leftCount=0;
        int rightCount=-0;

    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n, result);
        return result;
    }

    public static void main(String[] args) {
        int n = 3; // change this to any n you want
        List<String> result = generateParenthesis(n);

        for (String s : result) {
            System.out.println(s);
        }
    }
}
