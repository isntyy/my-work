package com.yy.study.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * <p>
 * 日期工具类
 * jdk8之前，java使用Date表示时间，在做时间的格式化时，通常使用SimpleDateFormat,但是SimpleDateFormat是非线程安全的
 * jdk8发行后，提供了LocalDateTime,DateTimeFormatter等来处理时间，且都是线程安全的
 * </p>
 *
 * @author 张辉
 * @since 2018-12-24
 */
public class DateUtil {

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_SHORT_DATE_FORMAT = "yyyyMMdd";
    public static final String YYMMDDHH = "yyMMddHH";
    public static final String YYMMDD = "yyMMdd";

    /**
     * Date转换为格式化时间
     *
     * @param date    date
     * @param pattern 格式
     * @return
     */
    public static String format(Date date, String pattern) {
        return format(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()), pattern);
    }

    /**
     * localDateTime转换为格式化时间
     *
     * @param localDateTime localDateTime
     * @param pattern       格式
     * @return
     */
    public static String format(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(formatter);
    }

    /**
     * 格式化字符串转为Date
     *
     * @param date    格式化时间
     * @param pattern 格式
     * @return
     */
    public static Date parseDate(String date, String pattern) {
        return Date.from(parseLocalDateTime(date, pattern).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 格式化字符串转为LocalDateTime
     *
     * @param date    格式化时间
     * @param pattern 格式
     * @return
     */
    public static LocalDateTime parseLocalDateTime(String date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(date, formatter);
    }
}

