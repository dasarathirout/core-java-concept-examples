package org.concept.lambda.ex19;

import java.util.List;
import java.util.logging.Logger;

interface Match<E> {
    public int searchCount(List<E> list, E value);
}

public class MatchFounder {
    private static final Logger LOG = Logger.getLogger(MatchFounder.class.getName());
    static <E> int resultFound(List<E> lists, E value) {
        int count = 0;
        for (E element : lists) {
            if (element == value || element.equals(value)) {
                count++;
                LOG.info(element.toString());
            }
        }
        LOG.info("TOTAL : "+count);
        return count;
    }
}