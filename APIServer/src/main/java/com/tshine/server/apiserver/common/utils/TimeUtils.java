package com.tshine.server.apiserver.common.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.tshine.server.apiserver.common.constants.AppConstants.DEFAULT_FORMAT_DATE;
import static com.tshine.server.apiserver.common.constants.AppConstants.DEFAULT_FORMAT_DATE_TIME;

public class TimeUtils {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(DEFAULT_FORMAT_DATE);
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat(DEFAULT_FORMAT_DATE_TIME);

    public static String getStringTimeNow(){
        return DATE_FORMAT.format(new Date());
    }

    public static Timestamp getTimestampNow(){
        return new Timestamp(new Date().getTime());
    }

    public static String parseString(Date date){
        return date != null ? DATE_FORMAT.format(date) : "";
    }

    public static Date parseTimestamp(String s) throws ParseException {
        return DATE_FORMAT.parse(s);
    }

}
