package org.concept.design;

public class OpenClosedPrinciple {
    /*
     * Classes should be open for extension
     * But closed for modification.
     * */
}

class Computer {
    //v1.0
    private String cpu;
    private String memory;
    private String storage;
    // Constructor Getters Setters

    //v1.1
    private String monitor;
    private String keyboard;

}

class Desktop extends Computer {
    //v2.0
    public void assembledDesktop() {
    }
}

class Laptop extends Computer {
    //v3.0
    public void assembledLaptop() {
    }
}
