package org.concept.lambda.ex16;

import java.util.Arrays;
import java.util.logging.Logger;

public class LambdaWithExceptions {
    private static final Logger LOG = Logger.getLogger(LambdaWithExceptions.class.getName());

    static class EmptyArrayException extends Exception {

        public EmptyArrayException(String message) {
            super(message);
        }

        @Override
        public String getMessage() {
            return super.getMessage();
        }
    }

    interface Traversal<T extends Number> {
        T sum(T[] arrayT1) throws EmptyArrayException;
    }

    public static void main(String[] args) {
        executeLEX61();
    }

    public static void executeLEX61() {
        Traversal<Integer> integerAryTraversal;
        integerAryTraversal = (inAry) -> {
            switch (inAry.length) {
                case 0:
                    throw new EmptyArrayException("Array Has No Elements");
                case 1:
                    throw new EmptyArrayException("Only One Elements, So No Sum.");
                default:
                    LOG.info("Integer Array Contents : " + Arrays.toString(inAry));
            }
            for (int i = 1; i < inAry.length; i++) {
                inAry[i] = inAry[i] + inAry[i - 1];
            }
            LOG.info("Integer Array Sum : " + inAry[inAry.length - 1]);
            return inAry[inAry.length - 1];
        };

        Integer[] inEmptyAry = {};
        try {
            integerAryTraversal.sum(inEmptyAry);
        } catch (Exception ex) {
            LOG.info(ex.getMessage());
        }

        Integer[] inAryOne = {10};
        try {
            integerAryTraversal.sum(inAryOne);
        } catch (Exception ex) {
            LOG.info(ex.getMessage());
        }

        Integer[] inAry = {10, 20, 30, 40, 50};
        try {
            integerAryTraversal.sum(inAry);
        } catch (Exception ex) {
            LOG.info(ex.getMessage());
        }
    }

}
