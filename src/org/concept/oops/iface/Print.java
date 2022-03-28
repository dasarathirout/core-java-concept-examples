package org.concept.oops.iface;

public interface Print {
    public void write(String content);

    static void show() {
        System.out.println("Print.show()");
    }
}
