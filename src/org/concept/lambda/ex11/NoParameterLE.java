package org.concept.lambda.ex11;

import java.util.Random;
import java.util.logging.Logger;

// ======================================================================== //
interface VoidPrintOnly {
    void show();
}

interface RandomNumber {
    int getLuckyInteger();
}

// ======================================================================== //

public class NoParameterLE {

    private static final Logger LOG = Logger.getLogger(NoParameterLE.class.getName());

    public static void main(String[] args) {
        executeLEX11();
        executeLEX12();
        executeLEX13();
        executeLEX14();
    }

    public static void executeLEX11() {
        VoidPrintOnly printOnly;
        printOnly = () -> LOG.info("INSIDE LEX VOID !");
        printOnly.show();
    }

    public static void executeLEX12() {
        RandomNumber luckInteger;
        luckInteger = () -> 12345;
        LOG.info("LUCKY INTEGER : " + luckInteger.getLuckyInteger());
    }

    public static void executeLEX13() {
        RandomNumber randomInteger;
        randomInteger =
                () -> {
                    return new Random().nextInt(99999);
                };
        LOG.info("RANDOM INTEGER : " + randomInteger.getLuckyInteger());
    }

    public static void executeLEX14() {
        Runnable runnableThread;
        runnableThread =
                () -> {
                    for (int i = 0; i <= 1; i++) {
                        LOG.info("RUNNABLE : " + i);
                    }
                };
        runnableThread.run();
    }
}
// ======================================================================== //
