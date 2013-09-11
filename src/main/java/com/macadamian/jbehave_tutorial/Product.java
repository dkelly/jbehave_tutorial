package com.macadamian.jbehave_tutorial;

public class Product {
    String _name;

    public Product(String name) {
        _name = name;
    }

    public String name() {
        return _name;
    }
}
