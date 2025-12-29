import java.util.Stack;

public class validParentheses {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(char c:s.toCharArray()){
            if(c=='{'||c=='['||c=='('){
                stack.push(c);
            }
            else if(c=='}'||c==']'||c==')'){
                if(stack.isEmpty()){
                    return false;
                }
                char top=stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        //list is valid only if the stack is empty at the end
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "([)]";
        String s3 = "{[]}";
        String s4 = "(((";

        System.out.println(s1 + " -> " + isValid(s1)); // true
        System.out.println(s2 + " -> " + isValid(s2)); // false
        System.out.println(s3 + " -> " + isValid(s3)); // true
        System.out.println(s4 + " -> " + isValid(s4)); // false
    }

}
