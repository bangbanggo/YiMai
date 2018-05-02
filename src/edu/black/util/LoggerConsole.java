package edu.black.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerConsole implements Logger {
    DateFormat df = new SimpleDateFormat(" yyyy-MM-DD hh:mm:ss ");
    @Override
    public void error(String s) {
        System.out.println("ERROR:"+df.format(new Date())+s);
    }

    @Override
    public void warn(String s) {
        System.out.println("WARN:"+df.format(new Date())+s);
    }

    @Override
    public void info(String s) {
        System.out.println("INFO:"+df.format(new Date())+s);
    }

    @Override
    public void debug(String s) {
        System.out.println("DEBUG:"+df.format(new Date())+s);
    }

    @Override
    public void trace(String s) {
        System.out.println("TRACE:"+df.format(new Date())+s);
    }

    @Override
    public void error(String s, Throwable throwable) {
        System.out.println("DEBUG:"+df.format(new Date())+s+throwable);
    }
}
