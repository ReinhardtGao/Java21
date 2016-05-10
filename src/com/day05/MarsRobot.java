package com.day05;

class MarsRobot {
    String status;
    int speed;
    float temperature;

    MarsRobot(String status, int speed, int temperature) {
        this.status = status;
        this.speed = speed;
        this.temperature = temperature;
    }

    void checkTemperature() {
        if (temperature < -80) {
            status = "returning home";
            speed = 5;
        }
    }

    void showAttributes() {
        System.out.println("Status: " + status);
        System.out.println("Speed: " + speed);
        System.out.println("Temperature: " + temperature);
    }

    public static void main(String[] arguments) {
        MarsRobot spirit = new MarsRobot("exploring", 2, -60);
        spirit.showAttributes();
        System.out.println("Increasing speed to 3.");
        spirit.speed = 3;
        spirit.showAttributes();
        System.out.println("Changing temperature to -90");
        spirit.temperature = -90;
        spirit.showAttributes();
        System.out.println("Checking the temperature");
        spirit.checkTemperature();
        spirit.showAttributes();

        MarsRobot opportunity = new MarsRobot("exploring", 4, -80);
        opportunity.showAttributes();
    }
}
