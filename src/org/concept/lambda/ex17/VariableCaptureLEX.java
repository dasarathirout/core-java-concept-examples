package org.concept.lambda.ex17;

import java.util.logging.Logger;

public class VariableCaptureLEX {
    private static final Logger LOG = Logger.getLogger(VariableCaptureLEX.class.getName());

    private static int counterGlobal = 999;
    private int instanceVariableCounter = 99;

    interface ScopeCount {
        int increment(int localCounter);
    }

    public static void main(String[] args) {

        VariableCaptureLEX capture = new VariableCaptureLEX();
        capture.showValues();
        capture.executeLEX71();

    }

    public void showValues() {
        LOG.info("=====================================");
        LOG.info("GLOBAL : " + counterGlobal);
        LOG.info("INSTANCE : " + instanceVariableCounter);
        LOG.info("=====================================");
    }

    public void executeLEX71() {
        counterGlobal++;
        instanceVariableCounter++;
        // local variable enclosing scope
        int effectivelyFinalCounter = 0;
        this.showValues();
        effectivelyFinalCounter++;
        LOG.info("Effectively Final Counter : "+effectivelyFinalCounter);
        ScopeCount counter;
        counter = (localCounter) -> {
            localCounter++;
            counterGlobal++;
            instanceVariableCounter++;
            // effectivelyFinalCounter++;
            // Variable used in lambda expression should be final or effectively final
            LOG.info("LOCAL : " + localCounter);
            this.showValues();
            return localCounter;
        };
        counter.increment(10);
    }
}
