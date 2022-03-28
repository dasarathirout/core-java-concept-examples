package org.concept.lambda.ex13;

import java.util.logging.Logger;

interface NumberCompute {
    int evaluate(int iV1);
}

interface StringWork {
    String process(String inVal);
}

public class CodeBlockLEX {
    private static final Logger LOG = Logger.getLogger(CodeBlockLEX.class.getName());

    public static void main(String[] args) {
        executeLEX31();
        executeLEX32();
    }

    public static void executeLEX31() {
        NumberCompute computeFactorial;
        computeFactorial =
                (int iN) -> {
                    int factorialResult = 1;
                    for (int i = 1; i <= iN; i++) {
                        factorialResult = factorialResult * i;
                    }
                    return factorialResult;
                };
        LOG.info("computeFactorial(0) " + computeFactorial.evaluate(0));
        LOG.info("computeFactorial(5) " + computeFactorial.evaluate(5));
    }

    public static void executeLEX32() {
        StringWork reverseContent;
        reverseContent =
                (inData) -> {
                    String resultReverse = "";
                    for (int i = inData.length() - 1; i >= 0; i--) {
                        resultReverse += inData.charAt(i);
                    }
                    return resultReverse;
                };
        LOG.info("String Reverse (012345) " + reverseContent.process("012345"));
        LOG.info("String Reverse (ABC DEF) " + reverseContent.process("ABC DEF"));
    }
}
