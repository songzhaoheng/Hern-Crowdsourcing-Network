package com.hern.commons;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description 判断字符串是否为空，如果为空则返回true，否则返回false
 * @Author Hern
 * @Date 2019-06-07 13:30
 * */
public class StringUtils {

    // yyyy-MM-dd
    public static String formatSimpleDate(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }


    public static boolean isEmpty(String string){

        if (string == null){
            return true;
        }else if (string.trim().equals("")){
            return true;
        }

        return false;
    }
}
