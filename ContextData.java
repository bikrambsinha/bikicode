/*
 * ContextData.java
 */
/**
 * Subverion (SVN) information
 *
 * Author: Bikram Bhusan Sinha
 * Date: 09-02-2014
 */

package com.test.data;

import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

public class ContextData {
    private String transactionId = null;
    private SortedMap<String, TimeData> transactionTimeMap = new TreeMap<String, TimeData>();

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(final String threadId) {
        @SuppressWarnings("unused")
		final int randomNumber = new Random().nextInt();
        this.transactionId = threadId ;//+ String.valueOf(randomNumber);
    }

    public SortedMap<String, TimeData> getTransactionTimeMap() {
        return transactionTimeMap;
    }

    public void setTransactionTimeMap(final SortedMap<String, TimeData> transactionTimeMap) {
        this.transactionTimeMap = transactionTimeMap;
    }
}
