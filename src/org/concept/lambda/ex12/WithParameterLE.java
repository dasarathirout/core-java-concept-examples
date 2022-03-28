package org.concept.lambda.ex12;

import java.util.logging.Logger;

interface NumericSign {
    boolean check(int inValue);
}

interface NumericCompute {
    boolean check(int inV1, int inV2);
}

public class WithParameterLE {

    private static final Logger LOG = Logger.getLogger(WithParameterLE.class.getName());

    public static void main(String[] arrays) {
        executeLEX21();
        executeLEX22();
        executeLEX23();
    }

    public static void executeLEX21() {
        NumericSign signPositive;
        signPositive =
                (inValue) -> {
                    LOG.info("Positive Sign Check.");
                    return inValue >= 0;
                };
        LOG.info("isPositive (1) " + signPositive.check(1));
        LOG.info("isPositive (-1) " + signPositive.check(-1));
    }

    public static void executeLEX22() {
        NumericSign isEven;
        isEven =
                (int inValue) -> {
                    LOG.info("CHECK EVEN ODD");
                    return (inValue % 2 == 0);
                };

        LOG.info("isEven (0) " + isEven.check(0));
        LOG.info("isEven (1) " + isEven.check(1));
        LOG.info("isEven (2) " + isEven.check(2));
    }

    public static void executeLEX23() {
        NumericCompute isFactor;
        isFactor =
                (int iV1, int iV2) -> {
                    LOG.info("CHECK FACTOR");
                    return (iV1 % iV2 == 0);
                };

        // LOG.info("isFactor (0 , 0) " + isFactor.check(0, 0));
        LOG.info("isFactor (4 , 2) " + isFactor.check(4, 2));
        LOG.info("isFactor (2 , 2) " + isFactor.check(2, 2));
        LOG.info("isFactor (3 , 2) " + isFactor.check(3, 2));
    }
}
