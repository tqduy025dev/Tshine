package com.tshine.server.common.utils;

import com.tshine.server.common.constants.AppConstants;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(AppConstants.DEFAULT_FORMAT_DATE);
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat(AppConstants.DEFAULT_FORMAT_DATE_TIME);

    public static String getStringTimeNow(){
        return DATE_FORMAT.format(new Date());
    }

    public static Timestamp getTimestampNow(){
        return new Timestamp(new Date().getTime());
    }

    public static String parseString(Date date){
        return date != null ? DATE_FORMAT.format(date) : "";
    }

    public static Date parseDate(String s) throws ParseException {
        return DATE_FORMAT.parse(s);
    }

    public static Timestamp parseTimestamp(String s) throws ParseException {
        long time = TimeUtils.parseDate(s).getTime();
        return new Timestamp(time);
    }

}
