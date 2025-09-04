import java.util.Stack;

public class Solution_670050 {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        int i = 0;
        char ch;
        while (i < s.length()) {
            ch = s.charAt(i); 
            if (ch == '#' && !stack1.isEmpty()) {
                stack1.pop();
                continue;
            }
            stack1.push(ch);
            i++;
        }

        i = 0;
        while (i < t.length()) {
            ch = t.charAt(i);
            if (ch == '#' && !stack2.isEmpty()) {
                stack2.pop();
                continue;
            }
            stack2.push(ch);
            i++;
        }

        return stack1.equals(stack2);
    }
    
    public static void main(String[] args) {
        Solution_670050 solution = new Solution_670050();
        System.out.println(solution.backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(solution.backspaceCompare("ab##", "c#d#")); // true
        System.out.println(solution.backspaceCompare("a##c", "#a#c")); // true
        System.out.println(solution.backspaceCompare("a#c", "b")); // false
    }
}
