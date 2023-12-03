package com.capstone.wfh.exception;

public class WfhException {
    public static final String DIFFERENTDATES = "You have provided different start and end date.";
    public static final String FUTUREDATES = "You have provided future dates.";
    public static final String WEEKENDDATES = "You have provided weekend dates.";
    public static final String INVALIDTIMES = "Start time should be less than end time.";
    public static final String INVALIDTOHOUR = "Provided end hour is greater than current hour.";
    public static final String INVALIDTOMINUTE = "Provided end minute is greater than current minute.";
    public static final String REQUESTEXISTS = "WFH Request already exists for given date.";
}
