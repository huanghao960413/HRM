package com.hh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * 得到当前月份
     *
     * @return yyyy-MM
     */
    public static String getYearMonth() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
        return df.format(new Date());
    }

    /**
     * 得到当前日期
     *
     * @return yyyy-MM-dd
     */
    public static String getDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }

    /**
     * 得到当前时间
     *
     * @return HH-mm-ss
     */
    public static String getTime() {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        return df.format(new Date());
    }

    /**
     * 得到当前日期时间
     *
     * @return yyyy-MM-dd HH-mm-ss
     */
    public static String getDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    /**
     * 判断两个字符串格式的时间相差几分钟
     * @param date1
     * @param date2
     * @return
     */
    public static int differentTime(String date1, String date2) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        try {
            Date d1 = df.parse(date1);
            Date d2 = df.parse(date2);
            long minute = ((d2.getTime() - d1.getTime()) / (1000 * 60));
            return (int) minute;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 判断两个字符串格式的日期相差几天
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(String date1, String date2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = df.parse(date1);
            Date d2 = df.parse(date2);
            long day = ((d2.getTime() - d1.getTime()) / (1000 * 3600 * 24));
            return (int) day;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
