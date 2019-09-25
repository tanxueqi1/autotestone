package com.autoframework.tools;

import com.autoframework.logger.LoggerController;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    final static LoggerController log = LoggerController.getLogger(DateFormat.class);
    public static final String COMMON_DATE_FORMAT="yyyy-MM-dd";
    public static final String SHORT_DATE_FORMAT="yyyy-MM-dd HH:mm";
    public static final String SMALL_DATE_FORMAT="MM-dd";
    public static final String ABC_ORDER_DATE_FORMAT="yyyy/MM/dd";
    public static final String ABC_ORDER_TIME_FORMAT="HH:mm:ss";
    public static final String LOTTERY_PRINTING_TIME_FORMAT="HH_mm_ss";
    public static final String CHECK_LOG_FORMAT="yyyyMMdd";
    public static final String TEN_PAY_DATE_STRING_FORMAT="yyMMdd";
    public static final String REPORT_CSV_FORMAT="yyyyMMdd_HHmmss";
    public static final String ZH_DATE_FORMAT="yyyy年MM月dd日 HH:mm:ss";
    public static final String DEFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT="yyyy-MM-dd HH-mm-ss";

    private static SimpleDateFormat simpleDateFormat;

    public static String format(String type){
        simpleDateFormat=new SimpleDateFormat(type);
        log.info(simpleDateFormat.format(new Date()));
        return simpleDateFormat.format(new Date());
    }

    public static long time(){
        long t = System.currentTimeMillis();
        log.info(String.valueOf(t));
        return t;
    }
}
