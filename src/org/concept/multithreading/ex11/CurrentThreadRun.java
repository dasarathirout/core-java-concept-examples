package org.concept.multithreading.ex11;

import java.util.logging.Logger;

public class CurrentThreadRun {
    private static Logger LOG = Logger.getLogger(CurrentThreadRun.class.getName());

    public static void main(String[] args) {
        executeTX11();
        executeTX12();
    }

    public static void executeTX11() {
        Thread currentThread = Thread.currentThread();
        LOG.info("CURRENT THREAD TX11: " + currentThread.toString());
        LOG.info("NAME : " + currentThread.getName());
        LOG.info("GROUP NAME : " + currentThread.getThreadGroup().getName());
        LOG.info("GROUP NAME COUNT: " + currentThread.getThreadGroup().activeGroupCount());
        LOG.info("ID : " + currentThread.getId());
        LOG.info("STATE : " + currentThread.getState());

        currentThread.setName("MAIN@RUN@THREAD");
        LOG.info("NAME : " + currentThread.toString());
    }

    public static void executeTX12() {
        Thread currentThread = Thread.currentThread();
        LOG.info("CURRENT THREAD TX12 : " + currentThread.toString());
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(5555);
                LOG.info("COUNTER SLEEPING COUNTER : " + i);
            }
        } catch (Exception ex) {
            LOG.info(ex.getMessage());
        } finally {

        }
    }
}
