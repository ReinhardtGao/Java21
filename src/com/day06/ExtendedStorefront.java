package com.day06;

import org.cadenhead.ecommerce.Item;
import org.cadenhead.ecommerce.Storefront;

class ExtendedStorefront extends Storefront {

    public void addItem(String id, String name,
            String price, String quant, boolean noD) {
        ExtendedItem it = new ExtendedItem(id, name, price, quant, noD);
        catalog.add(it);
    }

    public ExtendedItem getItem(int i) {
        return (ExtendedItem) catalog.get(i);
    }
}
