package org.concept.streams.ex11;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class BaseStreamsInterface {
    private static Logger LOG = Logger.getLogger(BaseStreamsInterface.class.getName());
    private static final Random RANDOM = new Random();
    private static final Integer SIZE = 20;

    public static void main(String[] args) {
        executeEx11();
    }

    private static void executeEx11() {
        //=============================================================
        ArrayList<Integer> integerList = new ArrayList<>(SIZE);
        for (int i = 1; i <= SIZE; i++) {
            integerList.add(RANDOM.nextInt(i));
        }
        //=============================================================
        Stream<Integer> integerStream = integerList.stream();
        Optional<Integer> minValue = integerStream.min(Integer::compare);

        LOG.info(integerList.toString());
        if (minValue.isPresent()) {
            LOG.info("MIN : " + minValue.get());
        }
        //=============================================================
        // Must Obtain New Stream: IllegalStateException
        integerStream = integerList.stream();
        Optional<Integer> maxValue = integerStream.max(Integer::compare);
        if (maxValue.isPresent()) {
            LOG.info("MAX : " + maxValue.get());
        }
        //=============================================================
        Stream<Integer> integerSortedStream = integerList.stream().sorted();
        integerSortedStream.forEach(n -> System.out.print(n + ", "));
        System.out.println();
        //=============================================================
        Stream<Integer> integerEvenStream = integerList
                .stream()
                .sorted()
                .filter(n -> n % 2 == 0);
        integerEvenStream.forEach(n -> System.out.print(n + ", "));
        System.out.println();
        //=============================================================
        Stream<Integer> integerEvenStreamGT5 = integerList
                .stream()
                .sorted()
                .filter(n -> n % 2 == 0)
                .filter(n -> n >= 5);
        integerEvenStreamGT5.forEach(n -> System.out.print(n + ", "));
        System.out.println();
    }
}
