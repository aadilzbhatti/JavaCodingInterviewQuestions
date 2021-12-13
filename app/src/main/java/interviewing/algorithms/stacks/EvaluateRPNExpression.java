package interviewing.algorithms.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Reverse Polish Notation, e.g.: "3, 4, +"
 */
public class EvaluateRPNExpression {

    private static final Set<String> OPERATIONS = new HashSet<>() {{
        add("+");
        add("-");
        add("x");
        add("/");
    }};

    public static double evaluateExpression(String expression) throws Exception {
        String[] tokens = expression.split(", ");
        Deque<Double> valStack = new ArrayDeque<>();
        for (String token : tokens) {
            if (OPERATIONS.contains(token)) {
                double e2 = popOrThrowErrorIfStackEmpty(valStack);
                double e1 = popOrThrowErrorIfStackEmpty(valStack);
                double res = evaluateOpWithArgs(token, e1, e2);
                valStack.push(res);

            } else {
                double val = getIfDouble(token);
                valStack.push(val);
            }
        }

        return popOrThrowErrorIfStackEmpty(valStack);
    }

    private static double getIfDouble(String token) throws Exception {
        try {
            return Double.parseDouble(token);
        } catch (NumberFormatException e) {
            throw new Exception("Invalid input in expression: " + token, e);
        }
    }

    private static double popOrThrowErrorIfStackEmpty(Deque<Double> stack) throws Exception {
        if (stack.isEmpty()) {
            throw new Exception("Invalid input passed to expresion");
        }
        return stack.pop();
    }

    private static double evaluateOpWithArgs(String op, double e1, double e2) throws Exception {
        switch (op) {
            case "+":
                return e1 + e2;
            case "-":
                return e1 - e2;
            case "x":
                return e1 * e2;
            case "/":
                return e1 / e2;
            default:
                throw new Exception("Invalid operation passed to evaluateOpWithArgs");
        }
    }
}
