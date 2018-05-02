package edu.black.util;

public interface Logger{

    public void error(String s);

    public void warn(String s);

    public void info(String s);

    public void debug(String s);

    public void trace(String s);

    public void error(String s, Throwable throwable);
}
