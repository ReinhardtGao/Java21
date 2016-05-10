package com.day05;

import java.awt.Point;

class FourDPoint extends Point {
    int z, w;

    FourDPoint(int x, int y, int z, int w) {
        super(x, y);
        this.z = z;
        this.w = w;
    }

    void viewCoordinates() {
        System.out.println("FourDPoint: ( " + x + " " + y + " " + z + " " + w + " )");
    }

    public static void main(String[] arguments) {
        FourDPoint p = new FourDPoint(5, 4, 9, 1);
        p.viewCoordinates();
    }
}
