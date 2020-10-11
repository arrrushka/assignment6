package com.company;

import java.util.Stack;

public class Parser {
    public static int Parse(String expression) {
        Stack stack = new Stack();
        String[] array = expression.split(" ");

        for (int i = 0; i < array.length; i++) {
            if (isOperator(array[i])) {
                Expression a = (Expression) stack.pop();
                Expression number = new Number(array[i + 1]);
                stack.push((number));
                Expression b = (Expression) stack.pop();
                Expression operator = getOperatorInstance(array[i], a, b);
                i = i + 1;
                int result = operator.interpret();
                stack.push(new Number(result));
            } else {
                Expression number = new Number(array[i]);
                stack.push(number);
            }
        }
        return (((Expression) stack.pop()).interpret());
    }

    public static boolean isOperator(String string) {
        if (string.equals("+") || string.equals("-") || string.equals("*")) {
            return true;
        } else {
            return false;
        }
    }


    public static Expression getOperatorInstance(String str, Expression a, Expression b) {
        return switch (str) {
            case "+" -> new Addition(a, b);
            case "-" -> new Substraction(a, b);
            case "*" -> new Multiplication(a, b);
            default -> null;
        };
    }

    public static void main(String[] args) {
        String expression = "1 + 2 - 3 * 4 * 5";
        System.out.println(Parse(expression));
    }
}
