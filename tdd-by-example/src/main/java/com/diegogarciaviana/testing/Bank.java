package com.diegogarciaviana.testing;

import java.util.HashMap;

public class Bank {

    // Like a list
    private HashMap<Pair, Integer> rateMap = new HashMap();

    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    public void addRate(String from, String to, int rate) {
        rateMap.put(new Pair(from, to), rate);
    }

    public int rate(String from, String to) {

        if (from.equals(to))
            return 1;

        return rateMap.get(new Pair(from, to));

    }

}
