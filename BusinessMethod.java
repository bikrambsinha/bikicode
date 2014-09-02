/*
 * BusinessMethod.java
 */
/**
 * Subverion (SVN) information
 *
 * Author: Bikram Bhusan Sinha
 * Date: 09-02-2014
 */

package com.test.business;

import com.test.util.CaptureLogTimeThreadLocal;

public class BusinessMethod {

    public void loopData(final int loopNumber) {
        //System.out.println("LoopNumber: " + loopNumber);
        CaptureLogTimeThreadLocal.startTimer("2-loopData");
        for (int i = 0; i < loopNumber; i++) {
        	//System.out.println("Data : " + loopNumber);
        }
        testData();
        CaptureLogTimeThreadLocal.endTimer("2-loopData");
    }
    
    private void testData() {
    	CaptureLogTimeThreadLocal.startTimer("3-testData");
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	CaptureLogTimeThreadLocal.endTimer("3-testData");
    }
}
