package com.day06;

class ZipCode {
    private int zipCode;

    ZipCode(String zc) {
        if (zc.length() == 5) {
            zipCode = Integer.parseInt(zc);
        }
    }

    int getZipCode() {
        return zipCode;
    }

    void setZipCode(String zc) {
        if (zc.length() == 5) {
            zipCode = Integer.parseInt(zc);
        }
    }
}
