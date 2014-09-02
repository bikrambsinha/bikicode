/*
 * TestThreadLocalTimer.java
 */
/**
 * Subverion (SVN) information
 *
 * Author: Bikram Bhusan Sinha
 * Date: 09-02-2014
 */

package com.test.main;

import com.test.business.BusinessMethod;
import com.test.util.CaptureLogTimeThreadLocal;

public class TestThreadLocalTimer extends Thread {

    private int loopNumber = 0;

    public int getLoopNumber() {
        return loopNumber;
    }

    public void setLoopNumber(final int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public TestThreadLocalTimer(final int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public static void main(final String args[]) {

        final Thread threadOne = new TestThreadLocalTimer(100);
        threadOne.start();

        final Thread threadTwo = new TestThreadLocalTimer(200);
        threadTwo.start();
        
        final Thread threadThree = new TestThreadLocalTimer(200);
        threadThree.start();
    }

    @Override
    public void run() {
        CaptureLogTimeThreadLocal.startTimer("1-Main Method");
        new BusinessMethod().loopData(loopNumber);
        CaptureLogTimeThreadLocal.endTimer("1-Main Method");
        CaptureLogTimeThreadLocal.printTimer();
    }
}
