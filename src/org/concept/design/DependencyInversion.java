package org.concept.design;

public class DependencyInversion {
    /*
     * Decoupling of software modules & abstractions.
     **/
}

interface PersonalComputer {
}

interface Monitor {
}

interface KeyBoard {
}

class UserPC implements PersonalComputer {
    private final KeyBoard keyboard;
    private final Monitor monitor;

    /*
    *
    public UserPC() {
        this.monitor = new Monitor();
        this.keyboard = new KeyBoard();
    }
     * Using new keyword, tightly coupled these three classes together.
     * */

    public UserPC(Monitor monitor, KeyBoard keyboard){
        this.monitor= monitor;
        this.keyboard=  keyboard;
    }

}