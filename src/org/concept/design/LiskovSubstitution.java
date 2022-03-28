package org.concept.design;

public class LiskovSubstitution {
    /*
     * if class SubClass is a subtype of class SuperClass,
     * We can replace SubClass with SuperClass
     * without disrupting the behavior of our program.
     * */
}

class Engine {
}

interface Car {
    void start(Engine engine);

    void stop(Engine engine);

    void run();

    void fillFuel();
}

class MotorCar implements Car {
    public void start(Engine engine) {
    }

    public void stop(Engine engine) {
    }

    public void run() {
    }

    public void fillFuel() {
    }
}

class ElectricCar implements Car {
    public void start(Engine engine) {
    }

    public void stop(Engine engine) {
    }

    public void run() {
    }

    public void chargeBattery() {
    }

    public void fillFuel() {
        //throw new RuntimeException("Un Supported Feature");
        chargeBattery();
    }
}