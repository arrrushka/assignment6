package com.company;

public class Substraction implements Expression {
    private Expression a;
    private Expression b;

    public Substraction(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int interpret() {
        return a.interpret() - b.interpret();
    }
}