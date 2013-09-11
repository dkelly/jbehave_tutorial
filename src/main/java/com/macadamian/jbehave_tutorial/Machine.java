package com.macadamian.jbehave_tutorial;

import java.util.HashMap;

public class Machine {
    public Machine() {
    }

    public Product buy(String name, double amount) {
        return new Product(name);
    }
}
