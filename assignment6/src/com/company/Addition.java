package com.company;

public class Addition implements Expression {
    private Expression a;
    private Expression b;

    public Addition(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int interpret() {
        return a.interpret() + b.interpret();
    }
}
