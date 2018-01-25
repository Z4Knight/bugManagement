package com.z4knight.bugmanagement.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author Z4knight
 * @Date 2018/1/5 17:15
 *
 * 日期生成工具类
 */
public class DateUtil {
    /**
     * 返回当前日期
     * 格式为： yyyy-mm-dd
     * @return String
     */
    public static String getCurrentDate() {
        LocalDate date = LocalDate.now();
        return date.toString();
    }

    public static String getCurrentTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        String[] ts = dateTime.toString().split("T");
        StringBuilder sb = new StringBuilder();
        sb.append(ts[0]);
        sb.append(" ");
        sb.append(ts[1].substring(0, 8));
        return sb.toString();
    }

//    public static void main(String args[]) {
//        System.out.println(getCurrentDate());
//    }
}
