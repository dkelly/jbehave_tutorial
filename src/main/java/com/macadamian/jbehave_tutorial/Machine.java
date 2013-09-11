package com.macadamian.jbehave_tutorial;

import java.util.HashMap;

public class Machine {
    private HashMap<String, Double> _prices = new HashMap<String, Double>();

    public Machine() {
        _prices.put("coke", 1.25);
        _prices.put("fanta", 0.75);
    }

    public Product buy(String name, double amount) {
        if (_prices.containsKey(name) && amount >= _prices.get(name)) {
            return new Product(name);
        }
        
        return null;
    }
}
