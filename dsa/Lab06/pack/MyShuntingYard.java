package Lab06.pack;
import java.util.Stack;

public class MyShuntingYard {
    private static int order(String c) {
        return switch (c) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }
    public static String infixToPostfix(String infixString) {
        String[] tokens = infixString.trim().split("\\s+");

        Stack<String> s = new Stack<>();               // stack s
        MyQueueL_670050<String> q = new MyQueueL_670050<>(); // queue q

        for (String t : tokens) {
            if (isNumber(t)) {
                // case t is a number:
                q.enqueue(t);
            } else if ("(".equals(t)) {
                // case t is "(":
                s.push(t);
            } else if (")".equals(t)) {
                // case t is ")":
                while (!s.isEmpty() && !"(".equals(s.peek())) {
                    q.enqueue(s.pop());
                }
                if (!s.isEmpty() && "(".equals(s.peek())) s.pop(); // pop "("
            } else {
                // case t is an operator:
                while (!s.isEmpty()
                        && !"(".equals(s.peek())
                        && order(s.peek()) >= order(t)) {
                    q.enqueue(s.pop());
                }
                s.push(t);
            }
        }

        while (!s.isEmpty()) q.enqueue(s.pop());

        // รวมคิวเป็นสตริง postfix
        StringBuilder out = new StringBuilder();
        for (var item : q) out.append(item).append(' ');
        return out.toString().trim();
    
    }

    private static boolean isNumber(String t) {
        return t.matches("\\d+(\\.\\d+)?");
    }
}