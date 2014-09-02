/*
 * TimeData.java
 */
/**
 * Subverion (SVN) information
 *
 * Author: Bikram Bhusan Sinha
 * Date: 09-02-2014
 */

package com.test.data;

public class TimeData {
    private String startTime;
    private String endTime;

//    /**
//     * @param endTime
//     */
//    public TimeData(String startTime, String endTime) {
//        startTime = this.startTime;
//        endTime = this.endTime;
//    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(final String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(final String endTime) {
        this.endTime = endTime;
    }
}
