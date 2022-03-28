package org.concept.lambda.ex15;

import java.util.Arrays;
import java.util.logging.Logger;

public class ArgumentsLEX {
    private static final Logger LOG = Logger.getLogger(ArgumentsLEX.class.getName());

    interface ArrayPrint {
        String showAll(String[] inArray);
    }

    public static String displayArrayContents(ArrayPrint printContents, String[] inArray) {
        return printContents.showAll(inArray);
    }

    public static void main(String[] args) {
        executeLEX51();
        executeLEX52();
    }

    public static void executeLEX51() {
        String[] inStrAry = {"Google", "Microsoft", "Search Engine"};
        String result = displayArrayContents(
                (inAry) -> {
                    for (int i = 0; i < inAry.length; i++) {
                        inAry[i] = inAry[i].toUpperCase();
                    }
                    return Arrays.toString(inAry);
                }
                , inStrAry
        );
        LOG.info("Arguments LEX : " + result);
    }


    public static void executeLEX52() {
        String[] inStrAry = {"Google", "Microsoft", "Search Engine","9876543210"};
        String result = displayArrayContents(
                (inAry) -> {
                    for (int i = 0; i < inAry.length; i++) {
                        inAry[i] = String.valueOf(new StringBuffer(inAry[i].toUpperCase()).reverse());
                    }
                    return Arrays.toString(inAry);
                }
                , inStrAry
        );
        LOG.info("Arguments LEX Reverse  : " + result);
    }
}
