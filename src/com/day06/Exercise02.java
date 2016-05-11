package com.day06;

class Exercise02 {
    public static void main(String[] arguments) {
        ZipCode code = new ZipCode("95135");
        System.out.println("Home Zip: " + code.getZipCode());

        ZipCode err = new ZipCode("24");
        System.out.println("Bad Zip: " + err.getZipCode());

        System.out.println("Setting bad zip to 94303");
        err.setZipCode("94303");
        System.out.println("Work Zip: " + err.getZipCode());

        System.out.println("Setting bad zip to 123");
        err.setZipCode("123");
        System.out.println("Short zip: " + err.getZipCode());

        System.out.println("Setting bad zip to 123456");
        err.setZipCode("123456");
        System.out.println("Long zip: " + err.getZipCode());
    }
}
