package com.macadamian.jbehave_tutorial;

public class Machine {
    public Product buy(String name, double amount) {
        return new Product(name);
    }
}
