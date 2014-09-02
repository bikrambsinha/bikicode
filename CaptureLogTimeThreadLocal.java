/*
 * CaptureLogTimeThreadLocal.java
 */
/**
 * Subverion (SVN) information
 *
 * Author: Bikram Bhusan Sinha
 * Date: 09-02-2014
 */

package com.test.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

import com.test.data.ContextData;
import com.test.data.TimeData;


public class CaptureLogTimeThreadLocal {
	
	/* Use the thread-local variable */

    public static final ThreadLocal<ContextData> userThreadLocal = new ThreadLocal<ContextData>();
    
    /* This method will start the timer
     * @param methodName
     */

    public static void startTimer(final String methodName) {
        final SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        final String startTime = dataFormat.format(new Date());
        ContextData contextData = get();
        if (contextData == null) {
            contextData = new ContextData();
            contextData.setTransactionId(Thread.currentThread().getName());
        }
        TimeData tData = new TimeData();
        tData.setStartTime(startTime);
        contextData.getTransactionTimeMap().put(methodName, tData);
        set(contextData);
    }
    
    /* This method will set the context object in the thread-local variable
     * @param contextData
     */

    public static synchronized void set(final ContextData contextData) {
        userThreadLocal.set(contextData);
    }

    /* This method will unset the context object in the thread-local variable
     */
    
    public static synchronized void unset() {
        userThreadLocal.remove();
    }

    /* This method will get the context object from the thread-local variable
     * @return contextData
     */
    
    public static synchronized ContextData get() {
        return (ContextData) userThreadLocal.get();
    }

    /* This method will end the timer
     * @param methodName
     */
    
    public static void endTimer(final String methodName) {
    	final SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    	final String endTime = dataFormat.format(new Date());
        ContextData contextData = get();
        final TimeData timeData = contextData.getTransactionTimeMap().get(methodName);
        timeData.setEndTime(endTime);
    }
    
    /* This method will print the timing details
     */

    public static synchronized void printTimer() {
        final ContextData contextData = get();
        final SortedMap<String, TimeData> timerMap = contextData.getTransactionTimeMap();
        if (timerMap != null && timerMap.size() > 0) {
            final Set<Map.Entry<String, TimeData>> timerSet = timerMap.entrySet();
            final Iterator<Entry<String, TimeData>> iTimeData = timerSet.iterator();
            System.out.println("ThreadName : " + contextData.getTransactionId());
            while (iTimeData.hasNext()) {
                final Entry<String, TimeData> entryData = iTimeData.next();
                final String keyValue = entryData.getKey();
                final TimeData valData = entryData.getValue();
                String startTime = valData.getStartTime();
                String endTime = valData.getEndTime();
                System.out.println("MethodName : " + keyValue + "  " + "StartTime : " + startTime + "  " + "EndTime : "
                    + endTime);
                System.out.println("\n");
            }
            System.out.println("*************\n");
        }
        unset();
    }
}
