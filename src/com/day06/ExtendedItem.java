package com.day06;

import org.cadenhead.ecommerce.Item;

class ExtendedItem extends Item {
    protected boolean noDiscount;

    protected ExtendedItem(String idIn, String nameIn,
            String retailIn, String qIn, boolean noD) {
        super(idIn, nameIn, retailIn, qIn);
        noDiscount = noD;
        // Determine whether or not to sell the item at retail price.
        if (noDiscount) {
            price = retail;
        }
    }

    protected boolean isNoDiscount() {
        return noDiscount;
    }
}