package com.yang.crm.commons.utlis;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 对date类型处理的工具类
 */
public class DateUtils {

    public static String formateDateTime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowStr = sdf.format(date);
        return nowStr;
    }
    public static String formateDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowStr = sdf.format(date);
        return nowStr;
    }
    public static String formateTime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String nowStr = sdf.format(date);
        return nowStr;
    }
}
