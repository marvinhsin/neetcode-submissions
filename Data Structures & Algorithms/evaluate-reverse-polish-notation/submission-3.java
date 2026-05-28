class Solution {
public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) { // Iterate forward normally
            if (isOperator(token)) {
                // The first pop is the RIGHT operand, second is the LEFT
                int second = stack.pop();
                int first = stack.pop();
                stack.push(eval(first, second, token));
            } else {
                // It's a number, push it to the stack
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private int eval(int a, int b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }
}
