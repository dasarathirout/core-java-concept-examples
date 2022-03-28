package org.concept.multithreading.ex13;

import java.util.logging.Logger;

public class CreateMultipleThreads {
    private static Logger LOG = Logger.getLogger(CreateMultipleThreads.class.getName());

    public static void main(String[] args) {
        executeTX31();
    }

    public static void executeTX31() {
        NewThreadNT oneNT = new NewThreadNT("T1");
        NewThreadNT twoNT = new NewThreadNT("T2");
        NewThreadNT threeNT = new NewThreadNT("T3");
        oneNT.getCurrentThread().start();
        twoNT.getCurrentThread().start();
        threeNT.getCurrentThread().start();

        try {
            Thread.sleep(11111);
        }catch (Exception ex){
            LOG.severe(ex.getMessage());
        }finally {
            LOG.info("END MAIN()");
        }
    }
}

class NewThreadNT implements Runnable {
    private static Logger LOG = Logger.getLogger(NewThreadNT.class.getName());
    private Thread threadNT;
    private String nameNT;

    public NewThreadNT(String nameNT) {
        this.nameNT = "NT-" + nameNT;
        this.threadNT = new Thread(this, this.nameNT);
        LOG.info("New Thread : " + this.threadNT);
    }

    public Thread getCurrentThread() {
        return this.threadNT;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                LOG.info("RUN : " + this.nameNT + ": " + i);
                Thread.sleep(1111);
            }
        } catch (Exception ex) {
            LOG.severe(ex.getMessage());
        } finally {
            LOG.info("ENDS : " + this.nameNT);
        }
    }
}