package com.macadamian.jbehave_tutorial;

import java.util.HashMap;

public class Machine {
    private class Info {
        double price;
        boolean stocked;
    }

    private HashMap<String, Info> _stock = new HashMap<String, Info>();

    public Machine() {
        _stock.put("coke", new Info() {{ price = 1.25; }});
        _stock.put("fanta", new Info() {{ price = 0.75; }});
    }

    public void stock(String name, boolean inStock) {
        if (_stock.containsKey(name)) {
            _stock.get(name).stocked = inStock;
        }
    }

    public Product buy(String name, double amount) {
        Product rv = null;

        if (_stock.containsKey(name)) {
            Info i = _stock.get(name);
            if (i.stocked && amount >= i.price) {
                rv = new Product(name);
            }
        }
        
        return rv;
    }
}
