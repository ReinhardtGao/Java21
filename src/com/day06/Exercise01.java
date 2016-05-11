package com.day06;

class Exercise01 {
    public static void main(String[] arguments) {
        ExtendedStorefront store = new ExtendedStorefront();
        store.addItem("C01", "MUG", "9.99", "150", true);
        store.addItem("C02", "LG MUG", "12.99", "82", false);
        store.addItem("C03", "MOUSEPAD", "10.49", "800", true);
        store.addItem("D01", "T SHIRT", "16.99", "90", true);
        store.sort();

        for (int i = 0; i < store.getSize(); i++) {
            ExtendedItem show = store.getItem(i);
            System.out.println("\nItem ID: " + show.getId() +
                "\nName: " + show.getName() +
                "\nRetail Price: $" + show.getRetail() +
                "\nPrice: $" + show.getPrice() +
                "\nQuantity: $" + show.getQuantity() +
                "\nNo Discount: " + show.isNoDiscount());
        }
    }
}
