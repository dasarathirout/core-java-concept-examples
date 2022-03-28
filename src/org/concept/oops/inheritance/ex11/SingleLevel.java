package org.concept.oops.inheritance.ex11;

import java.util.logging.Logger;

public class SingleLevel {
    private static Logger LOG = Logger.getLogger(SingleLevel.class.getName());

    public static void main(String[] args) {
        executeC11();
        executeC12();
    }

    public static void executeC11() {
        Parent parentR1 = new Parent();
        Parent.funPS1();
        parentR1.funPNS2();
        parentR1.showMe();
    }

    public static void executeC12() {
        Child childR1 = new Child();
        childR1.funPNS2();
        childR1.showMe();
    }

    public static void executeC13() {
        Parent parentR2 = new Child();
        parentR2.funPNS2();
        parentR2.showMe();
    }
}

class Parent {
    private static Logger LOG = Logger.getLogger(Parent.class.getName());

    public static void funPS1() {
        LOG.info("funPS1()");
    }

    public void funPNS2() {
        LOG.info("funPNS2()");
    }

    public void showMe() {
        LOG.info("showMe()");
    }
}

interface Display {
    void showMe();
}

class Child extends Parent implements Display {
    private static Logger LOG = Logger.getLogger(Child.class.getName());

    public void funCNS3() {
        LOG.info("funCNS3()");
    }
}
