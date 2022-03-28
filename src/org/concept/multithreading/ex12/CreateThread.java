package org.concept.multithreading.ex12;

import java.util.logging.Logger;

public class CreateThread {
    private static Logger LOG = Logger.getLogger(CreateThread.class.getName());

    public static void main(String[] args) {
        executeTX21();// Start RT1 & Continue.
        executeTX22();// Start RT2 & Continue.
        executeTX20();// Run Main Loop
    }

    public static void executeTX20() {
        Thread currentThread = Thread.currentThread();
        LOG.info("FROM TX21 : " + currentThread);
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1111);
                LOG.info("MAIN LOOP : " + i);
            }
        } catch (Exception ex) {
            LOG.severe(ex.getMessage());
        } finally {
            LOG.info("MAIN LOOP ENDS");
        }
    }

    public static void executeTX21() {
        Thread currentThread = Thread.currentThread();
        LOG.info("FROM TX22 : " + currentThread);
        ThreadRT1 oneRT = new ThreadRT1();
        oneRT.runnableThread.start();
    }

    public static void executeTX22() {
        LOG.info("FROM TX23 : ");
        ThreadRT2 twoRT = new ThreadRT2("TX22");
        twoRT.start();
    }
}

class ThreadRT1 implements Runnable {
    private static Logger LOG = Logger.getLogger(ThreadRT1.class.getName());
    public Thread runnableThread;

    public ThreadRT1() {
        runnableThread = new Thread(this, "RT-ONE");
        LOG.info("CHILD THREAD : " + runnableThread);
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1111);
                LOG.info("RT-ONE RUN : " + i);
            }
        } catch (Exception ex) {
            LOG.severe(ex.getMessage());
        } finally {
            LOG.info("TR-ONE RUN ENDS.");
        }
    }
}

class ThreadRT2 extends Thread {
    private static Logger LOG = Logger.getLogger(ThreadRT2.class.getName());

    public ThreadRT2() {
        super("RT-TWO");
    }

    public ThreadRT2(String runnerName) {
        super("RT-TWO-" + runnerName);
    }

    @Override
    public void run() {
        LOG.info("RUN() : "+Thread.currentThread());
        try {
            for (int i = 0; i < 3; i++) {
                LOG.info("TR-TWO RUN : " + i);
                Thread.sleep(1111);
            }
        } catch (Exception ex) {
            LOG.severe(ex.getMessage());
        } finally {
            LOG.info("RT-TWO RUN ENDS.");
        }
    }
}