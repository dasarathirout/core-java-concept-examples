package org.concept.multithreading.ex14;

import java.util.Random;
import java.util.concurrent.Callable;

@SuppressWarnings("unchecked")
public class NextRandomInteger implements Callable {
    @Override
    public Integer call() throws Exception {
        Integer nextRandomInteger = new Random().nextInt(5);
        Thread.sleep(nextRandomInteger * 1000);
        return nextRandomInteger;
    }
}
