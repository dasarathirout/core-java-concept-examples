package org.concept.streams.ex12;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Logger;

public class StreamReductionOperations {
    private static Logger LOG = Logger.getLogger(StreamReductionOperations.class.getName());
    private static final Random RANDOM = new Random();
    private static final Integer SIZE = 5;

    public static void main(String[] args) {
        executeEx21();
        executeEx22();
    }

    private static void executeEx21() {
        //=============================================================
        ArrayList<Integer> integerList = new ArrayList<>(SIZE);
        for (int i = 1; i <= SIZE; i++) {
            integerList.add(1 + RANDOM.nextInt(i));
        }
        LOG.info(integerList.toString());
        //=============================================================
        Optional<Integer> productOptional = integerList.stream()
                .reduce((n1, n2) -> n1 * n2);
        if (productOptional.isPresent()) {
            LOG.info("Product Optional Value :" + productOptional.get());
            int productValue = integerList
                    .stream()
                    .reduce(1, (n1, n2) -> n1 * n2);
            LOG.info("Product All :" + productValue);
        }
        //=============================================================
        int evenProduct = integerList.stream().reduce(1, (n1, n2) -> {
            if (n2 % 2 == 0) {
                return n1 * n2;
            } else {
                return n1;
            }
        });
        LOG.info("Even Product :" + evenProduct);
        //=============================================================
    }

    private static void executeEx22() {
        //=============================================================
        ArrayList<Double> doubleList = new ArrayList<>(SIZE);
        for (int i = 1; i <= SIZE; i++) {
            doubleList.add((double) (i * i));
        }
        LOG.info(doubleList.toString());
        //=============================================================
        double squareRoots = doubleList.parallelStream().
                reduce(1.0,
                        (n1, n2) -> {
                            return n1 * Math.sqrt(n2);
                        },
                        (n1, n2) -> {
                            return n1 * n2;
                        }
                );
        LOG.info("SquareRoots : " + squareRoots);
        //=============================================================
    }
}
