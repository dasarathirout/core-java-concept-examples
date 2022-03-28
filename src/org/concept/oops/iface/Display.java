package org.concept.oops.iface;

public interface Display {
    public void write(String content);

    static void show() {
        System.out.println("Display.show()");
    }
}
