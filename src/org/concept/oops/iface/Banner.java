package org.concept.oops.iface;

public class Banner implements Display, Print {
    public static void main(String[] arrays) {
        example11();
    }

    public static void example11() {
        Banner banner = new Banner();
        banner.write("In Example-11");
        Display.show();
        Print.show();

        Print print = new Banner();
        print.write("Print");

        Display display = new Banner();
        display.write("Display");
    }

    @Override
    public void write(String content) {
        System.out.println("Banner.write() " + content);
    }

    public void show() {
        Print.show();
        Display.show();
    }
}
