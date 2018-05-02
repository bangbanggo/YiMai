package edu.black.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    static DateFormat df = null;
    public static String getDate(){
        df = new SimpleDateFormat("yyMMddhhmmss");
        String result = df.format(new Date());
        df = null;
        return result;
    }
}
