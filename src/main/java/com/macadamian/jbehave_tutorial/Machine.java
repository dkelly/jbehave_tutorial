package com.macadamian.jbehave_tutorial;

import java.util.HashMap;

public class Machine {
    private class Info {
        double price;
        int stock;

        public boolean stocked() {
            return stock > 0;
        }

        public void destock() {
            stock -= 1;
        }
    }

    private HashMap<String, Info> _stock = new HashMap<String, Info>();
    private double _current_change;

    public Machine() {
        _stock.put("coke", new Info() {{ price = 1.25; stock = 2; }});
        _stock.put("fanta", new Info() {{ price = 0.75; stock = 2; }});
    }

    public void stock(String name, int number) {
        if (_stock.containsKey(name)) {
            _stock.get(name).stock = number;
        }
    }

    public Product buy(String name, double amount) {
        Product rv = null;

        if (_stock.containsKey(name)) {
            Info i = _stock.get(name);
            if (i.stocked() && amount >= i.price) {
                rv = new Product(name);
                _current_change = amount - i.price;
                i.destock();
            } else {
                _current_change = amount;
            }
        }
        
        return rv;
    }

    public double current_change() {
        return _current_change;
    }
}
