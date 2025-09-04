package pack;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class MyRPN_670050 {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    public static boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;
        return pattern.matcher(strNum).matches();
    }
    public static double computeRPN(String postfix) {
        StringTokenizer tk = new StringTokenizer(postfix);;
        MyStackA_670050<Double> stack = new MyStackA_670050<>();
        while (tk.hasMoreTokens()) {
            String t = tk.nextToken();
            if (isNumeric(t)) {
                System.out.println("operand=" + t + " ");
                stack.push(Double.parseDouble(t));
            }
            else {
                double b = stack.pop();
                double a = stack.pop();
                if (t.equals("*")) {
                    stack.push(a*b);
                } else if (t.equals("/")) {
                    stack.push(a/b);
                } else if (t.equals("+")) {
                    stack.push(a+b);
                } else if (t.equals("-")) {
                    stack.push(a-b);
                } 
            }
            //System.out.println("Stack =" + stack);
        }
        return stack.pop();
    }
}