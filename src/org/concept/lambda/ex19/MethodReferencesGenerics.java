package org.concept.lambda.ex19;

import org.concept.lambda.ex18.MethodReferencesLEX;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class MethodReferencesGenerics {
    private static final Logger LOG = Logger.getLogger(MethodReferencesGenerics.class.getName());
    private int size = 10;
    private static List<Integer> numbers = new ArrayList<>();
    private static List<String> names = new LinkedList<>();

    private static void init() {
        for (int i = 0; i < 10; i++) {
            numbers.add(10 + i);
        }

        for (int i = 0; i < 10; i++) {
            names.add("USER-" + i);
        }
        names.add("USER-" + 5);
        numbers.add(15);
    }

    public static <E> void executeLEX91(Match<E> match, List<E> list, E value) {
        match.searchCount(list, value);
    }

    public static void main(String[] args) {
        init();
        executeLEX91(MatchFounder::resultFound, numbers, 15);
        executeLEX91(MatchFounder::resultFound, names, "USER-5");
    }

}
