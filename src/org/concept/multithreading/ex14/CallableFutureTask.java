package org.concept.multithreading.ex14;

import java.util.concurrent.FutureTask;

public class CallableFutureTask {

    public static FutureTask<NextRandomInteger>[] randomNumberTasks = new FutureTask[5];

    public static void main(String[] arrays) throws Exception {
        futureTaskListGetResult();
    }

    public static void futureTaskListGetResult() throws Exception {

        for (int i = 0; i < 5; i++) {
            NextRandomInteger nextRandomInteger = new NextRandomInteger();
            randomNumberTasks[i] = new FutureTask<>(nextRandomInteger);
            Thread thread = new Thread(randomNumberTasks[i]);
            thread.start();
            System.out.println(randomNumberTasks[i].get());
        }
    }
}

